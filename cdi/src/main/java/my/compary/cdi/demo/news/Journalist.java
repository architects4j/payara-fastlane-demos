package my.compary.cdi.demo.news;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@ApplicationScoped
public class Journalist {

    @Inject
    private Event<String> event;

    public void receiveNews(String news) {
         this.event.fire(news);
    }
}
