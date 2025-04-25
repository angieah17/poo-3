package excepciones.ultimo.capitulo;

public class LanzaExcepciones {
	
	public static void u1e() {
		System.out.println("Soy el método que lanza la excepción: U1Excepcion");
		throw new U1Exception("U1Excepcion");
	}
	
	public static void u11e() {
		System.out.println("Soy el método que lanza la excepción: U11Excepcion");
		throw new U11Exception("Mi U11Excepcion");
	}
	
	public static void u2e() {
		System.out.println("Soy el método que lanza la excepción: U2Excepcion");
		throw new U2Exception("Mi U2Excepcion");
	}
	
	public static void c1e() throws C1Exception {
		System.out.println("Soy el método que lanza la excepción: C1Excepcion");
		throw new C1Exception("Mi C1Excepcion");
	}
	
	public static void c11e() throws C11Exception {
		System.out.println("Soy el método que lanza la excepción: C11Excepcion");
		throw new C11Exception("Mi C11Excepcion");
	}
	
	public static void c2e() throws C2Exception {
		System.out.println("Soy el método que lanza la excepción: C2Excepcion");
		throw new C2Exception("Mi C2Excepcion");
	}
	
}
