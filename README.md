# Euromoon - Command Line Java Applicatie

## Overzicht
Euromoon is een proof-of-concept Java applicatie voor het reserveren en beheren van internationale treinreizen in Europa.  
De applicatie biedt een **command line interface (CLI)** waarmee passagiers kunnen worden geregistreerd, reizen worden aangemaakt, treinen worden gekoppeld, tickets verkocht en boardinglijsten gegenereerd.

Het systeem is ontworpen met **objectgeoriënteerd programmeren** en is uitbreidbaar voor nieuwe personeelsrollen en locomotieven.

---

## Functionaliteiten

De applicatie biedt via een menu de volgende opties:

1. **Registreer passagier**
    - Voer naam, achternaam, rijksregisternummer en geboortedatum in.
    - Dubbele registratie wordt voorkomen.

2. **Maak reis aan**
    - Voer vertrekstation, aankomststation en vertrektijd in.
    - Reizen met hetzelfde vertrek- en aankomststation worden niet toegestaan.

3. **Koppel trein aan reis**
    - Selecteer een bestaande reis en een bestaande trein.
    - Reizen kunnen slechts één trein hebben.

4. **Verkoop ticket**
    - Selecteer passagier, reis en reisklasse (eerste of tweede).
    - Tickets kunnen niet worden verkocht als er geen plaatsen beschikbaar zijn of als de passagier al een ticket heeft.

5. **Afdrukken boardinglijst**
    - Genereert een tekstbestand met de naam `Vertrek_Aankomst_yyyy-MM-dd_HH-mm.txt`.
    - Bevat de gegevens van alle passagiers met tickets voor de geselecteerde reis.

0. **Afsluiten**
    - Sluit de applicatie netjes af.

---

## Objectmodel

### Personen

- **Passagier**
    - Attributen: voornaam, achternaam, rijksregisternummer, geboortedatum
    - Methoden: `getVoornaam()`, `getAchternaam()`, `getRijksregisterNummer()`, `getGeboortedatum()`, `toString()`

- **Personeel** (abstract)
    - Wordt in de toekomst uitgebreid voor conducteurs, stewards en bagagepersoneel.
    - Attributen: certificaties

---

### Trein

- **Trein**
    - Attributen: locomotief, lijst van wagons
    - Methoden: `voegWagonToe(Wagon wagon)`, `getAantalBeschikbarePlaatsen(Reisklasse klasse)`, `toString()`

- **Locomotief** (abstract)
    - Subclasses: `Class373`, `Class374`
    - Attributen: type, maximaal aantal wagons, capaciteit
    - Methoden: `getTypeNaam()`, `getMaxWagons()`

- **Wagon**
    - Attributen: capaciteit, klasse (eerste/tweede)

- **Reisklasse** (enum)
    - `EERSTE_KLASSE`, `TWEEDE_KLASSE`

---

### Reizen

- **Reis**
    - Attributen: vertrekstation, aankomststation, vertrektijd, trein, lijst van tickets
    - Methoden: `setTrein(Trein trein)`, `verkoopTicket(Passagier passagier, Reisklasse klasse)`, `heeftGeldigTicket(Passagier passagier)`, `getTickets()`, `toString()`

- **Station**
    - Attributen: naam, land

---

### Ticket

- **Ticket**
    - Attributen: passagier, reis, klasse
    - Methoden: `getPassagier()`, `getReisklasse()`

---

## Main-klasse

- Beheert de CLI, toont het menu en verwerkt gebruikersinput.
- Belangrijkste methoden:
    - `toonMenu()`, `registreerPassagier()`, `maakReisAan()`, `koppelTreinAanReis()`, `verkoopTicket()`, `printBoardingLijst()`
    - Hulpmethodes: `kiesReis()`, `kiesPassagier()`, `kiesTrein()`

- Foutcontrole:
    - Dubbele passagiers voorkomen
    - Ticketoverboeking voorkomen
    - Ongeldige keuzes worden afgehandeld
    - Boardinglijst-bestandsnaam veilig gemaakt voor Windows en Mac (`:` wordt vervangen door `_`)

---

## Vereisten

- Java 17 of hoger
- CLI (command line interface)
- In-memory opslag (ArrayList) voor passagiers, reizen en treinen
- Javadoc aanwezig voor alle classes en belangrijke methoden

---
> **Opmerking:** Tijdens de ontwikkeling is gebruik gemaakt van AI-tools om fouten op te lossen, uitleg te geven over de code en om deze documentatie te genereren.
## Gebruik

1. Clone de repository of download de bestanden.
2. Compileer alle Java-bestanden:
   ```bash
   javac -d out src/**/*.java
3. Start de applicatie
4. Volg het menu om passagiers, reizen, treinen en tickets te beheren.

