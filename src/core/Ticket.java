package src.core;

import java.time.*;

public class Ticket extends TitreTransport {
	
	private static int idGenerator = 1;
	public Ticket() {
		this.id = super.idGenerator++;
		this.prix = 50;
		this.dateAchat = LocalDateTime.now();
	}
	
	
	public boolean estValide(LocalDate date) throws TitreNonValideException{

		boolean valid = date.equals(LocalDate.of(this.dateAchat.getYear(), this.dateAchat.getMonthValue(), this.dateAchat.getDayOfMonth()));
			if(!valid) {
				throw new TitreNonValideException("Ticket number"+ this.id+"is expired, it's only available in: " + this.getDateAchat());
			}
		return valid;
	}
	
	public String getDateAchat() {
		String month = this.dateAchat.getMonthValue() < 10 ? "0" + this.dateAchat.getMonthValue() : "" + this.dateAchat.getMonthValue();
		StringBuilder res = new StringBuilder(this.dateAchat.getYear()+"-"+month+"-"+this.dateAchat.getDayOfMonth());
		
		return res.toString();
	}
	
}
