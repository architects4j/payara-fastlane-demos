package my.compary.cdi.demo;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.math.BigDecimal;
import java.util.logging.Logger;

public class App3 {

    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            BigDecimal value = container.select(BigDecimal.class).get();
            Logger logger = container.select(Logger.class).get();
            logger.info("The BigDecimal value is " + value);
        }
    }
}
