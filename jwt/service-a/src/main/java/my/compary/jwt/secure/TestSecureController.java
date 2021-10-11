package my.compary.jwt.secure;

import io.vertx.ext.auth.JWTOptions;
import io.vertx.ext.auth.PubSecKeyOptions;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTAuthOptions;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.UUID;

@Path("/secured")
@ApplicationScoped
public class TestSecureController {

    private KeyGenerator generator;

    @Inject
    public TestSecureController(KeyGenerator generator) {
        this.generator = generator;
    }

    /**
     * @Deprecated CDI only
     */
    TestSecureController() {
    }

    @GET
    @Path("/test")
    public String testSecureCall() {
        WebTarget target = ClientBuilder.newClient().target("http://localhost:8180/data/protected");
        Response response = target.request().header("authorization", "Bearer " + generator.get())
                .buildGet().invoke();
        return String.format("Claim value within JWT of 'custom-value' : %s", response.readEntity(String.class));
    }
}
