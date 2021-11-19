package it.eforhum.corsojava.oop;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cliente {

	private static Logger log = LogManager.getLogger(Cliente.class);

	private String codice;
	private String denominazione;
	private String piva;
	private String indirizzo;

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public String getPiva() {
		return piva;
	}

	public void setPiva(String piva) {
		this.piva = piva;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	@Override
	public int hashCode() {
		int hash = Objects.hash(codice, denominazione, indirizzo, piva);
		log.debug("richiamato metodo hash [{}]", hash);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(codice, other.codice) && Objects.equals(denominazione, other.denominazione)
				&& Objects.equals(indirizzo, other.indirizzo) && Objects.equals(piva, other.piva);
	}

	@Override
	public String toString() {
		return "Cliente [codice=" + codice + ", denominazione=" + denominazione + ", piva=" + piva + ", indirizzo="
				+ indirizzo + "]";
	}

}
