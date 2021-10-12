package my.compary.cdi.demo.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.logging.Logger;

@Decorator
public class Manager implements Worker {

    private static final Logger LOGGER = Logger.getLogger(Manager.class.getName());

    @Inject
    @Delegate
    @Any
    private Worker worker;

    @Override
    public void work(String job) {
        LOGGER.info("A manager has received a job and it will delegate to a programmer ");
        worker.work(job);
    }
}
