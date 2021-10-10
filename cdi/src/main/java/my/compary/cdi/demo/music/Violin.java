package my.compary.cdi.demo.music;

@MusicalInstrument(InstrumentType.STRING)
public class Violin implements Instrument {
    @Override
    public String sound() {
        return "violin";
    }
}
