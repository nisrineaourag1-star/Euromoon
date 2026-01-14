package be.euromoon.model.personen;

import java.time.LocalDate;

/**
 * Abstracte basisklasse die een persoon binnen het Euromoon-systeem
 * voorstelt.
 *
 * Een persoon beschikt over basisgegevens zoals naam,
 * rijksregisternummer en geboortedatum en wordt uitgebreid
 * door concrete subklassen zoals {@link Passagier} en
 * {@link Personeelslid}.
 */
public abstract class Persoon {

    protected String voornaam;
    protected String achternaam;
    protected String rijksregisterNummer;
    protected LocalDate geboortedatum;

    public Persoon(String voornaam,
                   String achternaam,
                   String rijksregisterNummer,
                   LocalDate geboortedatum) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.rijksregisterNummer = rijksregisterNummer;
        this.geboortedatum = geboortedatum;
    }

    /**
     * Geeft de volledige naam van de persoon terug
     * in de vorm: achternaam gevolgd door voornaam.
     *
     * @return de volledige naam van de persoon
     */
    public String getVolledigeNaam() {
        return getAchternaam() + " " + getVoornaam();
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    public String getRijksregisterNummer() {
        return rijksregisterNummer;
    }

    public void setRijksregisterNummer(String rijksregisterNummer) {
        this.rijksregisterNummer = rijksregisterNummer;
    }
}
