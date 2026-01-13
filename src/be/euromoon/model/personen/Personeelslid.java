package be.euromoon.model.personen;

import java.time.LocalDate;
import java.util.List;

public class Personeelslid extends Persoon {
    protected List<String> certificaties;

    public Personeelslid(String voornaam, String achternaam, String rijksregisterNummer, LocalDate geboortedatum, List<String> certificaties) {
        super(voornaam, achternaam, rijksregisterNummer, geboortedatum);
        this.certificaties = certificaties;
    }

    public void voegCertificatieToe(String certificatie) {
        certificaties.add(certificatie);
    }
}
