package be.euromoon.model.reis;

public class Station {
    private String naam;
    private String land;

    public Station(String naam, String land) {
        this.naam = naam;
        this.land = land;
    }

    public String getNaam() {
        return naam;
    }
}
