package pro.skypro.course2.main.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.skypro.course2.main.exception.InvalidRequestException;
import pro.skypro.course2.main.model.Question;
import pro.skypro.course2.main.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/math")
public class MathQuestionController {


    @GetMapping("add")
    public String add(@RequestParam String question, @RequestParam String answer) {
        throw new InvalidRequestException();
    }

    @GetMapping("remove")
    public String remove(@RequestParam String question, @RequestParam String answer) {
        throw new InvalidRequestException();
    }

    @GetMapping
    public Collection<Question> getAll() {
        throw new InvalidRequestException();
    }


}
