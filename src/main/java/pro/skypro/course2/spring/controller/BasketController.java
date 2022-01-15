package pro.skypro.course2.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.skypro.course2.spring.service.BasketService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/order")
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping("add")
    public void add(@RequestParam List<Integer> itemIds) {
        basketService.putItems(itemIds);
    }

    @GetMapping("get")
    public Set<Integer> get() {
        return basketService.getItemsIds();
    }

}
