package be.euromoon.model.personen;

import java.time.LocalDate;
import java.util.List;

/**
 * Vertegenwoordigt een personeelslid dat verantwoordelijk is
 * voor het laden, lossen en beheren van bagage op de trein.
 *
 * Bagagepersoneel is een type {@link Personeelslid} en beschikt
 * over een lijst van certificaties die nodig zijn om deze taken
 * veilig en correct uit te voeren.
 */
public class BagagePersoneel extends Personeelslid {

    public BagagePersoneel(String voornaam,
                           String achternaam,
                           String rijksregisterNummer,
                           LocalDate geboortedatum,
                           List<String> certificaties) {
        super(voornaam, achternaam, rijksregisterNummer, geboortedatum, certificaties);
    }
}
