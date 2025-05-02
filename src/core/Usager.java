package src.core;

import java.time.LocalDate;

public class Usager extends Personne {

    public Usager(String nom , String prenom , LocalDate dateNaissance , boolean handicap) {
        super(nom, prenom, dateNaissance, handicap);
    }
}