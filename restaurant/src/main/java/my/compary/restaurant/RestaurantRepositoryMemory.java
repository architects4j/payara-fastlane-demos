package my.compary.restaurant;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
class RestaurantRepositoryMemory implements RestaurantRepository {

    private Map<String, Item> data;

    public RestaurantRepositoryMemory() {
        this.data = new HashMap<>();
    }

    @Override
    public Collection<Item> getAll() {
        return data.values();
    }

    @Override
    public Item save(Item item) {
        Objects.requireNonNull(item, "item is required");
        item.checkId();
        this.data.put(item.getId(), item);
        return item;
    }

    @Override
    public Optional<Item> findById(String id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public void deleteById(String id) {
        this.data.remove(id);
    }
}
