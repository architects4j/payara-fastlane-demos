package my.compary.cdi.demo.vehicle;

import java.util.UUID;
import java.util.logging.Logger;

public class Car implements Vehicle {

    private static final Logger LOGGER = Logger.getLogger(Car.class.getName());

    private final String name;

    public Car() {
        this.name = UUID.randomUUID().toString();
    }

    @Override
    public void move() {
        LOGGER.info("My car is moving. The car's name is: " + name);
    }
}
