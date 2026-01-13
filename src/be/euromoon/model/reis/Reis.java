package be.euromoon.model.reis;

import be.euromoon.model.personen.Passagier;
import be.euromoon.model.personen.Personeelslid;
import be.euromoon.model.ticket.Ticket;
import be.euromoon.model.trein.Reisklasse;
import be.euromoon.model.trein.Trein;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reis {

    private Station vertrekStation;
    private Station aankomstStation;
    private LocalDateTime vertrekTijd;
    private Trein trein;

    private List<ReisPersoneel> personeel = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();

    public Reis(Station vertrek, Station aankomst, LocalDateTime vertrekTijd, Trein trein) {
        this.vertrekStation = vertrek;
        this.aankomstStation = aankomst;
        this.vertrekTijd = vertrekTijd;
        this.trein = trein;
    }

    public void voegPersoneelToe(Personeelslid lid, ReisRol rol) {
        personeel.add(new ReisPersoneel(lid, rol));
    }

    public boolean isGeldigBemand() {
        long bestuurders = personeel.stream()
                .filter(p -> p.getRol() == ReisRol.BESTUURDER)
                .count();

        long stewards = personeel.stream()
                .filter(p -> p.getRol() == ReisRol.STEWARD)
                .count();

        return bestuurders >= 1 && stewards >= 3;
    }

    public Trein getTrein() {
        return trein;
    }

    public void setTrein(Trein trein) {
        this.trein = trein;
    }



    public int getAantalVerkochteTickets(Reisklasse klasse) {
        return (int) tickets.stream()
                .filter(t -> t.getReisklasse() == klasse)
                .count();
    }

    public Station getVertrekStation() {
        return vertrekStation;
    }

    public Station getAankomstStation() {
        return aankomstStation;
    }

    public LocalDateTime getVertrekTijd() {
        return vertrekTijd;
    }

    public List<ReisPersoneel> getPersoneel() {
        return personeel;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public int getBeschikbarePlaatsen(Reisklasse klasse) {
        int capaciteit = trein.getCapaciteitVoorKlasse(klasse);
        return capaciteit - getAantalVerkochteTickets(klasse);
    }

    public boolean heeftGeldigTicket(Passagier passagier) {
        return tickets.stream()
                .anyMatch(t -> t.getPassagier().equals(passagier));
    }

    public boolean verkoopTicket(Passagier passagier, Reisklasse klasse) {
        if (getBeschikbarePlaatsen(klasse) <= 0) {
            return false;
        }

        tickets.add(new Ticket(passagier, this, klasse));
        return true;
    }

    @Override
    public String toString() {
        return vertrekStation.getNaam()
                + " -> "
                + aankomstStation.getNaam()
                + " ("
                + vertrekTijd
                + ")";
    }

}
