package be.euromoon.model.personen;

import java.time.LocalDate;

/**
 * Vertegenwoordigt een passagier die een treinreis kan maken
 * met Euromoon en hiervoor een ticket kan aankopen.
 *
 * Een passagier is een {@link Persoon} en bevat persoonlijke
 * identificatiegegevens zoals naam en rijksregisternummer.
 */
public class Passagier extends Persoon {

    public Passagier(String voornaam,
                     String achternaam,
                     String rijksregisterNummer,
                     LocalDate geboortedatum) {
        super(voornaam, achternaam, rijksregisterNummer, geboortedatum);
    }

    /**
     * Geeft een leesbare tekstuele voorstelling van de passagier.
     *
     * @return een string met de naam en het rijksregisternummer
     */
    @Override
    public String toString() {
        return getVoornaam() + " " + getAchternaam()
                + " (" + getRijksregisterNummer() + ")";
    }

}
