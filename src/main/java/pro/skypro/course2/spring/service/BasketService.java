package pro.skypro.course2.spring.service;

import java.util.Collection;
import java.util.Set;

public interface BasketService {

    void putItems(Collection<Integer> itemsIds);

    Set<Integer> getItemsIds();
}
