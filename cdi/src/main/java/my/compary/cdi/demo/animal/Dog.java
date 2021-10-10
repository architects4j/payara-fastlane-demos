package my.compary.cdi.demo.animal;

@AnimalFilter(AnimalType.DOG)
public class Dog implements Animal {
    @Override
    public String sound() {
        return "Bark";
    }
}
