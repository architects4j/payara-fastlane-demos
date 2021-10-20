package my.compary.cdi.demo;

import my.compary.cdi.demo.auditaded.FastSupplier;
import my.compary.cdi.demo.auditaded.SlowSupplier;
import my.compary.cdi.demo.decorator.Worker;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.function.Supplier;

public class App6 {

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            Supplier<String> fastSupplier = container.select(FastSupplier.class).get();
            Supplier<String> slowSupplier = container.select(SlowSupplier.class).get();
            System.out.println("The result: " + fastSupplier.get());
            System.out.println("The result: " + slowSupplier.get());
        }
    }
}
