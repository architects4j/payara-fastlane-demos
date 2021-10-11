package my.compary.restaurant;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;

@ApplicationScoped
@Named
public class RestaurantBean {

    @Inject
    private RestaurantService service;


    public Collection<Item> getItems() {
        return this.service.getAll();
    }
}
