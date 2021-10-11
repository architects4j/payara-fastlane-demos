package my.compary.restaurant;

import my.compary.restaurant.Item;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Items {

    private Set<Item> data = new HashSet<>();

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