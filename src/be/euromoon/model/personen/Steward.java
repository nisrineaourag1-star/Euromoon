package be.euromoon.model.personen;

import java.time.LocalDate;
import java.util.List;

public class Steward extends Personeelslid {

    public Steward(String voornaam, String achternaam, String rijksregisterNummer, LocalDate geboortedatum, List<String> certificaties) {
        super(voornaam, achternaam, rijksregisterNummer, geboortedatum, certificaties);
    }
}

