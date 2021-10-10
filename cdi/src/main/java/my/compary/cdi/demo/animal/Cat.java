package my.compary.cdi.demo.animal;

@AnimalFilter(AnimalType.CAT)
public class Cat implements Animal{
    @Override
    public String sound() {
        return "meows";
    }
}
