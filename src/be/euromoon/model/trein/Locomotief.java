package be.euromoon.model.trein;

/**
 * Abstracte basisklasse die een locomotief binnen het Euromoon-systeem voorstelt.
 *
 * Een locomotief trekt wagons en heeft een vaste capaciteit voor passagiers.
 * Subklassen zoals {@link Class373} en {@link Class374} geven aan hoeveel wagons
 * maximaal kunnen worden getrokken.
 */
public abstract class Locomotief {

    /**
     * Het standaard aantal personen dat de locomotief kan vervoeren inclusief bagage.
     */
    public static final int CAPACITEIT_PERSONEN = 80;

    /**
     * Geeft het maximaal aantal wagons terug dat deze locomotief kan trekken.
     *
     * @return maximaal aantal wagons
     */
    public abstract int getMaxAantalWagons();

    /**
     * Controleert of deze locomotief eerste klasse ondersteunt.
     *
     * @return true indien eerste klasse beschikbaar is
     */
    public boolean ondersteuntEersteKlasse() {
        return true;
    }

    /**
     * Controleert of deze locomotief tweede klasse ondersteunt.
     *
     * @return true indien tweede klasse beschikbaar is
     */
    public boolean ondersteuntTweedeKlasse() {
        return true;
    }

    /**
     * Geeft de naam van het type locomotief terug.
     *
     * @return de eenvoudige classnaam van de locomotief
     */
    public String getTypeNaam() {
        return this.getClass().getSimpleName();
    }
}
