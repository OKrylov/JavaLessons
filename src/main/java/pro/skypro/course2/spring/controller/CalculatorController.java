package pro.skypro.course2.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.skypro.course2.spring.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String showGreetings() {
        return "<h1>Добро пожаловать в калькулятор.</h1>";
    }

    @GetMapping(value = "/plus", params = {"num11", "num22"})
    public String sumNumbers(@RequestParam Integer num1, @RequestParam Integer num2) {
        int result = calculatorService.sum(num1, num2);
        return generateMessage(num1, num2, '+', result);
    }

    @GetMapping(value = "/plus", params = {"num1"})
    public String sumNumbers(@RequestParam Integer num1) {
        int result = calculatorService.sum(num1, 555);
        return generateMessage(num1, 555, '+', result);
    }

    @GetMapping("/minus")
    public String subtractNumbers(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.subtract(num1, num2);
        return generateMessage(num1, num2, '-', result);
    }

    @GetMapping("/multiply")
    public String multiplyNumbers(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.multiply(num1, num2);
        return generateMessage(num1, num2, '*', result);
    }

    @GetMapping("/divide")
    public String divideNumbers(@RequestParam int num1, @RequestParam int num2) {
        try {
            int result = calculatorService.divide(num1, num2);
            return generateMessage(num1, num2, '/', result);
        } catch (IllegalArgumentException e) {
            return "<h1>Второй аргумент равен 0. Деление на 0 невозможно.</h1>";
        }
    }

    private String generateMessage(int num1, int num2, char action, int result) {
        return String.format("<h1>%d %c %d = %d</h1>", num1, action, num2, result);
    }
}