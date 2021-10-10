package my.compary.cdi.demo;

import my.compary.cdi.demo.music.Orchestra;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class App2 {

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            Orchestra orchestra = container.select(Orchestra.class).get();
            orchestra.percussion();
            orchestra.keyboard();
            orchestra.string();
            orchestra.solo();
            orchestra.allSound();

        }
    }
}
