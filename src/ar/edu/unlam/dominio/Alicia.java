package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alicia {

	private Integer altura;
	private Integer peso;
	private String nombre;
	private Integer edad;
	private Double dinero;

	private List<Alimento> alimentosDeAlicia;

	public Alicia(Integer peso, String nombre, Integer edad, Double dinero) {
		// TODO Auto-generated constructor stub
		this.peso = peso;
		this.nombre = nombre;
		this.edad = edad;
		this.dinero = dinero;
		this.altura = 180;
		this.alimentosDeAlicia = new ArrayList<>();
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Double getDinero() {
		return dinero;
	}

	public void setDinero(Double dinero) {
		this.dinero = dinero;
	}

	public void descontarDinero(Double precioDelAlimento) {

		this.dinero -= precioDelAlimento;

	}

	public void obtenerAlimento(Alimento alimento) {
		this.alimentosDeAlicia.add(alimento);

	}

	public void consumirAlimento(Alimento alimento) {
		Alimento alimentoObtenido = devolverAlimentoDeLaListaDeAlicia(alimento);

		if (alimentoObtenido instanceof Agrandador) {
			agrandarAlicia();
		}
		if (alimentoObtenido instanceof Achicador) {
			achicarAlicia();
		}

	}

	private void achicarAlicia() {
		Integer auxiliar = this.altura - 50;

		if (auxiliar >= 50) {
			this.altura = auxiliar;

		}

	}

	private void agrandarAlicia() {

		Integer auxiliar = this.altura + 40;

		if (auxiliar <= 280) {
			this.altura = auxiliar;

		}

	}

	private Alimento devolverAlimentoDeLaListaDeAlicia(Alimento alimentoPar) {
		Alimento alimentoObtenido = null;

		for (Alimento alimento : alimentosDeAlicia) {

			if (alimento.compareTo(alimentoPar) == 0) {
				alimentoObtenido = alimento;
				break;

			}

		}

		return alimentoObtenido;
	}

	public List<Alimento> ordenarAlimentosAchicadoresDescendentementeYDevolverlos() {
		
		List<Alimento> achicadores = new ArrayList<>();
		
		
		for (Alimento alimento : this.alimentosDeAlicia) {
			if(alimento instanceof Achicador) {
				achicadores.add(alimento);
			}
			
		}
		
		
		Collections.sort(achicadores);
		return achicadores;
		
		
		
		
		
	}

}
