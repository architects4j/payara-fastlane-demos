package my.compary.restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository {
    List<Item> getAll();

    Item save(Item item);

    Optional<Item> findById(String id);
}
