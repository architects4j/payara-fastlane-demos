package my.compary.restaurant;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.Optional;
import java.util.logging.Logger;

@ApplicationScoped
public class RestaurantRepositoryMicrostream implements RestaurantRepository {

    private static final Logger LOGGER = Logger.getLogger(RestaurantRepositoryMicrostream.class.getName());

    @Override
    public Collection<Item> getAll() {
        return null;
    }

    @Override
    public Item save(Item item) {
        return null;
    }

    @Override
    public Optional<Item> findById(String id) {
        LOGGER.info("Finding the item by id: " + id);
        return null;
    }

    @Override
    public void deleteById(String id) {
        Optional<Item> item = findById(id);
    }
}
