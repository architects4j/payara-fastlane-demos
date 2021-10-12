package my.compary.cdi.demo.decorator;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

@Decorator
@Priority(Interceptor.Priority.APPLICATION)
public class Manager implements Worker {

    @Inject
    @Delegate
    @Any
    private Worker worker;

    @Override
    public String work(String job) {
        return "A manager has received a job and it will delegate to a programmer -> " + worker.work(job);
    }
}
