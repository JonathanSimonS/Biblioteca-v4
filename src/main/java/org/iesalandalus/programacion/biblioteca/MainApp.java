package org.iesalandalus.programacion.biblioteca;

import org.iesalandalus.programacion.biblioteca.mvc.controlador.Controlador;
import org.iesalandalus.programacion.biblioteca.mvc.controlador.IControlador;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.FactoriaFuenteDatos;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.IModelo;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.Modelo;
import org.iesalandalus.programacion.biblioteca.mvc.vista.FactoriaVista;
import org.iesalandalus.programacion.biblioteca.mvc.vista.IVista;

/**
 * @author Jonathan Simón
 * @version v2
 *
 **/
public class MainApp  {

	public static void main(String[] args) {
		IModelo modelo = new Modelo(FactoriaFuenteDatos.FICHEROS.crear());
		IVista vista = procesarArgumentosVista(args);
		IControlador controlador = new Controlador(modelo, vista);
		controlador.comenzar();
	}
	
	private static IVista procesarArgumentosVista(String[] args) {
		IVista vista = FactoriaVista.IUGPESTANAS.crear();
		for (String argumento : args) {
			if (argumento.equalsIgnoreCase("-vpestanas")) {
				vista = FactoriaVista.IUGPESTANAS.crear();
			}
			else if (argumento.equalsIgnoreCase("-vtexto")) {
				vista = FactoriaVista.TEXTO.crear();
			}
		}
		return vista;
		
	}

}
