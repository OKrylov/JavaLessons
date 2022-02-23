package pro.skypro.course3.ru.hogwarts.school;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@OpenAPIDefinition
@SpringBootApplication
public class HogwartsApp {

    public static void main(String[] args) {
        SpringApplication.run(HogwartsApp.class);
    }
}
