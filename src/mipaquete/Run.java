package mipaquete;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Run {

	private static Random random = new Random();
	
	public static void main(String[] args) {
		
		List<Ciudad> ciudades = new ArrayList<>();
		
		Ciudad ciudad1 = new Ciudad("Ciudad 0");
		
		for (int i = 0; i < 10_000; i++) {
			ciudad1.addCounter(new Counter(50_000));
		}
		
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
			
			for (int i = 0; i < 100; i++) {
				
				for (Counter counter : ciudad.getContadores()) {
					counter.increment(random.nextInt(705, 1_001));
				}
				
				
			}
			
		}
		
		
		/*Stream especial porque luego hay que aplicarle otro 
		 * Stream a lo de dentro. flatMap
		 * */
		
		
	}

}
