package sports;

import java.util.LinkedList;
import java.util.List;

public class Attivita {
	
	private String nome_attivita;
	private List<String> categorie_attivita;
	private List<String> prodotti_attivita;
	
	public Attivita (String nome_attivita) {
		this.nome_attivita=nome_attivita;
		categorie_attivita= new LinkedList<>();
		prodotti_attivita = new LinkedList<>();
	}

	public List<String> getCategorie_attivita() {
		return categorie_attivita;
	}

	public void setCategorie_attivita(List<String> categorie_attivita) {
		this.categorie_attivita = categorie_attivita;
	}

	public String getNome_attivita() {
		return nome_attivita;
	}

	public void setNome_attivita(String nome_attivita) {
		this.nome_attivita = nome_attivita;
	}

	public List<String> getProdotti_attivita() {
		return prodotti_attivita;
	}

	public void setProdotti_attivita(List<String> prodotti_attivita) {
		this.prodotti_attivita = prodotti_attivita;
	}

	
	

}
