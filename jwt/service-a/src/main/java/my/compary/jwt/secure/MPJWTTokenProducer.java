package my.compary.jwt.secure;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.util.Arrays;
import java.util.UUID;

@ApplicationScoped
class MPJWTTokenProducer {

    @Produces
    public MPJWTToken getMPJWTToken() {
        MPJWTToken token = new MPJWTToken();
        token.setAud("targetService");
        token.setIss("https://server.example.com");  // Must match the expected issues configuration values
        token.setJti(UUID.randomUUID().toString());
        token.setSub("Jessie");  // Sub is required for WildFly Swarm
        token.setUpn("Jessie");
        token.setIat(System.currentTimeMillis());
        token.setExp(System.currentTimeMillis() + 30000); // 30 Seconds expiration!
        token.addAdditionalClaims("custom-value", "Jessie specific value");
        token.setGroups(Arrays.asList("user", "protected"));
        return token;
    }
}
