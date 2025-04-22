package excepciones.multicatch;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MyClass {
	
	
	public static void m1() throws IOException {
			
		
		
		try {
			System.out.println("Soy m1 de MyClass antes de llamar a m2");
			m2(); // Aquí también se queja y se debe gestionar en el siguiente
		} catch (NullPointerException | ArithmeticException | ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		} 
			
		System.out.println("Soy m1 de MyClass al regreso de m2");
	}
	
	
	public static void m2()throws IOException {
		
		FileReader reader = null;
		
		reader = new FileReader("fichero.txt");
		
		
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
