package my.compary.cdi.demo.vehicle;

import java.util.logging.Logger;

public class Car implements Vehicle {

    public static final Logger LOGGER = Logger.getLogger(Car.class.getName());

    @Override
    public void move() {
        LOGGER.info("My car is moving");
    }
}
