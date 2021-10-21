package my.compary.restaurant.infra;

import my.compary.restaurant.Items;
import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;
import one.microstream.storage.types.StorageManager;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.logging.Logger;

@ApplicationScoped
class StorageManagerProducer {

    private static final Logger LOGGER = Logger.getLogger(StorageManagerProducer.class.getName());

    @Inject
    @ConfigProperty(name = "microstream.path")
    private String path;

    @Produces
    @ApplicationScoped
    StorageManager getStorageManager() {
        LOGGER.info("Starting StorageManager connection, the path: " + path);
        final EmbeddedStorageManager storageManager = EmbeddedStorage.start(Paths.get(path));
        Object root = storageManager.root();
        if (Objects.isNull(root)) {
            LOGGER.info("Starting the root");
            storageManager.setRoot(new Items());
        }
        return storageManager;
    }

    public void close(@Disposes StorageManager storageManager) {
        LOGGER.info("Closing EmbeddedStorageManager connection");
        storageManager.close();
    }

    @Produces
    public Items getItems(StorageManager storageManager) {
        return (Items) storageManager.root();
    }
}
