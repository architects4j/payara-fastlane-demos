package my.compary.restaurant;

import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("restaurants")
public interface RestaurantController {
    @GET
    Collection<Item> getAll();

    @GET
    @Path("{id}")
    Item findById(@PathParam("id") String id);

    @POST
    public Response insert(Item item);

    @PUT
    @Path("{id}")
    Item update(@PathParam("id") String id, @Valid Item item);

    @DELETE
    @Path("{id}")
    Response delete(@PathParam("id") String id);
}
