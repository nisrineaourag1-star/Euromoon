package be.euromoon.model.trein;

/**
 * Vertegenwoordigt een wagon die deel uitmaakt van een trein.
 *
 * Een wagon heeft een capaciteit (aantal personen) en een reisklasse
 * (eerste of tweede klasse). Wagons worden toegevoegd aan een trein
 * en dragen bij aan de totale capaciteit.
 */
public class Wagon {

    private int capaciteit;
    private Reisklasse reisklasse;

    public Wagon(int capaciteit, Reisklasse reisklasse) {
        this.capaciteit = capaciteit;
        this.reisklasse = reisklasse;
    }

    /**
     * Geeft de capaciteit van de wagon terug.
     *
     * @return het aantal personen dat in de wagon past
     */
    public int getCapaciteit() {
        return capaciteit;
    }

    /**
     * Geeft de reisklasse van de wagon terug.
     *
     * @return de reisklasse (eerste of tweede klasse)
     */
    public Reisklasse getReisklasse() {
        return reisklasse;
    }
}
