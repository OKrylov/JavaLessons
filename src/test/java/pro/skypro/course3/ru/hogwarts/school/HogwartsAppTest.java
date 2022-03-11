package pro.skypro.course3.ru.hogwarts.school;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import pro.skypro.course3.ru.hogwarts.school.model.Student;

import java.net.URI;
import java.util.Collection;
import java.util.Set;

@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HogwartsAppTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test_create_student() {
        Student student = given_student_with("studentName", 25);
        ResponseEntity<Student> response = when_sending_create_student_request(getUriBuilder().build().toUri(), student);
        then_student_has_been_created(response);
    }

    @Test
    public void test_get_student_by_id() {
        Student student = given_student_with("studentName", 25);

        ResponseEntity<Student> createResponse = when_sending_create_student_request(getUriBuilder().build().toUri(), student);

        then_student_has_been_created(createResponse);

        Student createdStudent = createResponse.getBody();
        then_student_with_id_has_been_found(createdStudent.getId(), createdStudent);
    }


    @Test
    public void test_findByAge() {
        Student student_18 = given_student_with("studentName3", 18);
        Student student_25 = given_student_with("studentName1", 25);
        Student student_28 = given_student_with("studentName2", 28);
        Student student_32 = given_student_with("studentName4", 32);

        when_sending_create_student_request(getUriBuilder().build().toUri(), student_18);
        when_sending_create_student_request(getUriBuilder().build().toUri(), student_25);
        when_sending_create_student_request(getUriBuilder().build().toUri(), student_28);
        when_sending_create_student_request(getUriBuilder().build().toUri(), student_32);

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("age", "25");
        then_students_are_found_by_criteria(queryParams, student_25);
    }

    @Test
    public void test_findByAgeBetween() {
        Student student_18 = given_student_with("studentName3", 18);
        Student student_25 = given_student_with("studentName1", 25);
        Student student_28 = given_student_with("studentName2", 28);
        Student student_32 = given_student_with("studentName4", 32);

        when_sending_create_student_request(getUriBuilder().build().toUri(), student_18);
        when_sending_create_student_request(getUriBuilder().build().toUri(), student_25);
        when_sending_create_student_request(getUriBuilder().build().toUri(), student_28);
        when_sending_create_student_request(getUriBuilder().build().toUri(), student_32);

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("minAge", "20");
        queryParams.add("maxAge", "30");
        then_students_are_found_by_criteria(queryParams, student_25, student_28);
    }

    @Test
    public void test_update() {
        Student student = given_student_with("studentName", 25);

        ResponseEntity<Student> responseEntity = when_sending_create_student_request(getUriBuilder().build().toUri(), student);
        then_student_has_been_created(responseEntity);
        Student createdStudent = responseEntity.getBody();

        when_updating_student(createdStudent, 32, "newName");
        then_student_has_been_updated(createdStudent, 32, "newName");
    }

    @Test
    public void test_delete() {
        Student student = given_student_with("studentName", 25);

        ResponseEntity<Student> responseEntity = when_sending_create_student_request(getUriBuilder().build().toUri(), student);
        then_student_has_been_created(responseEntity);
        Student createdStudent = responseEntity.getBody();

        when_deleting_student(createdStudent);
        then_student_not_found(createdStudent);
    }

    private void when_deleting_student(Student createdStudent) {
        restTemplate.delete(getUriBuilder().path("/{id}").buildAndExpand(createdStudent.getId()).toUri());
    }

    private void then_student_not_found(Student createdStudent) {
        URI getUri = getUriBuilder().path("/{id}").buildAndExpand(createdStudent.getId()).toUri();
        ResponseEntity<Student> emptyRs = restTemplate.getForEntity(getUri, Student.class);

        Assertions.assertThat(emptyRs.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    private void then_student_has_been_updated(Student createdStudent, int newAge, String newName) {
        URI getUri = getUriBuilder().path("/{id}").buildAndExpand(createdStudent.getId()).toUri();
        ResponseEntity<Student> updatedStudentRs = restTemplate.getForEntity(getUri, Student.class);

        Assertions.assertThat(updatedStudentRs.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(updatedStudentRs.getBody()).isNotNull();
        Assertions.assertThat(updatedStudentRs.getBody().getAge()).isEqualTo(newAge);
        Assertions.assertThat(updatedStudentRs.getBody().getName()).isEqualTo(newName);
    }

    private void when_updating_student(Student createdStudent, int newAge, String newName) {
        createdStudent.setAge(newAge);
        createdStudent.setName(newName);

        restTemplate.put(getUriBuilder().build().toUri(), createdStudent);
    }

    private void then_students_are_found_by_criteria(MultiValueMap<String, String> queryParams, Student... students) {
        URI uri = getUriBuilder().queryParams(queryParams).build().toUri();

        ResponseEntity<Set<Student>> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Set<Student>>() {
                });

        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        Set<Student> actualResult = response.getBody();
        resetIds(actualResult);
        Assertions.assertThat(actualResult).containsExactlyInAnyOrder(students);
    }

    private void then_student_with_id_has_been_found(Long studentId, Student student) {
        URI uri = getUriBuilder().path("/{id}").buildAndExpand(studentId).toUri();
        ResponseEntity<Student> response = restTemplate.getForEntity(uri, Student.class);

        Assertions.assertThat(response.getBody()).isEqualTo(student);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    private ResponseEntity<Student> when_sending_create_student_request(URI uri, Student student) {
        return restTemplate.postForEntity(uri, student, Student.class);
    }

    private void then_student_has_been_created(ResponseEntity<Student> response) {
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response.getBody().getId()).isNotNull();
    }

    private Student given_student_with(String name, int age) {
        return new Student(name, age);
    }

    private void resetIds(Collection<Student> students) {
        students.forEach(it -> it.setId(null));
    }


    private UriComponentsBuilder getUriBuilder() {
        return UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(port)
                .path("/hogwarts/student");
    }


}
