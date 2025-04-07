package mipaquete;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Random;

public class Run {

	private static Random random = new Random();
	
	public static void main(String[] args) {
		
		List<Ciudad> ciudades = new ArrayList<>();
		
		/*Ciudad ciudad1 = new Ciudad("Ciudad 0");
		
		for (int i = 0; i < 10_000; i++) {
			ciudad1.addCounter(new Counter(50_000));
		}*/
		
		String [] nombreCiudades = {
				"Ciudad 1", 
				"Ciudad 2", 
				"Ciudad 3", 
				"Ciudad 4", 
				"Ciudad 5", 
				"Ciudad 6", 
				"Ciudad 7", 
				"Ciudad 8", 
				"Ciudad 9", 
				"Ciudad 10"
		};
		
		for (String nombreCiudad : nombreCiudades) {
			
			Ciudad ciudad = new Ciudad(nombreCiudad);
						
			for (int i = 0; i < random.nextInt(10_000, 12_001); i++) {
				ciudad.addCounter(new Counter(50_000));
			}
			ciudades.add(ciudad);
		}
		
		
		for (Ciudad ciudad : ciudades) {
			
			for (int i = 0; i < 25; i++) {
				
				for (Counter counter : ciudad.getContadores()) {
					counter.increment(random.nextInt(705, 1_001));
				}
				
				
			}
			
		}
		
		//Para verificar si funcionaba:
		for (int i = 0; i < 10; i++) {
			System.out.println(ciudades.get(3).getContadores().get(i));    
			
		}		
		
		
		//Máximo consumo total de contadores
		
		
		
		//Mínimo para UNA ciudad
		
		Ciudad miCiudad = ciudades.get(0);
		
		Optional<Integer> minimoParaCiudad = 
		miCiudad.getContadores().stream()
		.map(c -> c.getValue())
		.sorted()
		.findFirst();
		
		System.out.printf("Mínimo para la %s: ", miCiudad.getNombre());
		
		minimoParaCiudad.ifPresent(System.out::println);
		
		//Máximo de UNA ciudad
		
		Optional<Integer> maximoParaCiudad = 
				miCiudad.getContadores().stream()
		.map(c -> c.getValue())
		.sorted(Comparator.reverseOrder())
	//	.sorted((v1, v2) -> v1 + v2) Esta es la forma manual de invertir el 
		//orden natural con el que ordena el sorted
		.findFirst();
		
		System.out.printf("Máximo para la %s: ", miCiudad.getNombre());
		
		maximoParaCiudad.ifPresent(System.out::println);
		
		
		
		//Media de UNA ciudad
		
		OptionalDouble mediaParaCiudad = miCiudad.getContadores().stream()
				.mapToInt(c -> c.getValue())
				.average();
			
		System.out.printf("Media con OptionalDouble para la %s: ", miCiudad.getNombre());
		
		mediaParaCiudad.ifPresent(s -> System.out.printf("%.2f%n", s));
		
		
		//mapToInt (es como una forma de trabajar el Stream como si fuese un 
		//dato primitivo)
		
		
		//Maximo con OptionalInt
		
				
		OptionalInt maximoConOptionalInt = miCiudad.getContadores().stream()
		.mapToInt(c -> c.getValue())
		.max();
		
		System.out.printf("Máximo con OptionalInt para la %s: ", miCiudad.getNombre());
		
		maximoConOptionalInt.ifPresent(System.out::println);
		
		
		//Mínimo con OptionalInt
		
		OptionalInt minimoConOptionalInt = miCiudad.getContadores().stream()
				.mapToInt(c -> c.getValue())
				.min();
				
				System.out.printf("Mínimo con OptionalInt para la %s: ", miCiudad.getNombre());
				
				minimoConOptionalInt.ifPresent(System.out::println);
				
		//Suma de los valores de la ciudad
		
		int suma = miCiudad.getContadores().stream()
				.mapToInt(c -> c.getValue())
				.sum(); //La suma devuelve un int, no un OptionalInt
		
		System.out.printf("Suma para la %s: ", miCiudad.getNombre());
		
		System.out.println(suma);
				
				
		/*Stream especial porque luego hay que aplicarle otro 
		 * Stream a lo de dentro. flatMap
		 * */
		
		
	}

}
