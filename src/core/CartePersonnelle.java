package src.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class CartePersonnelle extends TitreTransport{
	private String nom;
	private String prenom;
	private int age;
	private String type;

	public CartePersonnelle(Personne person) throws ReductionImpossibleException {
		this.id = super.idGenerator++;
		this.dateAchat = LocalDateTime.now();
		this.nom = person.nom;
		this.prenom = person.prenom;
		this.age = Period.between(person.getBirthDate(), LocalDate.now()).getYears();
		if(this.age <= 25) {
			this.type = "JUNIOR";
			this.prix = 5000 * (1 - 0.3);
		} else if(this.age >= 65) {
			this.type = "SENIOR";
			this.prix = 5000 * ( 1 - 0.25);
		}
		
		if(person instanceof Employe) {
			// if employer verify if they have a serial number and a post
			if(((Employe) person).getFunction() == null || ((Employe) person).getIdentifier() == null) {
				throw new ReductionImpossibleException(" Reduction impossible");
			}
			this.type = "PARTENAIRE";
			this.prix = 5000 * ( 1 - 0.4 );
		}
		
		if(person.handicap) {
			this.type = "SOLIDARITE";
			this.prix = 5000 / 2 ;
		}

		if(this.type == null) {
			throw new ReductionImpossibleException(" Reduction impossible");
		}
		
		
	}

	@Override
	public boolean estValide(LocalDate date) throws TitreNonValideException {
		// I have absolutely no idea how Period.betwee works!
		boolean valid = Period.between(date, LocalDate.of(this.dateAchat.getYear() + 1, this.dateAchat.getMonthValue(), this.dateAchat.getDayOfMonth())).getMonths() > 0;
		if(!valid) {
			throw new TitreNonValideException("Personal card number "+this.id+" is expired, it's only available in: " + this.getDateAchat());
		}
	return valid;
	}

	@Override
	public String getDateAchat() {
		String month = this.dateAchat.getMonthValue() < 10 ? "0" + this.dateAchat.getMonthValue() : "" + this.dateAchat.getMonthValue();
		StringBuilder msg = new StringBuilder(this.dateAchat.getYear()+"-"+month+"-"+this.dateAchat.getDayOfMonth()); 
		return msg.toString();
	}
	public String getType() {
		return this.type;
	}
}

