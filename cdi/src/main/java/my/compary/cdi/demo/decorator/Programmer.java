package my.compary.cdi.demo.decorator;

import java.util.logging.Logger;

public class Programmer implements Worker {

    private static final Logger LOGGER = Logger.getLogger(Programmer.class.getName());

    @Override
    public void work(String job) {
        LOGGER.info("A programmer has received a job, it will convert coffee in code: " + job);
    }
}
