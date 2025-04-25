package excepciones.ultimo.capitulo;

//Con el siguiente import static permite que se puedan usar los métodos static de LanzaExcepciones sin tener que llamar a la clase cada vez 
//import static excepciones.ultimo.capitulo.LanzaExcepciones.*; El * se sustituye en cada clase, pero se recomienda ser más específico en los import
//porque así se es más clara la lectura


import static excepciones.ultimo.capitulo.LanzaExcepciones.u1e;
import static excepciones.ultimo.capitulo.LanzaExcepciones.u11e;
import static excepciones.ultimo.capitulo.LanzaExcepciones.u2e;
import static excepciones.ultimo.capitulo.LanzaExcepciones.c1e;
import static excepciones.ultimo.capitulo.LanzaExcepciones.c11e;
import static excepciones.ultimo.capitulo.LanzaExcepciones.c2e;

public class Run {

	public static void main(String[] args) {
		
		//1. Probando UcheckedException
		
		
		/*
		try {
			u11e();
		} catch (U1Exception e) {
			System.out.println(e.getMessage());
		}*/
		
		/*La herencia de las excepciones funciona igual, entonces si se lanza una U11 y que capture una U1
		 * la alcanza a capturar. Igual que perro (U11) es un animal (U1).
		 * Por lo tanto, si se hiciera alrevés se lanza U1 y se captura U11 no la captura. 
		 * */
		
		
		//Lo ideal es capturar el específico 
		
		/*
		try {
			c1e();
		} catch (C1Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		
		
		
		try {
			c1e();
			c2e();
		} catch (C1Exception | C2Exception e) { //No se pueden solapar C1Exception | C11Exception e
			System.out.println(e.getMessage());
		} 
		
		
		try {
			u1e();
			u2e();
		} catch (U1Exception | U2Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			u11e();
		} catch (U11Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			c11e();
		} catch (C11Exception e) {
			System.out.println(e.getMessage());
		} finally {
			//Se ejecuta siempre, incluso si no se produce la excepción
		}
		
		
		

	}

}
