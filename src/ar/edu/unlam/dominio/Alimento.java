package ar.edu.unlam.dominio;

import java.util.Objects;

public  class Alimento implements Comparable<Alimento> {

	private String nombre;
	private Double precio;
	

	public Alimento(String nombre,Double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int compareTo(Alimento o) {
		// TODO Auto-generated method stub
		return o.getNombre().compareTo(this.getNombre());
	}

	protected Double getPrecio() {
		return precio;
	}

	protected void setPrecio(Double precio) {
		this.precio = precio;
	}

	
	
	
	
	
	
	
	

}
