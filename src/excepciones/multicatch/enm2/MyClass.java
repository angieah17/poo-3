package excepciones.multicatch.enm2;

import java.util.ArrayList;

public class MyClass {
	
	
	public static void m1() {
		
		System.out.println("Soy m1 de MyClass antes de llamar a m2");
		m2();		
			
		System.out.println("Soy m1 de MyClass al regreso de m2");
	}
	
	
	public static void m2() {
		
		try {
			int [] array = {1, 2, 3};
			
			for (int i = 0; i < array.length; i++) {
				array[3] = 1;
			}
			
			String s = null;
			
			if(false) System.out.println(7 / 0);
			else 
				s.toString();
		} catch (NullPointerException | ArithmeticException | ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		} 	
		
		//Si no se captura deja sin funcionar esta parte del código hasta que se capture, entonces
		//en los anteriores ejemplos, la bola arruinaba estas líneas de código, inmediatamente
		//se captura entonces todo continúa donde iba 
		
		System.out.println("Soy m2 de MyClass");
	}
	
	
}
