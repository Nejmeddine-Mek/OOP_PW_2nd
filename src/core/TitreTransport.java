package src.core;
import java.time.*;

// Abstract class for titles of transport
abstract public class TitreTransport {
	protected static int idGenerator = 1;
    protected int id;
    protected LocalDateTime dateAchat;
    protected double prix;
    
    abstract public boolean estValide (LocalDate data) throws TitreNonValideException;
    abstract public String getDateAchat();
    
    public int getId() {
    	return this.id;
    }
    public double getPrix() {
    	return this.prix;
    }
    
}