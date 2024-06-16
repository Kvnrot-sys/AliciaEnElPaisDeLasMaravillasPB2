package ar.edu.unlam.dominio;

public class Achicador extends Alimento {

	private TipoDeAchicador tipoDeAlimentoAchicador;

	public Achicador(String nombreDelAlimentoAchicador, Double precio, TipoDeAchicador tipo) {
		super(nombreDelAlimentoAchicador,precio);
		this.tipoDeAlimentoAchicador = tipo;
	}

}
