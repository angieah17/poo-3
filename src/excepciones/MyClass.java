package excepciones;

import java.util.ArrayList;

public class MyClass {
	
	
	public static void m1() {
			
		
		try {
			System.out.println("Soy m1 de MyClass antes de llamar a m2");
			m2();
		} catch (NullPointerException e) {
			System.err.println("Capturada excepción NullPointer");
		} catch (ArithmeticException e) {
			System.err.println("Capturada excepción Arithmetic");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Capturada excepción ArrayIndexOutOfBounds");
		}
		
		//capturando la excepción
		/*try {
			m2();
		} catch (ArithmeticException e) {
			System.out.println("te pillé");
		}*/
		
		System.out.println("Soy m1 de MyClass al regreso de m2");
	}
	
	
	public static void m2() {
		
			
		
		int [] array = {1, 2, 3};
				
		for (int i = 0; i < array.length; i++) {
			array[3] = 1;
		}
		
		String s = null;
		
		if(false) System.out.println(7 / 0);
		else 
			s.toString();
			
		
		
		System.out.println("Soy m2 de MyClass");
	}
	
	
}
