package be.euromoon.model.personen;

import java.time.LocalDate;
import java.util.List;

/**
 * Vertegenwoordigt een steward binnen het Euromoon-systeem.
 *
 * Een steward is een personeelslid dat verantwoordelijk is
 * voor de begeleiding en service van passagiers tijdens een reis.
 * Stewards beschikken over één of meerdere certificaties
 * die hun bevoegdheden aanduiden.
 */
public class Steward extends Personeelslid {

    public Steward(String voornaam,
                   String achternaam,
                   String rijksregisterNummer,
                   LocalDate geboortedatum,
                   List<String> certificaties) {
        super(voornaam, achternaam, rijksregisterNummer, geboortedatum, certificaties);
    }
}
