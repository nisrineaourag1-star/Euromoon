package be.euromoon.model.ticket;

import be.euromoon.model.personen.Passagier;
import be.euromoon.model.reis.Reis;
import be.euromoon.model.trein.Reisklasse;

/**
 * Vertegenwoordigt een ticket dat een passagier aankoopt voor een specifieke reis.
 *
 * Een ticket bevat informatie over de passagier, de bijbehorende reis
 * en de gekozen reisklasse (eerste of tweede klasse).
 */
public class Ticket {

    private Passagier passagier;
    private Reis reis;
    private Reisklasse reisklasse;

    public Ticket(Passagier passagier, Reis reis, Reisklasse reisklasse) {
        this.passagier = passagier;
        this.reis = reis;
        this.reisklasse = reisklasse;
    }

    /**
     * Geeft de passagier terug die eigenaar is van dit ticket.
     *
     * @return de passagier
     */
    public Passagier getPassagier() {
        return passagier;
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

    public void setPassagier(Passagier passagier) {
        this.passagier = passagier;
    }
}
