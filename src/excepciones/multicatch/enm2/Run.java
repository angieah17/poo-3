package excepciones.multicatch.enm2;

public class Run {

	public static void main(String[] args) {
		
		System.out.println("Soy main de Run antes de llamar a m1");
		MyClass.m1();
		System.out.println("Soy main de Run al regreso de m1");

	}

}
