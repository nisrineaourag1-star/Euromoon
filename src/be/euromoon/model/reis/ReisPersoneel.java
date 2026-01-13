package be.euromoon.model.reis;

import be.euromoon.model.personen.Personeelslid;

public class ReisPersoneel {
    private Personeelslid personeelslid;
    private ReisRol rol;

    public ReisPersoneel(Personeelslid personeelslid, ReisRol rol) {
        this.personeelslid = personeelslid;
        this.rol = rol;
    }

    public ReisRol getRol() {
        return rol;
    }
}
