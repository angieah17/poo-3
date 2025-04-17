package mipaquete;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {
	
	private List <Counter> contadores;
	private String nombre;
	
	
	public Ciudad(String nombre) {
		this.nombre = nombre;
		contadores = new ArrayList<Counter>();
	}
	
	public void addCounter (Counter counter) {
		contadores.add(counter);
	}

	public List<Counter> getContadores() {
		return contadores;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	
}
