package it.eforhum.corsojava.oop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArchivioFatture {

	private static final Logger log = LogManager.getLogger(ArchivioFatture.class);

	private int lastNumFattura = 1;
	private int anno;
	private List<Fattura> listFatture = new ArrayList<>();
	private Set<Cliente> listCliente = new HashSet<>();

	public ArchivioFatture(int anno) {

		log.debug("Build a new instance of ArchivioFatture [" + anno + "]");
		this.anno = anno;
	}

	public void registraFattura(LocalDate data, double importo, Cliente cliente) {

		log.debug("Try to register a new fattura {} {} {}", data, importo, cliente);
		Fattura fattura = new Fattura();
		fattura.setCliente(cliente);
		fattura.setData(data);
		fattura.setImporto(importo);
		fattura.setNumero(lastNumFattura + "/" + anno);

		this.listFatture.add(fattura);
		this.listCliente.add(cliente);

		this.lastNumFattura++;
	}

	public List<Fattura> getElencoFatture() {

		return this.listFatture;
	}

	public double calcolaTotale() {

		double totale = 0;
		for (Fattura f : this.listFatture) {
			totale += f.getImporto();
		}

		return totale;
	}

	public Set<Cliente> getElencoClienti() {

		return this.listCliente;
	}

	public List<Fattura> findByCliente(String codiceCliente) {

		List<Fattura> result = new ArrayList<>();
		for (Fattura f : this.listFatture) {

			if (f.getCliente().getCodice().equals(codiceCliente)) {
				result.add(f);
			}
		}

		return result;
	}
}
