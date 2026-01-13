package be.euromoon.model.personen;

import java.time.LocalDate;
import java.util.List;

public class Conducteur extends Personeelslid {

    public Conducteur(String voornaam, String achternaam, String rijksregisterNummer, LocalDate geboortedatum, List<String> certificaties) {
        super(voornaam, achternaam, rijksregisterNummer, geboortedatum, certificaties);
    }
}
