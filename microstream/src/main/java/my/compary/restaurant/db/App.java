package my.compary.restaurant.db;

import my.compary.restaurant.Items;
import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;

import java.nio.file.Paths;

public class App {

    public static void main(String[] args) {
        final Items root = new Items();
        // Initialize a storage manager ("the database") with purely defaults.
        final EmbeddedStorageManager storageManager = EmbeddedStorage.start(
                root,           // root object
                Paths.get("target/data") // storage directory
        );
        System.out.println(storageManager.root());
        storageManager.storeRoot();

        storageManager.shutdown();
    }
}
