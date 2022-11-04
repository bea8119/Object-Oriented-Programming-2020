package sports;

public class Recenzione {
	
	private String nome_prodotto;
	private String utente;
	private Integer num_stelle;
	private String commento;
	
	public Recenzione(String nome_prodotto, String utente, Integer num_stelle, String commento) {
		this.nome_prodotto=nome_prodotto;
		this.utente=utente;
		this.num_stelle = num_stelle;
		this.commento = commento;
	}

	public String getNome_prodotto() {
		return nome_prodotto;
	}

	public void setNome_prodotto(String nome_prodotto) {
		this.nome_prodotto = nome_prodotto;
	}

	public String getUtente() {
		return utente;
	}

	public void setUtente(String utente) {
		this.utente = utente;
	}

	public Integer getNum_stelle() {
		return num_stelle;
	}

	public void setNum_stelle(Integer num_stelle) {
		this.num_stelle = num_stelle;
	}

	public String getCommento() {
		return commento;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}
	
	

}
