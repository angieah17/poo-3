package excepciones.checked;

public class MyClass {
	
	public static void m1() {
				
		try {
			m2();
		} catch (TestCheckedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	public static void m2() throws TestCheckedException {
		

		//throw new TestUncheckedException(); //No se tiene la obligación,
		//de gestionarla, y dará al final la excepción. En cambio, las 
		//checked exception sí obliga a gestionarlas antes de ejecutar
	
		/*//OPCIÓN DE GESTIÓN TRY CATCH
		 * try {
			throw new TestCheckedException("Checked Exception");
		} catch (TestCheckedException e) {
			System.out.println(e.getMessage());
		}*/
			//OPCIÓN DE GESTIÓN THROWS
		throw new TestCheckedException("Checked Exception");
		
		/*Se queja porque tira de una Exception que no es RunTime
		 *es decir, tendría que gestionarse.
		 * */
		
	}
	
	
}
