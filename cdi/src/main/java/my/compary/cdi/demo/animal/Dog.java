package my.compary.cdi.demo.animal;

import javax.enterprise.inject.Default;

@AnimalFilter(AnimalType.DOG)
@Default
public class Dog implements Animal {
    @Override
    public String sound() {
        return "Bark";
    }
}
