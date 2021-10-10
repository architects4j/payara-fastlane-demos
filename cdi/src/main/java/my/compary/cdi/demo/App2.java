package my.compary.cdi.demo;

import my.compary.cdi.demo.animal.AnimalService;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class App2 {

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            AnimalService animalService = container.select(AnimalService.class).get();
            animalService.cat();
            animalService.cow();
            animalService.dog();
            animalService.primary();
            animalService.allSound();

        }
    }
}
