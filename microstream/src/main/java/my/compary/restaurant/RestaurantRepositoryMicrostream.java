package my.compary.restaurant;

import my.compary.restaurant.infra.UpdateRoot;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Optional;
import java.util.logging.Logger;

@ApplicationScoped
public class RestaurantRepositoryMicrostream implements RestaurantRepository {

    private static final Logger LOGGER = Logger.getLogger(RestaurantRepositoryMicrostream.class.getName());


    @Inject
    private Items items;

    @Override
    public Collection<Item> getAll() {
        return items.getData();
    }

    @Override
    @UpdateRoot
    public Item save(Item item) {
        this.items.add(item);
        return item;
    }

    @Override
    public Optional<Item> findById(String id) {
        LOGGER.info("Finding the item by id: " + id);
        return items.findById(id);
    }

    @Override
    @UpdateRoot
    public void deleteById(String id) {
        items.deleteById(id);
    }
}
