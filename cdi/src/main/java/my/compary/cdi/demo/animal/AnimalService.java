package my.compary.cdi.demo.animal;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@ApplicationScoped
public class AnimalService {

    private static final Logger LOGGER = Logger.getLogger(AnimalService.class.getName());

    @Inject
    @AnimalFilter(AnimalType.CAT)
    private Animal cat;
    @Inject
    @AnimalFilter(AnimalType.COW)
    private Animal cow;

    @Inject
    @AnimalFilter(AnimalType.DOG)
    private Animal dog;

    @Inject
    private Animal animal;

    @Inject
    private Instance<Animal> animals;

    public void dog() {
        LOGGER.info("The dog's sound: " + this.dog.sound());
    }

    public void cat() {
        LOGGER.info("The dog's sound: " + this.cat.sound());
    }

    public void cow() {
        LOGGER.info("The dog's sound: " + this.cow.sound());
    }


    public void primary() {
        LOGGER.info("The default's sound: " + this.cow.sound());
    }

    public void allSound() {
        String sounds = this.animals.stream().map(Animal::sound).collect(Collectors.joining(","));
        LOGGER.info("All animals sounds are: " + sounds);
    }
}
