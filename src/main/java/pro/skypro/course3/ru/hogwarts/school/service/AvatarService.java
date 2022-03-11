package pro.skypro.course3.ru.hogwarts.school.service;

import org.springframework.web.multipart.MultipartFile;
import pro.skypro.course3.ru.hogwarts.school.model.Avatar;

import java.io.IOException;
import java.util.List;

public interface AvatarService {

    Long uploadAvatar(Long studentId, MultipartFile avatar) throws IOException;

    Avatar findAvatar(Long id);

    List<Avatar> getAvatarPage(int page, int size);

}
