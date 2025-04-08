package comparacion;

import java.util.ArrayList;
import java.util.List;

public class B{
	
	public String s; //El String implementa el método Comparable 
	//entonces su funcionamiento depende cómo esté integrado en el String.

	
	public B(String s) {
		this.s = s;
	}

	
	@Override
	public String toString() {
		return "B [s=" + s + "]";
	}

	
	/*Para ordenar una clase es necesario implementar la interfaz
	 * funcional Comparable<Object>.
	 * 
	 * Sino puedes usar el Comparator que esté dentro de sorted.
	 * 
	 * */
	public static void main(String[] args) {
		
		List<B> lista = new ArrayList<>();
		
		lista.add(new B ("one"));
		lista.add(new B ("two"));
		lista.add(new B ("three"));
		lista.add(new B ("four"));
		
		
		//I. sorted que tira de Comparable
		
		/*lista.stream()
		.sorted()
		.forEach(System.out::println);*/
		
		//II. sorted que tira de Comparator
		
		//1. Orden normal
		lista.stream()
		.sorted(); // No se puede usar el sorted solo porque no tiene un Comparable implementado en la clase
		
		
		//2. Orden inverso
		
		lista.stream()
		.sorted((b1, b2) ->  ( b2.s.length() - b1.s.length())) 
		.forEach(System.out::println);
		
		
		
		
	}
	
}
