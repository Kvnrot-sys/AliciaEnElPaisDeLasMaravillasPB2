package ar.edu.unlam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import ar.edu.unlam.dominio.Achicador;
import ar.edu.unlam.dominio.Agrandador;
import ar.edu.unlam.dominio.Alicia;
import ar.edu.unlam.dominio.Alimento;
import ar.edu.unlam.dominio.Supermercado;
import ar.edu.unlam.dominio.TipoDeAchicador;
import ar.edu.unlam.dominio.TipoDeAgrandador;

public class Test {

	private static final String NOMBRE = "Supermercado";
	private Supermercado supermercado;

	@Before
	public void init() {
		this.supermercado = new Supermercado(NOMBRE);

	}

	@org.junit.Test
	public void queSePuedaCrearAAlicia() {

		Alicia alicia = crearAlicia();

		assertNotNull(alicia);

	}

	private Alicia crearAlicia() {
		Integer peso = 45;
		String nombre = "Alicia";
		Integer edad = 18;
		Double dinero = 500.0;

		Alicia alicia = new Alicia(peso, nombre, edad, dinero);
		return alicia;
	}

	@org.junit.Test
	public void queSePuedaCrearAlimentoAchicador() {

		String nombreDelAlimentoAchicador = "Guaymallen";
		TipoDeAchicador tipo = TipoDeAchicador.ALFAJOR;
		Double precio = 20.0;

		Alimento achicador = generarAchicador(nombreDelAlimentoAchicador, precio, tipo);

		assertNotNull(achicador);

	}

	@org.junit.Test
	public void queSePuedaCrearAlimentoAgrandador() {

		String nombreDelAlimentoAgrandador = "Milka";
		TipoDeAgrandador tipo = TipoDeAgrandador.BOCADITO_DE_CHOCOLATE;
		Double precio = 20.0;

		Alimento agrandador = generarAgrandador(nombreDelAlimentoAgrandador, precio, tipo);

		assertNotNull(agrandador);

	}

	@org.junit.Test
	public void queSePuedaAñadirAlimentosAlSupermercado() {

		String nombreDelAlimentoAgrandador = "Milka";
		TipoDeAgrandador tipoAgrandador = TipoDeAgrandador.BOCADITO_DE_CHOCOLATE;
		Double precio = 20.0;

		Alimento agrandador = generarAgrandador(nombreDelAlimentoAgrandador, precio, tipoAgrandador);

		String nombreDelAlimentoAchicador = "Guaymallen";
		TipoDeAchicador tipoAchicador = TipoDeAchicador.ALFAJOR;
		Double precio2 = 20.0;

		Alimento achicador = generarAchicador(nombreDelAlimentoAchicador, precio2, tipoAchicador);

		assertTrue(this.supermercado.agregarAlimento(agrandador));
		assertTrue(this.supermercado.agregarAlimento(achicador));

	}

	@org.junit.Test
	public void queSePudaObtenerAlimentosOrdenadosDescendentemente() {

		String nombreDelAlimentoAgrandador = "Aguila";
		TipoDeAgrandador tipoAgrandador = TipoDeAgrandador.BOCADITO_DE_CHOCOLATE;
		Double precio = 20.0;

		Alimento agrandador = generarAgrandador(nombreDelAlimentoAgrandador, precio, tipoAgrandador);

		String nombreDelAlimentoAchicador = "Guaymallen";
		TipoDeAchicador tipoAchicador = TipoDeAchicador.ALFAJOR;
		Double precio2 = 20.0;

		Alimento achicador = generarAchicador(nombreDelAlimentoAchicador, precio2, tipoAchicador);

		assertTrue(this.supermercado.agregarAlimento(agrandador));
		assertTrue(this.supermercado.agregarAlimento(achicador));

		List<Alimento> alimentosOrdenados = this.supermercado.alimentosOrdenadosDeManeraDescendente();

		int i = 0;
		for (Alimento alimento : alimentosOrdenados) {

			switch (i) {
			case 0:
				assertTrue(alimento.compareTo(achicador) == 0);
				break;

			case 1:
				assertTrue(alimento.compareTo(agrandador) == 0);
				break;
			}

			i++;

		}

	}

	@org.junit.Test
	public void queAlComprarAlimentoEsteSeDescuente() {

		Alicia alicia = crearAlicia();

		Alimento achicador = generarAchicador("Guaymallen", 200.0, TipoDeAchicador.ALFAJOR);
		this.supermercado.agregarAlimento(achicador);

		this.supermercado.comprarAlimento(achicador, alicia);

		assertEquals(300.0, alicia.getDinero(), 0.01);

	}

