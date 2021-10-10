package my.compary.cdi.demo;

import my.compary.cdi.demo.news.Journalist;
import my.compary.cdi.demo.producer.NumberLogger;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.math.BigDecimal;

public class App4 {

    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            Journalist journalist = container.select(Journalist.class).get();
            journalist.receiveNews("Java 17 has arrived!!");
        }
    }
}
