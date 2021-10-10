package my.compary.cdi.demo.music;

@MusicalInstrument(InstrumentType.PERCUSSION)
public class Xylophone implements Instrument {
    @Override
    public String sound() {
        return "xylophone";
    }
}
