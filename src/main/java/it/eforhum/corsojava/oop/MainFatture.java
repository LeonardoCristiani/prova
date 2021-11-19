package it.eforhum.corsojava.oop;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainFatture {

	private static final Logger log = LogManager.getLogger(MainFatture.class);

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		log.info("Archivio Fatture STARTED");

		ArchivioFatture archivio = new ArchivioFatture(2020);

		Cliente cliente1 = new Cliente();
		cliente1.setCodice("0099");
		cliente1.setDenominazione("cliente prova");
		cliente1.setIndirizzo("via roma 1");
		cliente1.setPiva("IT000000");

		Cliente cliente2 = new Cliente();
		cliente2.setCodice("0002");
		cliente2.setDenominazione("cliente prova 2");
		cliente2.setIndirizzo("via russo 4");
		cliente2.setPiva("IT0008768");

		Cliente cliente3 = new Cliente();
		cliente3.setCodice("0011");
		cliente3.setDenominazione("cliente prova 3");
		cliente3.setIndirizzo("viale leonardo da vinci 11/a");
		cliente3.setPiva("IT0047474");

//		il cliente4 ha gli stessi dati del cliente3
//		di fatto rappresentano lo stesso riferimento
//		� quindi importante implementare in questo caso i metodi equals() and hashCode()
//		per far funzionare correttamente la struttura di dati "Set" o "Map"
		Cliente cliente4 = new Cliente();
		cliente4.setCodice("0011");
		cliente4.setDenominazione("cliente prova 3");
		cliente4.setIndirizzo("viale leonardo da vinci 11/a");
		cliente4.setPiva("IT0047474");

		archivio.registraFattura(LocalDate.of(2021, 8, 1), 1500, cliente1);
		archivio.registraFattura(LocalDate.of(2021, 9, 5), 500, cliente2);
		archivio.registraFattura(LocalDate.of(2021, 10, 22), 1700, cliente2);
		archivio.registraFattura(LocalDate.of(2021, 11, 1), 1100, cliente2);
		archivio.registraFattura(LocalDate.of(2021, 11, 5), 700, cliente1);
		archivio.registraFattura(LocalDate.of(2021, 3, 25), 4500, cliente3);
		archivio.registraFattura(LocalDate.of(2021, 6, 26), 5700, cliente3);
		archivio.registraFattura(LocalDate.of(2021, 9, 24), 8700, cliente4);

		log.debug("totale fatture " + archivio.calcolaTotale());

		List<Fattura> elencoFatture = archivio.getElencoFatture();
		for (Fattura fattura : elencoFatture) {
			log.debug(fattura);
		}

//		a differenza di una List il Set non � ordinato
//		non posso accedere quindi per posizione
//		l'ordine di un Set non garantisce l'ordine di inserimento
//		il Set non ammette duplicati
		Set<Cliente> elencoClienti = archivio.getElencoClienti();
		for (Cliente cliente : elencoClienti) {
			log.debug(cliente);
		}

		log.debug("Tempo applicazione [" + (System.currentTimeMillis() - startTime) + "ms ]");

		log.info("Archivio Fatture FINISHED");
	}
}
