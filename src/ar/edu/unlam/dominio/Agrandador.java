package ar.edu.unlam.dominio;

public class Agrandador extends Alimento {

	private TipoDeAgrandador tipoDeAgrandador;

	public Agrandador(String nombreDelAlimento, Double precio, TipoDeAgrandador tipo) {
		super(nombreDelAlimento, precio);
		this.tipoDeAgrandador = tipo;
	}

}
