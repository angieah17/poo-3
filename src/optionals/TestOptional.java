package optionals;

import java.util.Optional;
import java.util.Random;

public class TestOptional {

	private static Optional<Double> media (Integer [] numeros){
		
		/*Tener cuidado en el orden de poner estas comprobaciones, 
		 * porque si es null y le va a aplicar .length puede 
		 * generar error. En cambio, si primero verifico que ya es null
		 * se saldría y no seguiría mirando.
		 * */
		
		
		if(numeros == null || numeros.length == 0 ) {
			return Optional.empty();
		}
				
		Integer suma = 0;
		Integer contador = 0;
				
	
		for (Integer num : numeros) {
			if(num != null) {
				contador++;
				suma += num;	
			}	
			
		}
		
		//Se pone el 1. para que no explote pues se ha dicho que es Double
		
				
		return contador == 0 ? Optional.empty() : Optional.of( 1. * suma / contador);
		
		
	}
	
	public static void main(String[] args) {

		// Los Optional son inmutables.

		// 1. Métodos estáticos para construir el Optional

		Optional<Integer> opt1 = Optional.of(4);

		/*
		 * Se está construyendo un Optional que está devolviendo un Integer.
		 */

		Optional<Integer> opt2 = Optional.empty();

		Optional<Integer> opt3 = Optional.ofNullable(null);

		/*
		 * Entre op2 y op3 la diferencia es que en el opt3 puede que la variable valga o
		 * no null por eso se usa este constructor, en el opt 2 si o si estará vacío
		 */

		// Optional<Integer> opt4 = Optional.of(null); //El .of no está
		// preparado para pasar un null, da un error

		System.out.println(opt1);
		System.out.println(opt2);
		System.out.println(opt3);

		// 2. Métodos de isntancia del Optional

		System.out.println(opt1.get());
		System.out.println(opt2.isEmpty());
		System.out.println(opt3.isPresent() ? "presente" : "vacío");
		opt1.ifPresent(System.out::println);
		System.out.println(opt2.orElse(0));
		// System.out.println(opt2.get()); //Al estar vacío ocurriría lo mismo que
		// aplicar
		// Optional.of porque no está preparado en caso de ser null, mejor usar el
		// .orElse
		System.out.println(opt2.orElse(1));
		System.out.println(opt2.orElseGet(() -> {
			Random r = new Random();
			return r.nextInt();
		}));

		System.out.println("PROBANDO EJERCICIO");
		
		/*{1, 3, 5}
		 * {null, null}
		 * {1, null, 3, 5}
		 * {}
		 * null
		 * */
		
		System.out.println(media(new Integer [] {1, 3, 5}));
		System.out.println(media(new Integer [] {null, null}));
		System.out.println(media(new Integer [] {}));
		System.out.println(media(null));
		System.out.println(media(new Integer [] {1, null, 3, 5}));
		
		//También se puede hacer en 1 sola línea
		
		System.out.println("PROBANDO CON JAVI");
		
		media(new Integer [] {1, 3, 5}).ifPresent(System.out::println);
		media(new Integer [] {1, null, 3, 5}).ifPresent(System.out::println);
		
		
		
	}

}
