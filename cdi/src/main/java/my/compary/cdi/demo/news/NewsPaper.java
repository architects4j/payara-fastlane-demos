package my.compary.cdi.demo.news;

import javax.enterprise.event.Observes;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class NewsPaper implements Consumer<String> {

    private static final Logger LOGGER = Logger.getLogger(NewsPaper.class.getName());

    @Override
    public void accept(@Observes String news) {
        LOGGER.info("We got the news, we'll publish it on a newspaper: " + news);
    }
}
