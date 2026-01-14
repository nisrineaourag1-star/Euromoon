package be.euromoon.model.personen;

import java.time.LocalDate;
import java.util.List;

/**
 * Vertegenwoordigt een conducteur die verantwoordelijk is
 * voor het toezicht op de reis, de veiligheid van passagiers
 * en de controle van tickets aan boord van de trein.
 *
 * Een conducteur is een type {@link Personeelslid} en beschikt
 * over de nodige certificaties om deze taken uit te voeren.
 */
public class Conducteur extends Personeelslid {

    public Conducteur(String voornaam,
                      String achternaam,
                      String rijksregisterNummer,
                      LocalDate geboortedatum,
                      List<String> certificaties) {
        super(voornaam, achternaam, rijksregisterNummer, geboortedatum, certificaties);
    }
}
