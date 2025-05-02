package src.core;
import java.time.*;
// Classe Employé

public class Employe extends Personne {
    
    private String MatriculeNumber ;
    private TypeFonction typeFonction ;

    public Employe(String nom , String prenom , LocalDate dateNaissance , boolean handicap ,String MatriculeNumber , TypeFonction TypeFonction) {
        super(null, null, null, false);
        this.MatriculeNumber = MatriculeNumber ;
        this.typeFonction = TypeFonction ;
    }
    public String getIdentifier() {
    	return this.MatriculeNumber;
    }
    public TypeFonction getFunction() {
    	return this.typeFonction;
    }
}