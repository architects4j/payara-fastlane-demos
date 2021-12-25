package my.compary.restaurant;

import my.compary.restaurant.infra.AbstractFacade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

@Stateless
public class RestaurantRepositoryJPA extends AbstractFacade<Item> implements RestaurantRepository {

    private static final Logger LOGGER = Logger.getLogger(RestaurantRepositoryJPA.class.getName());

    @PersistenceContext(unitName = "JPADatasourceExamplePU")
    private EntityManager entityManager;

    public RestaurantRepositoryJPA() {
        super(Item.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

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