	@org.junit.Test
	public void queNoSeExcedaDelDineroDisponible() {

		Alicia alicia = crearAlicia();

		// ALICIA TIENE 500

		Alimento achicador = generarAchicador("Guaymallen", 600.0, TipoDeAchicador.ALFAJOR);
		this.supermercado.agregarAlimento(achicador);

		this.supermercado.comprarAlimento(achicador, alicia);

		assertEquals(500.0, alicia.getDinero(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaVerificarElAgrandamiento() {

		Alicia alicia = crearAlicia();

		// ALICIA TIENE 180 de altura

		Alimento agrandador = generarAgrandador("Guaymallen", 200.0, TipoDeAgrandador.CARAMELO);
		this.supermercado.agregarAlimento(agrandador);

		this.supermercado.comprarAlimento(agrandador, alicia);

		alicia.consumirAlimento(agrandador);

		assertEquals(220, alicia.getAltura(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaVerificarElAchicamiento() {

		Alicia alicia = crearAlicia();

		// ALICIA TIENE 180 de altura

		Alimento achicador = generarAchicador("Guaymallen", 200.0, TipoDeAchicador.ALFAJOR);
		this.supermercado.agregarAlimento(achicador);

		this.supermercado.comprarAlimento(achicador, alicia);

		alicia.consumirAlimento(achicador);

		assertEquals(130, alicia.getAltura(), 0.01);

	}

	@org.junit.Test
	public void queAliciaNoAgrandeSiSuperaElLimteDe280() {

		Alicia alicia = crearAlicia();

		// ALICIA TIENE 180 de altura

		Alimento agrandador = generarAgrandador("Guaymallen", 200.0, TipoDeAgrandador.CARAMELO);
		Alimento agrandador2 = generarAgrandador("Guaymallen", 200.0, TipoDeAgrandador.CARAMELO);
		Alimento agrandador3 = generarAgrandador("Guaymallen", 50.0, TipoDeAgrandador.CARAMELO);

		this.supermercado.agregarAlimento(agrandador);
		this.supermercado.agregarAlimento(agrandador2);
		this.supermercado.agregarAlimento(agrandador3);

		this.supermercado.comprarAlimento(agrandador, alicia);
		this.supermercado.comprarAlimento(agrandador2, alicia);
		this.supermercado.comprarAlimento(agrandador3, alicia);

		alicia.consumirAlimento(agrandador);
		assertEquals(220, alicia.getAltura(), 0.01);
		alicia.consumirAlimento(agrandador2);
		assertEquals(260, alicia.getAltura(), 0.01);

		alicia.consumirAlimento(agrandador3);

		assertEquals(260, alicia.getAltura(), 0.01);

	}

	@org.junit.Test
	public void queAliciaNoEncojaSiSuperaElLimteMinimoDe50() {

		Alicia alicia = crearAlicia();

		// ALICIA TIENE 180 de altura

		Alimento achicador = generarAchicador("Guaymallen", 200.0, TipoDeAchicador.ALFAJOR);
		Alimento achicador2 = generarAchicador("Guaymallen", 200.0, TipoDeAchicador.ALFAJOR);
		Alimento achicador3 = generarAchicador("Guaymallen", 10.0, TipoDeAchicador.ALFAJOR);

		this.supermercado.agregarAlimento(achicador);
		this.supermercado.agregarAlimento(achicador2);
		this.supermercado.agregarAlimento(achicador3);

		this.supermercado.comprarAlimento(achicador, alicia);
		this.supermercado.comprarAlimento(achicador2, alicia);
		this.supermercado.comprarAlimento(achicador3, alicia);

		alicia.consumirAlimento(achicador);
		assertEquals(130, alicia.getAltura(), 0.01);
		alicia.consumirAlimento(achicador2);
		assertEquals(80, alicia.getAltura(), 0.01);

		alicia.consumirAlimento(achicador3);

		assertEquals(80, alicia.getAltura(), 0.01);

	}

	@org.junit.Test
	public void queSePuedaOrdenarLosAlimentosAchicadoresDeAliciaDeManeraDescendente() {

		Alicia alicia = crearAlicia();

		// ALICIA TIENE 180 de altura

		Alimento achicador = generarAchicador("Guaymallen", 200.0, TipoDeAchicador.ALFAJOR);
		Alimento achicador2 = generarAchicador("Bimbo", 200.0, TipoDeAchicador.BAGEL);
		Alimento achicador3 = generarAchicador("Don Satur", 100.0, TipoDeAchicador.MASITA);

		this.supermercado.agregarAlimento(achicador);
		this.supermercado.agregarAlimento(achicador2);
		this.supermercado.agregarAlimento(achicador3);

		this.supermercado.comprarAlimento(achicador, alicia);
		this.supermercado.comprarAlimento(achicador2, alicia);
		this.supermercado.comprarAlimento(achicador3, alicia);
		
		
		List<Alimento> listaObtenida = alicia.ordenarAlimentosAchicadoresDescendentementeYDevolverlos();
		
		assertTrue(achicador.compareTo(listaObtenida.get(0)) == 0 );
		assertTrue(achicador3.compareTo(listaObtenida.get(1)) == 0 );
		assertTrue(achicador2.compareTo(listaObtenida.get(2)) == 0 );


	}

	private Alimento generarAchicador(String nombreDelAlimentoAchicador, Double precio, TipoDeAchicador tipo) {
		Alimento achicador = new Achicador(nombreDelAlimentoAchicador, precio, tipo);
		return achicador;
	}

	private Alimento generarAgrandador(String nombreDelAlimentoAchicador, Double precio, TipoDeAgrandador tipo) {
		Alimento agrandador = new Agrandador(nombreDelAlimentoAchicador, precio, tipo);
		return agrandador;
	}

}
