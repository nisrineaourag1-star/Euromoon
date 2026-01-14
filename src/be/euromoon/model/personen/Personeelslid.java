package be.euromoon.model.personen;

import java.time.LocalDate;
import java.util.List;

/**
 * Vertegenwoordigt een personeelslid van Euromoon.
 *
 * Een personeelslid is een {@link Persoon} en beschikt over
 * een lijst van certificaties die aangeven welke taken of
 * verantwoordelijkheden deze persoon mag uitvoeren.
 *
 * Deze klasse dient als basisklasse voor specifieke types
 * personeel zoals conducteurs, stewards en bagagepersoneel.
 */
public class Personeelslid extends Persoon {

    /**
     * Lijst van certificaties die het personeelslid bezit.
     */
    protected List<String> certificaties;

    public Personeelslid(String voornaam,
                         String achternaam,
                         String rijksregisterNummer,
                         LocalDate geboortedatum,
                         List<String> certificaties) {
        super(voornaam, achternaam, rijksregisterNummer, geboortedatum);
        this.certificaties = certificaties;
    }

    /**
     * Voegt een nieuwe certificatie toe aan het personeelslid.
     *
     * @param certificatie de certificatie die toegevoegd wordt
     */
    public void voegCertificatieToe(String certificatie) {
        certificaties.add(certificatie);
    }
}
