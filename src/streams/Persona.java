package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class Persona implements Comparable<Persona> {

	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private double alturaEnCm;
	private ColorDeOjo colorDeOjo;
	private Continente continente;

	
	
	
	
	public int getEdad() {
		return edad;
	}

	enum ColorDeOjo {

		NEGRO, VERDE, AZUL, MARRON
			

	}

	enum Continente {

		ASIA, AFRICA, AMERICA, EUROPA, OCEANIA

	}

	public Persona(String nombre, String apellido1, String apellido2, int edad, double alturaEnCm,
			ColorDeOjo colorDeOjo, Continente continente) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
		this.alturaEnCm = alturaEnCm;
		this.colorDeOjo = colorDeOjo;
		this.continente = continente;
	}

	@Override
	public int compareTo(Persona o) {

		// Si los apellidos son distintos quiere decir que ya se puede ordenar por ese
		// criterio, si son iguales
		// pues debo avanzar al siguiente criterio.
		if (apellido1.compareTo(o.apellido1) != 0)
			return apellido1.compareTo(o.apellido1);

		if (apellido2.compareTo(o.apellido2) != 0)
			return apellido2.compareTo(o.apellido2);

		if (nombre.compareTo(o.nombre) != 0)
			return nombre.compareTo(o.nombre);

		if (edad - o.edad != 0)
			return edad - o.edad; // El compareTo retorna un Integer, entonces,
		// como edad es un int este no tiene disponible el método compareTo, entonces al
		// operarlo si
		// saca el resultado del entero, si da 0 es igual y así etc...

		/*
		 * También puede hacerse: return Integer.compare(edad, o.edad);
		 */

		if (alturaEnCm - o.alturaEnCm != 0)
			return alturaEnCm - o.alturaEnCm > 0 ? 1 : alturaEnCm - o.alturaEnCm < 0 ? -1 : 0;

		return 0;

		// return apellido1.compareTo(o.apellido1); //ordena por apellido1

		// return 0; Sale igual sin ordenar

	}

	@Override
	public String toString() {
		return String.format("%s %s %s (%d) mide %.2f cm con ojos %s y es del continente %s.%n", apellido1, apellido2,
				nombre, edad, alturaEnCm, colorDeOjo.toString().toLowerCase(), continente.toString().toLowerCase());
	}

	public static void main(String[] args) {

		List<Persona> personas = new ArrayList<>();

		personas.add(new Persona("María", "García", "López", 28, 165.5, ColorDeOjo.MARRON, Continente.EUROPA));
		personas.add(new Persona("Rosa", "García", "Pérez", 28, 165.5, ColorDeOjo.MARRON, Continente.EUROPA));
		personas.add(new Persona("Carlos", "Martínez", "Sánchez", 35, 178.2, ColorDeOjo.AZUL, Continente.AMERICA));
		personas.add(new Persona("Laura", "Fernández", "Gómez", 42, 162.0, ColorDeOjo.VERDE, Continente.EUROPA));
		personas.add(new Persona("Laura", "Rodríguez", "Pérez", 31, 182.7, ColorDeOjo.NEGRO, Continente.ASIA));
		personas.add(new Persona("Ana", "López", "Martín", 25, 170.3, ColorDeOjo.MARRON, Continente.AMERICA));
		personas.add(new Persona("Pedro", "Sánchez", "Jiménez", 50, 175.8, ColorDeOjo.AZUL, Continente.AFRICA));
		personas.add(new Persona("Sofía", "Gómez", "Ruiz", 19, 168.9, ColorDeOjo.VERDE, Continente.EUROPA));
		personas.add(new Persona("Diego", "Pérez", "Hernández", 27, 180.1, ColorDeOjo.MARRON, Continente.AMERICA));
		personas.add(new Persona("Elena", "Díaz", "Moreno", 38, 167.4, ColorDeOjo.AZUL, Continente.EUROPA));
		personas.add(new Persona("Javier", "Ruiz", "Álvarez", 45, 172.6, ColorDeOjo.NEGRO, Continente.ASIA));

		
		List<Persona> personas2 = new ArrayList<>();
		
		personas2.add(new Persona("María", "García", "López", 28, 165.5, ColorDeOjo.MARRON, Continente.EUROPA));
		personas2.add(new Persona("Rosa", "García", "Pérez", 28, 165.5, ColorDeOjo.MARRON, Continente.EUROPA));
		personas2.add(new Persona("Carlos", "Martínez", "Sánchez", 35, 178.2, ColorDeOjo.AZUL, Continente.AMERICA));
		personas2.add(new Persona("Laura", "Fernández", "Gómez", 42, 162.0, ColorDeOjo.VERDE, Continente.EUROPA));
		personas2.add(new Persona("Laura", "Rodríguez", "Pérez", 31, 182.7, ColorDeOjo.NEGRO, Continente.ASIA));
		personas2.add(new Persona("Ana", "López", "Martín", 25, 170.3, ColorDeOjo.MARRON, Continente.AMERICA));
		personas2.add(new Persona("Pedro", "Sánchez", "Jiménez", 50, 175.8, ColorDeOjo.AZUL, Continente.AFRICA));
		personas2.add(new Persona("Sofía", "Gómez", "Ruiz", 19, 168.9, ColorDeOjo.VERDE, Continente.EUROPA));
		personas2.add(new Persona("Diego", "Pérez", "Hernández", 27, 180.1, ColorDeOjo.MARRON, Continente.AMERICA));
		personas2.add(new Persona("Elena", "Díaz", "Moreno", 38, 167.4, ColorDeOjo.AZUL, Continente.EUROPA));
		personas2.add(new Persona("Javier", "Ruiz", "Álvarez", 45, 172.6, ColorDeOjo.NEGRO, Continente.ASIA));

		
		
		// 1. Ordenar por orden natural establecido en la clase a través del Comparable

		System.out.println("---- ORDENANDO POR ORDEN NATURAL ----\n");

		personas.stream().sorted().forEach(System.out::println);

		// 2. Ordenar por otro tipo se usa un Comparator

		System.out.println("---- ORDEN NO NATURAL: POR EDAD. CON COMPARATOR ----\n");

		personas.stream().sorted((p1, p2) -> p1.edad - p2.edad) // Si estuviese afuera tendría que usar un getter
				.forEach(System.out::println);

		// 3. Ordenar por otro tipo se usa un Comparator

		System.out.println("---- ORDEN NO NATURAL: POR EDAD INVERSA. CON COMPARATOR ----\n");

		personas.stream().sorted((p1, p2) -> p2.edad - p1.edad).forEach(System.out::println);

		// 4. Ordenar por otro tipo se usa un Comparator

		System.out.println("---- ORDEN NO NATURAL: POR ESTATURA. CON COMPARATOR ----\n");

		Comparator<Persona> comparatorPorEstatura = (p1, p2) -> p1.alturaEnCm - p2.alturaEnCm > 0 ? 1
				: p1.alturaEnCm - p2.alturaEnCm < 0 ? -1 : 0;

		// Puedo definir Comparator por ciertos items para usarlos dentro del sorte
		// cuando uno lo necesite

		personas.stream().sorted(comparatorPorEstatura).forEach(System.out::println);

		// 5. Ordenar por orden natural inverso establecido en la clase a través del
		// Comparable

		System.out.println("---- ORDENANDO POR ORDEN NATURAL INVERSO ----\n");

		personas.
		stream().
		sorted(Comparator.reverseOrder()).forEach(System.out::println);

		//6. Orden alfábetico inverso de color
		
		System.out.println("---- ORDENANDO POR ORDEN ALFABÉTICO INVERSO DE COLOR ----\n");
		
		
		personas
		.stream()
		.sorted((p1, p2) -> p2.colorDeOjo.toString().compareTo(p1.colorDeOjo.toString()) ) //al convertirlo se pone el orden de los String, sino
		//el orden natural será tal cual como uno los haya metido p1.colorDeOjo.compareTo 
		.forEach(System.out::println);
		
		
		/*personas
		.stream()
		.sorted((p1, p2) -> p1.colorDeOjo.toString().compareTo(p2.colorDeOjo.toString()) )
		.sorted(Comparator.reverseOrder()) //Este sobreescribe la línea anterior y termina tirando del orden natural
		.forEach(System.out::println);*/
		
		//Calcular la media de los caracteres del nombre de una persona
		
		System.out.println("---- CALCULAR LA MEDIA DE LOS CARACTERES DEL NOMBRE DE UNA PERSONA ----\n");
		
		IntStream mediaCaracteresNombre = personas.stream()
				.map(p -> p.nombre)
				.mapToInt(n -> n.length());
		
		mediaCaracteresNombre.average().ifPresent(a -> System.out.printf("Media: %.2f",a));;
		
		System.out.println("\n=====================================");
		System.out.println("---- PROBANDO MÉTODOS STREAM ----");
		System.out.println("=====================================");
		
		personas.stream()
		.map(p -> p.apellido1)
		.sorted()
		.peek(System.out::println)
		.map(a -> a.length())
		.filter(i -> i < 5 )
		.forEach(System.out::println);
		
		System.out.println(personas.stream()
		.map(p -> p.edad)
		.limit(3)
		.reduce((e1, e2) -> e1 + e2));
		
		//flatmap
		
		System.out.println("\nPROBANDO FLATMAP\n");
		
		List<List<Persona>> listaPersonas = new ArrayList<List<Persona>>() ;
		
		listaPersonas.add(personas);
		listaPersonas.add(personas2);
		
				
		listaPersonas.stream()
		.flatMap(l -> l.stream())
		.map(l -> l.nombre)
		.distinct()
		.forEachOrdered(System.out::println);
		
		System.out.println("\nPROBANDO OPERACIONES TERMINALES\n");
		
		System.out.println(personas.stream()
		.map(p -> p.apellido1)
		.filter(a -> a.length() > 5) 
		.count());
						
		//findfirst
		
		System.out.println(personas.stream()
		.map(p -> p.apellido1)
		.filter(a -> a.length() > 5) 
		.findFirst());
		
		//findany
		
		System.out.println(personas.stream()
				.map(p -> p.apellido1)
				.filter(a -> a.length() > 8) 
				.findAny());
		
		
		System.out.println(personas.stream()
				.map(p -> p.apellido1)
				.anyMatch(a -> a.length() > 8));
		
		System.out.println(personas.stream()
				.map(p -> p.apellido1)
				.noneMatch(a -> a.length() > 8));
		
		System.out.println(personas.stream()
				.map(p -> p.apellido1)
				.filter(a -> a.length() > 8) 
				.toList());
		
		System.out.println(personas.stream()
				.map(p -> p.apellido1)
				.filter(a -> a.length() > 8) 
				.toArray(String[]::new)); //Se recomienda usardo con referencia de constructor, si después se quiere usar como Stering []
		//y se pone vacío se tendrá que hacer un casting
		
		//collect con Collector (el más común)
		
		
		System.out.println(personas.stream()
				.map(p -> p.apellido1)
				.filter(a -> a.length() > 8) 
				.collect(Collectors.toList()));
		
		
		//collect con Suplier - mucho más específico
		
		System.out.println(personas.stream()
				.map(p -> p.apellido1)
				.filter(a -> a.length() > 8) 
				.collect(ArrayList::new, List::add, List::addAll));
		
		
		
		//Métodos de IntStream y otros primitivos
		
		System.out.println(personas.stream()
			    .collect(Collectors.summarizingInt(Persona::getEdad)));

		
		//Es necesario implementar el getter incluso estnado dentro de la misma clase porque las lambdas acceden como si estuviesen
		// desde fuera
		
		
	}
	

}
