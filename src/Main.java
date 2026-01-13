import be.euromoon.model.personen.Passagier;
import be.euromoon.model.reis.Reis;
import be.euromoon.model.reis.Station;
import be.euromoon.model.ticket.Ticket;
import be.euromoon.model.trein.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final List<Passagier> passagiers = new ArrayList<>();
    private static final List<Reis> reizen = new ArrayList<>();
    private static final List<Trein> treinen = new ArrayList<>();

    public static void main(String[] args) {

        // Demo-trein aanmaken
        Locomotief loco = new Class373();
        Trein trein = new Trein(loco);
        trein.voegWagonToe(new Wagon(50, Reisklasse.EERSTE_KLASSE));
        trein.voegWagonToe(new Wagon(100, Reisklasse.TWEEDE_KLASSE));
        treinen.add(trein);

        boolean running = true;
        while (running) {
            toonMenu();
            String keuze = scanner.nextLine();

            switch (keuze) {
                case "1" -> registreerPassagier();
                case "2" -> maakReisAan();
                case "3" -> koppelTreinAanReis();
                case "4" -> verkoopTicket();
                case "5" -> printBoardingLijst();
                case "0" -> running = false;
                default -> System.out.println("Ongeldige keuze");
            }
        }

        System.out.println("Applicatie afgesloten.");
    }

    private static void toonMenu() {
        System.out.println("\n=== EUROMOON MENU ===");
        System.out.println("1. Registreer passagier");
        System.out.println("2. Maak reis aan");
        System.out.println("3. Koppel trein aan reis");
        System.out.println("4. Verkoop ticket");
        System.out.println("5. Afdrukken boardinglijst");
        System.out.println("0. Afsluiten");
        System.out.print("Keuze: ");
    }

    private static void registreerPassagier() {
        System.out.print("Voornaam: ");
        String voornaam = scanner.nextLine();

        System.out.print("Achternaam: ");
        String achternaam = scanner.nextLine();

        System.out.print("Rijksregisternummer: ");
        String rrn = scanner.nextLine();

        boolean bestaat = passagiers.stream()
                .anyMatch(p -> p.getRijksregisterNummer().equals(rrn));

        if (bestaat) {
            System.out.println("Passagier bestaat al.");
            return;
        }

        System.out.print("Geboortedatum (yyyy-MM-dd): ");
        String datum = scanner.nextLine();

        Passagier passagier = new Passagier(
                voornaam,
                achternaam,
                rrn,
                LocalDate.parse(datum)
        );

        passagiers.add(passagier);
        System.out.println("Passagier geregistreerd.");
    }

    private static void maakReisAan() {
        System.out.print("Vertrekstation: ");
        String vertrek = scanner.nextLine();

        System.out.print("Aankomststation: ");
        String aankomst = scanner.nextLine();

        if (vertrek.equalsIgnoreCase(aankomst)) {
            System.out.println("Vertrek en aankomst mogen niet gelijk zijn.");
            return;
        }

        System.out.print("Vertrektijd (yyyy-MM-dd HH:mm): ");
        String tijd = scanner.nextLine();

        LocalDateTime vertrekTijd = LocalDateTime.parse(
                tijd,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        );

        Reis reis = new Reis(
                new Station(vertrek, ""),
                new Station(aankomst, ""),
                vertrekTijd,
                null
        );

        reizen.add(reis);
        System.out.println("Reis aangemaakt.");
    }

    private static void koppelTreinAanReis() {
        Reis reis = kiesReis();
        if (reis == null) return;

        if (reis.getTrein() != null) {
            System.out.println("Deze reis heeft al een trein.");
            return;
        }

        Trein trein = kiesTrein();
        if (trein == null) return;

        reis.setTrein(trein);
        System.out.println("Trein gekoppeld aan reis.");
    }

    private static void verkoopTicket() {
        Reis reis = kiesReis();
        if (reis == null) return;

        if (reis.getTrein() == null) {
            System.out.println("Deze reis heeft nog geen trein.");
            return;
        }

        Passagier passagier = kiesPassagier();
        if (passagier == null) return;

        if (reis.heeftGeldigTicket(passagier)) {
            System.out.println("Passagier heeft al een ticket.");
            return;
        }

        System.out.print("Klasse (1 = eerste, 2 = tweede): ");
        String keuze = scanner.nextLine();

        Reisklasse klasse = keuze.equals("1")
                ? Reisklasse.EERSTE_KLASSE
                : Reisklasse.TWEEDE_KLASSE;

        boolean succes = reis.verkoopTicket(passagier, klasse);

        if (succes) {
            System.out.println("Ticket verkocht.");
        } else {
            System.out.println("Geen plaatsen meer beschikbaar.");
        }
    }

    private static void printBoardingLijst() {
        Reis reis = kiesReis();
        if (reis == null) return;

        if (reis.getTickets().isEmpty()) {
            System.out.println("Geen tickets voor deze reis.");
            return;
        }

        String tijd = reis.getVertrekTijd()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm"));

        String bestandsnaam = reis.getVertrekStation().getNaam()
                + "_"
                + reis.getAankomstStation().getNaam()
                + "_"
                + tijd
                + ".txt";

        Path path = Path.of(bestandsnaam);

        List<String> lijnen = new ArrayList<>();
        for (Ticket t : reis.getTickets()) {
            Passagier p = t.getPassagier();
            lijnen.add(
                    p.getVoornaam() + " " + p.getAchternaam()
                            + " | " + p.getRijksregisterNummer()
                            + " | " + t.getReisklasse()
            );
        }

        try {
            Files.write(path, lijnen);
            System.out.println("Boardinglijst aangemaakt: " + bestandsnaam);
        } catch (IOException e) {
            System.out.println("Fout bij schrijven bestand.");
        }
    }

    private static Reis kiesReis() {
        if (reizen.isEmpty()) {
            System.out.println("Geen reizen beschikbaar.");
            return null;
        }

        for (int i = 0; i < reizen.size(); i++) {
            System.out.println((i + 1) + ". " + reizen.get(i));
        }

        System.out.print("Kies reis: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index < 0 || index >= reizen.size()) return null;
            return reizen.get(index);
        } catch (NumberFormatException e) {
            System.out.println("Ongeldige invoer.");
            return null;
        }
    }

    private static Passagier kiesPassagier() {
        if (passagiers.isEmpty()) {
            System.out.println("Geen passagiers beschikbaar.");
            return null;
        }

        for (int i = 0; i < passagiers.size(); i++) {
            System.out.println((i + 1) + ". " + passagiers.get(i));
        }

        System.out.print("Kies passagier: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index < 0 || index >= passagiers.size()) return null;
            return passagiers.get(index);
        } catch (NumberFormatException e) {
            System.out.println("Ongeldige invoer.");
            return null;
        }
    }

    private static Trein kiesTrein() {
        if (treinen.isEmpty()) {
            System.out.println("Geen treinen beschikbaar.");
            return null;
        }

        for (int i = 0; i < treinen.size(); i++) {
            System.out.println((i + 1) + ". " + treinen.get(i));
        }

        System.out.print("Kies trein: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index < 0 || index >= treinen.size()) return null;
            return treinen.get(index);
        } catch (NumberFormatException e) {
            System.out.println("Ongeldige invoer.");
            return null;
        }
    }
}
