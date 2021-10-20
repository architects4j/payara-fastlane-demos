package my.compary.cdi.demo.news;

import javax.enterprise.event.Observes;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class SocialMedia implements Consumer<News> {

    private static final Logger LOGGER = Logger.getLogger(SocialMedia.class.getName());

    @Override
    public void accept(@Observes News news) {
        LOGGER.info("We got the news, we'll publish it on Social Media: " + news.get());
    }
}
