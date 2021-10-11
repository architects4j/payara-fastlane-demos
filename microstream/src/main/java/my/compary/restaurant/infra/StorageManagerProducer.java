package my.compary.restaurant.infra;

import my.compary.restaurant.Items;
import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.nio.file.Paths;
import java.util.logging.Logger;

@ApplicationScoped
class StorageManagerProducer {

    private static final Logger LOGGER = Logger.getLogger(StorageManagerProducer.class.getName());

    @Inject
    @ConfigProperty(name = "microstream.path")
    private String path;

    @Produces
    @ApplicationScoped
    EmbeddedStorageManager getEmbeddedStorageManager() {
        LOGGER.info("Starting EmbeddedStorageManager connection, the path: " + path);
        final Items root = new Items();
        final EmbeddedStorageManager storageManager = EmbeddedStorage.start(
                root, Paths.get(path)
        );
        return storageManager;
    }

    public void close(@Disposes EmbeddedStorageManager storageManager) {
        LOGGER.info("Closing EmbeddedStorageManager connection");
        storageManager.close();
    }

    @Produces
    public Items getItems(EmbeddedStorageManager storageManager) {
        return (Items) storageManager.root();
    }
}
