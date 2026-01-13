package be.euromoon.model.trein;

import java.util.ArrayList;
import java.util.List;

public class Trein {
    private Locomotief locomotief;
    private List<Wagon> wagons = new ArrayList<>();

    public Trein(Locomotief locomotief) {
        this.locomotief = locomotief;
    }

    public boolean voegWagonToe(Wagon wagon) {
        if (wagons.size() >= locomotief.getMaxAantalWagons()) {
            return false;
        }
        wagons.add(wagon);
        return true;
    }

    public int getCapaciteitVoorKlasse(Reisklasse klasse) {
        return wagons.stream()
                .filter(w -> w.getReisklasse() == klasse)
                .mapToInt(Wagon::getCapaciteit)
                .sum();
    }

    @Override
    public String toString() {
        return "Trein met " + wagons.size()
                + " wagons (" + locomotief.getTypeNaam() + ")";
    }

    public int getTotaleCapaciteit() {
        return wagons.stream()
                .mapToInt(Wagon::getCapaciteit)
                .sum() + Locomotief.CAPACITEIT_PERSONEN;
    }
}
