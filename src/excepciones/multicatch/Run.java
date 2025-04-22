package excepciones.multicatch;

import java.io.IOException;

public class Run {

	public static void main(String[] args) {
		
		System.out.println("Soy main de Run antes de llamar a m1");
		try {
			MyClass.m1();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Aquí si se ha seguido enviando pues se quejará y tocará gestionarlo
		System.out.println("Soy main de Run al regreso de m1");

	}

}
