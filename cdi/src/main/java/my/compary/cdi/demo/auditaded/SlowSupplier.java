package my.compary.cdi.demo.auditaded;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class SlowSupplier implements Supplier<String> {

    @Timed
    @Override
    public String get() {
        try {
            TimeUnit.MILLISECONDS.sleep(200L);
        } catch (InterruptedException e) {
            //TODO it is only a sample, don't do it on production :)
            throw  new RuntimeException(e);
        }
        return "The slow result";
    }
}
