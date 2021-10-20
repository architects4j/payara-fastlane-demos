package my.compary.cdi.demo.news;

import java.util.function.Supplier;

public final class News implements Supplier<String> {

    private final String name;

    public News(String name) {
        this.name = name;
    }

    @Override
    public String get() {
        return name;
    }
}
