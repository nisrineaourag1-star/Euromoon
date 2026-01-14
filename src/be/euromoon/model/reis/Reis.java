package be.euromoon.model.reis;

import be.euromoon.model.personen.Passagier;
import be.euromoon.model.personen.Personeelslid;
import be.euromoon.model.ticket.Ticket;
import be.euromoon.model.trein.Reisklasse;
import be.euromoon.model.trein.Trein;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Vertegenwoordigt een treinreis binnen het Euromoon-systeem.
 *
 * Een reis verbindt twee stations op een bepaald tijdstip,
 * heeft optioneel een gekoppelde trein en bevat informatie
 * over toegewezen personeel en verkochte tickets.
 */
public class Reis {

    private Station vertrekStation;
    private Station aankomstStation;
    private LocalDateTime vertrekTijd;
    private Trein trein;

    private List<ReisPersoneel> personeel = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();

    public Reis(Station vertrek,
                Station aankomst,
                LocalDateTime vertrekTijd,
                Trein trein) {
        this.vertrekStation = vertrek;
        this.aankomstStation = aankomst;
        this.vertrekTijd = vertrekTijd;
        this.trein = trein;
    }

    /**
     * Voegt een personeelslid toe aan deze reis met een specifieke rol.
     *
     * @param lid het personeelslid dat wordt toegewezen aan de reis
     * @param rol de rol die het personeelslid vervult tijdens de reis
     */
    public void voegPersoneelToe(Personeelslid lid, ReisRol rol) {
        personeel.add(new ReisPersoneel(lid, rol));
    }

    /**
     * Controleert of de reis geldig bemand is.
     *
     * Een reis is geldig bemand wanneer er minstens
     * één bestuurder en drie stewards zijn toegewezen.
     *
     * @return true indien de personeelsbezetting geldig is, anders false
     */
    public boolean isGeldigBemand() {
        long bestuurders = personeel.stream()
                .filter(p -> p.getRol() == ReisRol.BESTUURDER)
                .count();

        long stewards = personeel.stream()
                .filter(p -> p.getRol() == ReisRol.STEWARD)
                .count();

        return bestuurders >= 1 && stewards >= 3;
    }

    /**
     * Geeft het aantal verkochte tickets terug voor een bepaalde reisklasse.
     *
     * @param klasse de reisklasse waarvoor het aantal tickets wordt opgevraagd
     * @return het aantal verkochte tickets
     */
    public int getAantalVerkochteTickets(Reisklasse klasse) {
        return (int) tickets.stream()
                .filter(t -> t.getReisklasse() == klasse)
                .count();
    }

    /**
     * Berekent het aantal beschikbare plaatsen voor een bepaalde reisklasse.
     *
     * @param klasse de reisklasse
     * @return het aantal resterende plaatsen
     */
    public int getBeschikbarePlaatsen(Reisklasse klasse) {
        int capaciteit = trein.getCapaciteitVoorKlasse(klasse);
        return capaciteit - getAantalVerkochteTickets(klasse);
    }

    /**
     * Controleert of een passagier reeds een geldig ticket heeft voor deze reis.
     *
     * @param passagier de passagier die gecontroleerd wordt
     * @return true indien de passagier al een ticket heeft, anders false
     */
    public boolean heeftGeldigTicket(Passagier passagier) {
        return tickets.stream()
                .anyMatch(t -> t.getPassagier().equals(passagier));
    }

    /**
     * Verkoopt een ticket aan een passagier voor een bepaalde reisklasse.
     *
     * Een ticket kan enkel verkocht worden indien er nog
     * beschikbare plaatsen zijn in de gekozen klasse.
     *
     * @param passagier de passagier die het ticket aankoopt
     * @param klasse de gekozen reisklasse
     * @return true indien het ticket succesvol werd verkocht, anders false
     */
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

    public Trein getTrein() {
        return trein;
    }

    public void setTrein(Trein trein) {
        this.trein = trein;
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
}
