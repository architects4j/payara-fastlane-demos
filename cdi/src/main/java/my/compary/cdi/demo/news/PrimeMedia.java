package my.compary.cdi.demo.news;

import javax.enterprise.event.Observes;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class PrimeMedia implements Consumer<News> {

    private static final Logger LOGGER = Logger.getLogger(PrimeMedia.class.getName());

    @Override
    public void accept(@Observes @PrimeNews News news) {
        LOGGER.info("This news is exclusive to the prime readers: " + news.get());
    }
}
