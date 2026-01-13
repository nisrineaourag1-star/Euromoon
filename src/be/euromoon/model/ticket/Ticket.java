package be.euromoon.model.ticket;

import be.euromoon.model.personen.Passagier;
import be.euromoon.model.reis.Reis;
import be.euromoon.model.trein.Reisklasse;

public class Ticket {

    private Passagier passagier;
    private Reis reis;
    private Reisklasse reisklasse;

    public Ticket(Passagier passagier, Reis reis, Reisklasse reisklasse) {
        this.passagier = passagier;
        this.reis = reis;
        this.reisklasse = reisklasse;
    }

    public Reis getReis() {
        return reis;
    }


    public void setReis(Reis reis) {
        this.reis = reis;
    }

    public Reisklasse getReisklasse() {
        return reisklasse;
    }

    public void setReisklasse(Reisklasse reisklasse) {
        this.reisklasse = reisklasse;
    }

    public Passagier getPassagier() {
        return passagier;
    }

    public void setPassagier(Passagier passagier) {
        this.passagier = passagier;
    }
}
