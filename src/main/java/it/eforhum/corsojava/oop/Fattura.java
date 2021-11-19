package it.eforhum.corsojava.oop;

import java.time.LocalDate;

public class Fattura {

	private String numero;
	private LocalDate data;
	private double importo;
	private Cliente cliente;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Fattura [numero=" + numero + ", data=" + data + ", importo=" + importo + ", cliente=" + cliente + "]";
	}

}
