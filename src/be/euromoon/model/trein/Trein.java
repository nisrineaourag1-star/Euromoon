package be.euromoon.model.trein;

import java.util.ArrayList;
import java.util.List;

/**
 * Vertegenwoordigt een trein binnen het Euromoon-systeem.
 *
 * Een trein bestaat uit één locomotief en een lijst van wagons.
 * De trein kan wagons toevoegen tot het maximum van de locomotief.
 */
public class Trein {

    private Locomotief locomotief;
    private List<Wagon> wagons = new ArrayList<>();

    public Trein(Locomotief locomotief) {
        this.locomotief = locomotief;
    }

    /**
     * Voegt een wagon toe aan de trein indien de maximumcapaciteit
     * van de locomotief nog niet bereikt is.
     *
     * @param wagon de wagon die toegevoegd wordt
     * @return true indien succesvol toegevoegd, false indien maximum bereikt
     */
    public boolean voegWagonToe(Wagon wagon) {
        if (wagons.size() >= locomotief.getMaxAantalWagons()) {
            return false;
        }
        wagons.add(wagon);
        return true;
    }

    /**
     * Berekent de totale capaciteit van de trein voor een bepaalde reisklasse.
     *
     * @param klasse de reisklasse
     * @return het totaal aantal beschikbare plaatsen in deze klasse
     */
    public int getCapaciteitVoorKlasse(Reisklasse klasse) {
        return wagons.stream()
                .filter(w -> w.getReisklasse() == klasse)
                .mapToInt(Wagon::getCapaciteit)
                .sum();
    }

    /**
     * Geeft een leesbare weergave van de trein.
     *
     * @return string met het aantal wagons en type locomotief
     */
    @Override
    public String toString() {
        return "Trein met " + wagons.size()
                + " wagons (" + locomotief.getTypeNaam() + ")";
    }

    /**
     * Geeft de totale capaciteit van de trein, inclusief de locomotief.
     *
     * @return totale capaciteit van de trein
     */
    public int getTotaleCapaciteit() {
        return wagons.stream()
                .mapToInt(Wagon::getCapaciteit)
                .sum() + Locomotief.CAPACITEIT_PERSONEN;
    }
}
