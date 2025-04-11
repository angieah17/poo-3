package ifs.colecciones;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ejemplo1 {
	public static void main(String[] args) {
		
		/*List es inmutable. Por eso no se le puede aplicar el removeif.
		 * */
		
		
		List<Integer> lista = new ArrayList<>();
				lista.add(1);
				lista.add(3);
				lista.add(4);
				lista.add(5);
				lista.add(7);
				lista.add(2);
		
		System.out.println("Programando funcionalmente");
		lista.forEach(x -> System.out.println("antes -> " + x)); //Usa la interfaz funcional consumer
		
		/*Cada vez que entra algo (x) lo consume y retorna void. 
		 * Esta expresión permite ponerle algo más, en cambio, el 
		 * de abajo solo imprime la x
		 * */
		
		lista.forEach(System.out::println);
		
		/*Otra forma de expresar el consumer anterior.
		 * */
		
		lista.removeIf(x -> x > 3);
		lista.forEach(x -> System.out.println("después -> " + x));
		lista.replaceAll(s -> s * 2);

		
		System.out.println("Programando NO funcionalmente");
		
		for (Integer num : lista) {
			System.out.println("antes ->" +  num);
		}
		
		for (Integer num : lista) {
			System.out.println(num);
		}
		
		for (int i = lista.size() - 1; i >= 0; i--) {
			if(lista.get(i) > 3) {
				lista.remove(i);
			}
			
		}
		
		for (Integer num : lista) {
			System.out.println("después ->" +  num);
		}
		
		//Quedarme con los pares al cuadrado
		
		lista.forEach(n -> System.out.println("ANTES del ejercicio -> " + n));
		
		lista.removeIf(n -> n % 2 == 1);
		lista.removeIf(n -> n == 0);
		lista.replaceAll(n -> n * n);
		lista.forEach(n -> System.out.println("después del ejercicio -> " + n));
		
		//Trabajando con Stream
		
		System.out.println("Streams");
		
		List<Integer> lista2 = new ArrayList<>();
		lista2.add(1);
		lista2.add(3);
		lista2.add(3);
		lista2.add(9);
		lista2.add(7);
		lista2.add(4);		
		
		//La lista se queda intacta, lo que se está modificando es el stream 
		//al final de todas las operaciones en el stream
		//el resultado es un dato, si uno quiere puede transformarlo 
		//a otra lista, pero la lista original no se está tocando. 
		
		Stream<Integer> miPrimerStream = lista2.stream();
		
		//La siguiente es una operación terminal, entonces no se puede seguir haciendo operaciones de Stream
		//Este devuelve un void, entonces ahí ya no es un Stream. En cambio
		//el limite devuelve un Stream por lo cual se puede aplicar otra operaicón de un Stream
		miPrimerStream
		.filter(x -> x > 2) //usa un Predicator
		.distinct() //Tira del equals, entonces habría que tener cuidado si estos dos se juntan
		.sorted()
		.limit(2)
		.peek(System.out::println) //El peek permite verlo, pero no es una operacion terminal como el foreach
		.map(n -> n * 100)
		.forEach(x -> System.out.println(x)); //Usa un consumer
		
		
		
		//Generalmente se encuentra así:
		
		/*lista2.stream()
			.filter(x -> x > 2) //usa un Predicator
			.sorted()
			.limit(2)
			.forEach(x -> System.out.println(x));
		 * */
		
		
		
		
	}
}
