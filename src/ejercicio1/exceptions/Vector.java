package ejercicio1.exceptions;

/*Dentro de una clase puedo meter varias clases, pero solo 1 pública, que dará nombre a la clase principal. 
 * Entonces la Exception puede también incluirse aquí. 
 * 
 * class VectorOutOfBoundsException extends Exception {

	
	//No es necesario hacer un constructor, pero puede agregar un mensaje.
	//Como hicimos en el anterior mensaje.
	
	public VectorOutOfBoundsException(String message) {
		super(message);
		
	}
	
	
	
}
 * 
 * */



public class Vector {
	
	//1. Propiedades
	private int x;
	private int y;
	
	//2. Constructores
	
	public Vector(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector (int n) {
		this(n, n);
	}
	
	//3. Métodos
	
	public Vector suma (Vector v) throws VectorOutOfBoundsException {
		
		long sumaDeX = (long) x + v.x; //Aquí antes de guardarlo, debo hacer las operaciones en la máquina del long
		long sumaDeY = (long) y + v.y;
		
		if(sumaDeX > Integer.MAX_VALUE || sumaDeX < Integer.MIN_VALUE || sumaDeY > Integer.MAX_VALUE || sumaDeY < Integer.MIN_VALUE) {
			
			throw new VectorOutOfBoundsException("Te has salido de los límites de Integer");
			
		} 
		
		return new Vector(x + v.x, y + v.y);
		
	}
	
	
	
	
	
	//4. Main
	
	@Override
	public String toString() {
		return "Vector [x=" + x + ", y=" + y + "]";
	}

	public static void main(String[] args) {
		
		
		Vector v1 = new Vector(5, 10);
		Vector v2 = new Vector(Integer.MAX_VALUE);
		
		Vector v3 = new Vector(Integer.MAX_VALUE); //Max - Min sí funciona. Revisar bytes para entender mejor. 
		Vector v4 = new Vector(Integer.MIN_VALUE);
		
		try {
			System.out.println(v3.suma(v4));
		} catch (VectorOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			System.out.println(v1.suma(v2));
		} catch (VectorOutOfBoundsException e) {
			
			System.out.println(e.getMessage());
		}
		
		/*Si se pone el try/catch las 3 instrucciones inmediatamente surgiera la excepción, la siguiente instrucción no se ejecutaría:
		 * 
		 * try {
			System.out.println(v3.suma(v4));
			System.out.println(v1.suma(v2));
			System.out.println(v3.suma(v4));
		} catch (VectorOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		 * Es decir, aquí no saldría v3.suma(V4) al final. En cambio, try/catch individual sí permite que salgan las siguientes. 
		 * 
		 * */
		try {
			System.out.println(v3.suma(v4));
		} catch (VectorOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
	
}
