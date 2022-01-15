package pro.skypro.course2.spring.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Component
@SessionScope
public class Basket {

    private final Set<Integer> itemsIds;

    public Basket() {
        this.itemsIds = new LinkedHashSet<>();
    }

    public void addItem(int itemId) {
        itemsIds.add(itemId);
    }

    public Set<Integer> getItems() {
        return Set.copyOf(itemsIds);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "itemsIds=" + itemsIds +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(itemsIds, basket.itemsIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemsIds);
    }
}
