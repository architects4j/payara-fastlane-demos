package my.compary.jwt.secure;

import io.vertx.ext.auth.JWTOptions;
import io.vertx.ext.auth.PubSecKeyOptions;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTAuthOptions;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;

@ApplicationScoped
class KeyGenerator implements Supplier<String> {

    @Inject
    private MPJWTToken token;

    private String key;

    @PostConstruct
    void init() {
        key = readPemFile();
        if (key == null) {
            throw new WebApplicationException("Unable to read privateKey.pem", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public String get() {
        return generateJWT(key);
    }

    private String generateJWT(String key) {
        JWTAuth provider = JWTAuth.create(null, new JWTAuthOptions()
                .addPubSecKey(new PubSecKeyOptions()
                        .setAlgorithm("RS256")
                        .setSecretKey(key)
                ));
        return provider.generateToken(new io.vertx.core.json.JsonObject().mergeIn(token.toJSONString()), new JWTOptions().setAlgorithm("RS256"));
    }

    // NOTE:   Expected format is PKCS#8 (BEGIN PRIVATE KEY) NOT PKCS#1 (BEGIN RSA PRIVATE KEY)
    // See gencerts.sh
    private static String readPemFile() {
        StringBuilder sb = new StringBuilder(8192);
        try (BufferedReader is = new BufferedReader(
                new InputStreamReader(
                        TestSecureController.class.getResourceAsStream("/privateKey.pem"),
                        StandardCharsets.US_ASCII))) {
            String line;
            while ((line = is.readLine()) != null) {
                if (!line.startsWith("-")) {
                    sb.append(line);
                    sb.append('\n');
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
