package my.compary.cdi.demo;

import my.compary.cdi.demo.injection.MyServiceSample;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class App1 {

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            MyServiceSample myServiceSample = container.select(MyServiceSample.class).get();
            System.out.println("The team " + myServiceSample.doSomething());
        }
    }
}
