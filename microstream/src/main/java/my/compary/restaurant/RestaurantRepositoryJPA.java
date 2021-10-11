package my.compary.restaurant;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

@ApplicationScoped
public class RestaurantRepositoryJPA  implements RestaurantRepository {

    private static final Logger LOGGER = Logger.getLogger(RestaurantRepositoryJPA.class.getName());



    @Override
    public Collection<Item> getAll() {
        return super.findAll();
    }

    @Override
    public Item save(Item item) {
        Objects.requireNonNull(item, "An item is required");
        Optional<Item> itemOptional = findById(item.getName());
        if (itemOptional.isPresent()) {
            getEntityManager().merge(item);
        } else {
            getEntityManager().persist(item);
        }
        LOGGER.info("The data was updated: " + item);
        return item;
    }

    @Override
    public Optional<Item> findById(String id) {
        LOGGER.info("Finding the item by id: " + id);
        return Optional.ofNullable(super.find(id));
    }

    @Override
    public void deleteById(String id) {
        Optional<Item> item = findById(id);
        item.ifPresent((i) -> super.remove(i));
    }
}
