package be.euromoon.model.trein;

/**
 * Vertegenwoordigt een Class 373 locomotief binnen het Euromoon-systeem.
 *
 * Deze locomotief kan maximaal 12 wagons trekken en is geschikt
 * voor passagierstransport.
 */
public class Class373 extends Locomotief {

    /**
     * Geeft het maximaal aantal wagons terug dat deze locomotief kan trekken.
     *
     * @return maximaal 12 wagons
     */
    @Override
    public int getMaxAantalWagons() {
        return 12;
    }
}
