package be.euromoon.model.personen;

import java.time.LocalDate;

public class Passagier extends Persoon {

    public Passagier(String voornaam, String achternaam, String rijksregisterNummer, LocalDate geboortedatum) {
        super(voornaam, achternaam, rijksregisterNummer, geboortedatum);
    }

    @Override
    public String toString() {
        return getVoornaam() + " " + getAchternaam()+ " (" + getRijksregisterNummer() + ")";
    }

}
