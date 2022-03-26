package pro.skypro.course3.ru.hogwarts.school.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pro.skypro.course3.ru.hogwarts.school.model.Avatar;
import pro.skypro.course3.ru.hogwarts.school.model.Student;
import pro.skypro.course3.ru.hogwarts.school.repository.AvatarRepository;
import pro.skypro.course3.ru.hogwarts.school.service.AvatarService;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Service
public class AvatarServiceImpl implements AvatarService {

    private static final Logger log = LoggerFactory.getLogger(AvatarServiceImpl.class);

    public static final int IMAGE_BLOCK_BUFFER_SIZE = 1024;

    @Value("${path.to.avatars.folder}")
    private String avatarsDir;

    private final AvatarRepository repository;
    private final StudentService studentService;

    public AvatarServiceImpl(AvatarRepository repository, StudentService studentService) {
        this.repository = repository;
        this.studentService = studentService;
    }

    @Override
    public Long uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException {
        log.info("Was invoked method to upload avatar for student: {}", studentId);
        Student student = studentService.find(studentId);
        if (student == null) {
            String errMsg = "Student with id does not exist: " + studentId;
            log.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Path filePath = createImageFilePath(avatarFile, student);
        saveImageToFile(avatarFile, filePath);

        Avatar avatar = findOrCreateAvatar(studentId);
        updateAvatar(avatarFile, student, filePath, avatar);
        return repository.save(avatar).getId();
    }

    @Override
    public Avatar findAvatar(Long id) {
        log.info("Was invoked method to find by id: {}", id);
        return repository.getById(id);
    }

    @Override
    public List<Avatar> getAvatarPage(int page, int size) {
        log.info("Was invoked method to get avatars page {} of size {}", page, size);
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return repository.findAll(pageRequest).toList();
    }

    private Path createImageFilePath(MultipartFile avatarFile, Student student) throws IOException {
        Path filePath = Path.of(avatarsDir, student + "." + getExtensions(avatarFile.getOriginalFilename()));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);
        return filePath;
    }

    private void saveImageToFile(MultipartFile avatarFile, Path filePath) throws IOException {
        try (
                BufferedInputStream bis = new BufferedInputStream(avatarFile.getInputStream(), IMAGE_BLOCK_BUFFER_SIZE);
                BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(filePath, StandardOpenOption.CREATE_NEW), IMAGE_BLOCK_BUFFER_SIZE)
        ) {
            bis.transferTo(bos);
        }
    }

    private void updateAvatar(MultipartFile avatarFile, Student student, Path filePath, Avatar avatar) throws IOException {
        avatar.setStudent(student);
        avatar.setFilePath(filePath.toString());
        avatar.setFileSize(avatarFile.getSize());
        avatar.setMediaType(avatarFile.getContentType());
        avatar.setData(avatarFile.getBytes());
    }

    private Avatar findOrCreateAvatar(Long id) {
        return repository.findByStudentId(id).orElse(new Avatar());
    }

    private String getExtensions(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
