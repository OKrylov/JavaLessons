package pro.skypro.course2.spring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.skypro.course2.spring.model.Basket;
import pro.skypro.course2.spring.service.BasketService;

import java.util.Collection;
import java.util.Set;

@Service
public class BasketServiceImpl implements BasketService {

    private static final Logger log = LoggerFactory.getLogger(BasketServiceImpl.class);

    private final Basket basket;

    public BasketServiceImpl(Basket basket) {
        this.basket = basket;
    }

    @Override
    public void putItems(Collection<Integer> itemsIds) {
        log.info("putItems has been called");
        for (Integer itemsId : itemsIds) {
            basket.addItem(itemsId);
        }
        log.info("The following items have been added to the basket: {}", itemsIds);
    }

    @Override
    public Set<Integer> getItemsIds() {
        log.info("getItemsIds has been called");
        return basket.getItems();
    }
}
