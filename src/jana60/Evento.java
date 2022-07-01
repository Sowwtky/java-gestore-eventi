package jana60;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	//attributi
	private String titolo;
	private LocalDate data;
	private int numeroPostiTotali;
	private int numeroPostiPrenotati;
	
	//costruttore
	public Evento(String titolo, LocalDate data, int numeroPostiTotali) throws IllegalArgumentException{
		super();
		
		//controlli
		dataPassata(data);
		numeroPostiTotaliPositivi(numeroPostiTotali);
		
		//valorizzo costruttori
		this.titolo = titolo;
		this.data = data;
		this.numeroPostiTotali = numeroPostiTotali;
		this.numeroPostiPrenotati = 0;
	}
	
	//metodi public 
	public int prenota(int numeroPostiPrenotati) throws IllegalArgumentException{
		dataPassata(data);
		alCompleto(numeroPostiTotali, numeroPostiPrenotati);
		this.numeroPostiPrenotati=numeroPostiPrenotati;
		return numeroPostiPrenotati++;
	}
	
	public int disdici(int numeroPostiPrenotati) throws IllegalArgumentException{
		dataPassata(data);
		nessunaPrenotazione(numeroPostiPrenotati);
		this.numeroPostiPrenotati=numeroPostiPrenotati;
		return numeroPostiPrenotati--;
	}
	
	//metodi di validazione (private)
	private void dataPassata(LocalDate data) throws IllegalArgumentException{
		if(data.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("La data dell'evento non puó essere passata");
		}
	}
	
	private void numeroPostiTotaliPositivi(int numeroPostiTotali) throws IllegalArgumentException{
		if (numeroPostiTotali < 0) {
			throw new IllegalArgumentException("I posti totali non possono essere minori di 0");
		}
	}
	
	private void alCompleto(int numeroPostiTotali, int numeroPostiPrenotati) throws IllegalArgumentException{
		if (numeroPostiTotali > numeroPostiPrenotati) {
			throw new IllegalArgumentException("Siamo al completo");
		}
	}
	
	private void nessunaPrenotazione(int numeroPostiPrenotati) throws IllegalArgumentException{
		if(numeroPostiPrenotati <= 0) {
			throw new IllegalArgumentException("Il numero di posti prenotati non puó essere minore di 0");
		}
		
	}

	//getter e setter
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) throws NullPointerException{
		//controllo che il titolo non sia null
		if (titolo == null) {
			throw new NullPointerException ("L'evento deve avere un titolo");
		}
		
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) throws IllegalArgumentException {
		//controllo che la data inserita non sia passata
		dataPassata(data);
		this.data = data;
	}

	public int getNumeroPostiTotali() {
		return numeroPostiTotali;
	}

	public int getNumeroPostiPrenotati() {
		return numeroPostiPrenotati;
	}
	
	//override
	@Override
	public String toString() {
		return "Titolo evento: " + titolo + "\nData evento: " + formatter.format(data);
	}
	
	
	
}
