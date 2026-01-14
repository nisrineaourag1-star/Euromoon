package be.euromoon.model.reis;

/**
 * Vertegenwoordigt een treinstation binnen het Euromoon-systeem.
 *
 * Een station heeft een naam en een land waarin het zich bevindt.
 */
public class Station {

    private String naam;
    private String land;

    public Station(String naam, String land) {
        this.naam = naam;
        this.land = land;
    }

    /**
     * Geeft de naam van het station terug.
     *
     * @return de naam van het station
     */
    public String getNaam() {
        return naam;
    }

    // Indien gewenst kan ook een getter voor 'land' worden toegevoegd
}
