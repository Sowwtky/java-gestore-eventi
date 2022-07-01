package jana60;

import java.time.LocalDate;

public class Conferenza extends Evento{

	private String argomento;
	private Oratore oratore;
	
	public Conferenza(String titolo, LocalDate data, int numeroPostiTotali, String argomento, Oratore oratore)
			throws NullPointerException, IllegalArgumentException {
		super(titolo, data, numeroPostiTotali);
		this.argomento = argomento;
		this.oratore = oratore;
	}

	@Override
	public String toString() {
		return super.toString() + "\nArgomento: " + argomento + "\n" + oratore.toString();
	}

	
}
