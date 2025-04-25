package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

	//1. Propiedades
	List<Libro> librosExistentes = new ArrayList<>();

	//2. Métodos
	
	public void añadirLibro(Libro l) {

		librosExistentes.add(l);

	}
	
	public void prestar(Libro l) throws LibroNoExistenteException, LibroYaPrestadoException {

		if (!librosExistentes.contains(l))
			throw new LibroNoExistenteException("El libro no está disponible en esta biblioteca.");
		
		if (l.isPrestado()) {
			throw new LibroYaPrestadoException("El libro ya está prestado.");
		} 
		
		//Gestión del if/else revisar si hay algo que saqué antes del código, entonces no es necesario poner el else, porque si se da la 
		//excepción nunca pasaría por el else. 
		
		l.actualizarPrestamo();
		

	}
	
	
	 public void devolver() {
		 
	 }
	 

}
