package comparacion;

import java.util.ArrayList;
import java.util.List;

public class A implements Comparable<A>{
	
	public String s; //El String implementa el método Comparable 
	//entonces su funcionamiento depende cómo esté integrado en el String.

	
	public A(String s) {
		this.s = s;
	}

	
	@Override
	public String toString() {
		return "A [s=" + s + "]";
	}


	@Override
	public int compareTo(A a) {
		
		
		
		//1. Implementación del Comparable que está en el String. Orden normal:
		return this.s.compareTo(a.s);
		
		//2. Orden Inverso
		//return a.s.compareTo(this.s);
		
		//3. Orden por número de caracteres
		//3.1 Si se quiere en orden ascendente
		//return this.s.length() - a.s.length();
		//3.2 Si se quiere en orden descendente
		//return a.s.length() - this.s.length();
		
		
	}
	
	/*Para ordenar una clase es necesario implementar la interfaz
	 * funcional Comparable<Object>.
	 * 
	 * */
	public static void main(String[] args) {
		
		List<A> lista = new ArrayList<>();
		
		lista.add(new A ("one"));
		lista.add(new A ("two"));
		lista.add(new A ("three"));
		lista.add(new A ("four"));
		
		
		//I. sorted que tira de Comparable
		
		/*lista.stream()
		.sorted()
		.forEach(System.out::println);*/
		
		//II. sorted que tira de Comparator
		
		//1. Orden normal
		lista.stream()
		.sorted((a1, a2) -> 0) 
		.forEach(System.out::println);
		
		//2. Orden inverso
		
		lista.stream()
		.sorted((a1, a2) ->  ( a2.s.length() - a1.s.length())) 
		.forEach(System.out::println);
		
		
		
		
	}
	
}
