package jana60;

public class Oratore {
	
	private String nome;
	private String cognome;
	private String titolo;
	
	public Oratore(String nome, String cognome, String titolo) throws NullPointerException{
		super();
		
		stringheVuoteONull(nome, cognome, titolo);
		
		this.nome = nome;
		this.cognome = cognome;
		this.titolo = titolo;
	}
	
	private void stringheVuoteONull (String nome, String cognome, String titolo) {
		if (nome == null || nome.equalsIgnoreCase("") || cognome == null || cognome.equalsIgnoreCase("") || 
				titolo == null || titolo.equalsIgnoreCase("")) {
			throw new NullPointerException ("Completa tutti i paramentri per continuare");
		}
	}

	@Override
	public String toString() {
		return "Nome oratore: " + nome + " " + cognome + "\nTitolo: " + titolo;
	}
	
	
}
