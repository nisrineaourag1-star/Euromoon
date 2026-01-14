package be.euromoon.model.trein;

/**
 * Vertegenwoordigt een Class 374 locomotief binnen het Euromoon-systeem.
 *
 * Deze locomotief kan maximaal 14 wagons trekken en is geschikt
 * voor passagierstransport.
 */
public class Class374 extends Locomotief {

    /**
     * Geeft het maximaal aantal wagons terug dat deze locomotief kan trekken.
     *
     * @return maximaal 14 wagons
     */
    @Override
    public int getMaxAantalWagons() {
        return 14;
    }
}
