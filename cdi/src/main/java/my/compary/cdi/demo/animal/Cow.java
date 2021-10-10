package my.compary.cdi.demo.animal;

@AnimalFilter(AnimalType.COW)
public class Cow implements Animal {
    @Override
    public String sound() {
        return "moo";
    }
}
