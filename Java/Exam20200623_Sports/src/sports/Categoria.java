package sports;

import java.util.LinkedList;
import java.util.List;

public class Categoria {

	private String nome_categoria;
	private List<String> attivita_categoria;
	private List<String> prodotti_categoria;
	
	public Categoria (String nome_categoria) {
		this.nome_categoria = nome_categoria;
		attivita_categoria = new LinkedList<>();
		prodotti_categoria = new LinkedList<>();
	}

	public List<String> getAttivita_categoria() {
		return attivita_categoria;
	}

	public void setAttivita_categoria(List<String> attivita_categoria) {
		this.attivita_categoria = attivita_categoria;
	}

	public String getNome_categoria() {
		return nome_categoria;
	}

	public void setNome_categoria(String nome_categoria) {
		this.nome_categoria = nome_categoria;
	}

	public List<String> getProdotti_categoria() {
		return prodotti_categoria;
	}

	public void setProdotti_categoria(List<String> prodotti_categoria) {
		this.prodotti_categoria = prodotti_categoria;
	}
	
	
}
