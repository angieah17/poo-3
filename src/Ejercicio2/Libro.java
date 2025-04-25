package Ejercicio2;

public class Libro {
	
	private String titulo;
	private boolean prestado;
	
	//Constructor
	
	public Libro(String titulo) {
		this.titulo = titulo;
	}

	
	//Método
	public void actualizarPrestamo() {
		
		prestado = prestado ? false : true;
		
	}
	

	//Getter
	public boolean isPrestado() {
		return prestado;
	}

	
	



	
	
	
	
}
