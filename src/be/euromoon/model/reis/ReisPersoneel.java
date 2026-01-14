package be.euromoon.model.reis;

import be.euromoon.model.personen.Personeelslid;

/**
 * Koppelt een personeelslid aan een specifieke rol binnen een reis.
 *
 * Deze klasse wordt gebruikt om bij te houden welk personeelslid
 * welke functie vervult tijdens een bepaalde reis, zoals bestuurder
 * of steward.
 */
public class ReisPersoneel {

    private Personeelslid personeelslid;
    private ReisRol rol;

    public ReisPersoneel(Personeelslid personeelslid, ReisRol rol) {
        this.personeelslid = personeelslid;
        this.rol = rol;
    }

    /**
     * Geeft de rol terug die het personeelslid vervult tijdens de reis.
     *
     * @return de rol van het personeelslid
     */
    public ReisRol getRol() {
        return rol;
    }
}
