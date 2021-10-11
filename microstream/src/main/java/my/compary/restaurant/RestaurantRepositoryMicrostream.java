package my.compary.restaurant;

import one.microstream.storage.embedded.types.EmbeddedStorageManager;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Optional;
import java.util.logging.Logger;

@ApplicationScoped
public class RestaurantRepositoryMicrostream implements RestaurantRepository {

    private static final Logger LOGGER = Logger.getLogger(RestaurantRepositoryMicrostream.class.getName());

    @Inject
    private EmbeddedStorageManager manager;

    @Inject
    private Items items;

    @Override
    public Collection<Item> getAll() {
        return items.getData();
    }

    @Override
    public Item save(Item item) {
        this.items.add(item);
        manager.storeRoot();
        return item;
    }

    @Override
    public Optional<Item> findById(String id) {
        LOGGER.info("Finding the item by id: " + id);
        return items.findById(id);
    }

    @Override
    public void deleteById(String id) {
        items.deleteById(id);
        manager.storeRoot();
    }
}
