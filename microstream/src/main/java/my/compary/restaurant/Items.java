package my.compary.restaurant;

import javax.enterprise.inject.Vetoed;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Vetoed
public class Items {

    private Set<Item> data = new HashSet<>();

    public void add(Item item) {
        Objects.requireNonNull(item, "item is required");
        this.data.add(item);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Items items = (Items) o;
        return Objects.equals(data, items.data);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }

    @Override
    public String toString() {
        return "Items{" +
                "data=" + data +
                '}';
    }
}