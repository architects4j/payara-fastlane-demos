package my.compary.cdi.demo.news;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@ApplicationScoped
public class Journalist {

    @Inject
    private Event<News> event;

    public void receiveNews(News news) {
         this.event.fire(news);
    }
}
