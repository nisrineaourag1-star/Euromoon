package be.euromoon.model.trein;

public abstract class Locomotief {

    public static final int CAPACITEIT_PERSONEN = 80;

    public abstract int getMaxAantalWagons();

    public boolean ondersteuntEersteKlasse() {
        return true;
    }

    public boolean ondersteuntTweedeKlasse() {
        return true;
    }

    public String getTypeNaam() {
        return this.getClass().getSimpleName();
    }

}
