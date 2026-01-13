package be.euromoon.model.trein;

public class Wagon {

        private int capaciteit;
        private Reisklasse reisklasse;

        public Wagon(int capaciteit, Reisklasse reisklasse) {
            this.capaciteit = capaciteit;
            this.reisklasse = reisklasse;
        }

    public int getCapaciteit() {
        return capaciteit;
    }

    public Reisklasse getReisklasse() {
        return reisklasse;
    }
}


