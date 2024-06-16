package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Supermercado {

	private String nombre;
	private List<Alimento> alimentos;

	public Supermercado(String nombre) {
		this.nombre = nombre;
		this.alimentos = new ArrayList<>();
	}

	public Boolean agregarAlimento(Alimento agrandador) {
		return this.alimentos.add(agrandador);

	}

	public List<Alimento> alimentosOrdenadosDeManeraDescendente() {

		List<Alimento> alimentosOrdenadosDeManeraDescendente = new ArrayList<>();

		alimentosOrdenadosDeManeraDescendente.addAll(this.alimentos);
		Collections.sort(alimentosOrdenadosDeManeraDescendente);

		return alimentosOrdenadosDeManeraDescendente;
	}

	public void setAlimentos(List<Alimento> alimentos) {
		this.alimentos = alimentos;
	}

	public Boolean comprarAlimento(Alimento alimentoElegido, Alicia alicia) {

		
		Boolean alimentoComprado = false;
		if (alicia.getDinero() >= alimentoElegido.getPrecio()) {
			alicia.descontarDinero(alimentoElegido.getPrecio());
			alicia.obtenerAlimento(alimentoElegido);
			eliminarAlimentoDelSupermercado(alimentoElegido);
			alimentoComprado = true;
		}
		
		return alimentoComprado;

	}

	private void eliminarAlimentoDelSupermercado(Alimento alimentoElegido) {

		for (Alimento alimento : alimentos) {
			if (alimento.compareTo(alimentoElegido) == 0) {

				this.alimentos.remove(alimento);
				break;

			}

		}

	}

}
