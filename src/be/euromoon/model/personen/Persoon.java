package be.euromoon.model.personen;

import java.time.LocalDate;

public abstract class Persoon {

    protected String voornaam;
    protected String achternaam;
    protected String rijksregisterNummer;
    protected LocalDate geboortedatum;

    public Persoon(String voornaam, String achternaam,
                   String rijksregisterNummer, LocalDate geboortedatum) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.rijksregisterNummer = rijksregisterNummer;
        this.geboortedatum = geboortedatum;
    }

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
