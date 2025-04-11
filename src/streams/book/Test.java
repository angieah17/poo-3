package streams.book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		
		Author miguelCervantes = new Author("Miguel", "de Cervantes", 56, Gender.MALE);
        Author gabrielGarciaMarquez = new Author("Gabriel", "García Márquez", 87, Gender.MALE);
        Author jorgeLuisBorges = new Author("Jorge", "Luis Borges", 86, Gender.MALE);
        Author marioVargasLlosa = new Author("Mario", "Vargas Llosa", 88, Gender.MALE);
        Author isabelAllende = new Author("Isabel", "Allende", 72, Gender.FEMALE);
        Author juliaNavarro = new Author("Julia", "Navarro", 60, Gender.FEMALE);
        Author carmenPosadas = new Author("Carmen", "Posadas", 67, Gender.FEMALE);
        Author lauraEsquivel = new Author("Laura", "Esquivel", 70, Gender.FEMALE);

        // Crear un ArrayList de libros
        List<Book> library = new ArrayList<>();

        // Agregar 20 libros al ArrayList con los autores
        library.add(new Book("Don Quijote de la Mancha", miguelCervantes));
        library.add(new Book("Cien años de soledad", gabrielGarciaMarquez));
        library.add(new Book("Ficciones", jorgeLuisBorges));
        library.add(new Book("La fiesta ajena", marioVargasLlosa));
        library.add(new Book("La casa de los espíritus", isabelAllende));
        
        library.add(new Book("El amante japonés", isabelAllende));
        library.add(new Book("La chica del tren", juliaNavarro));
        library.add(new Book("Las uvas de la ira", marioVargasLlosa));
        library.add(new Book("El código Da Vinci", gabrielGarciaMarquez));
        library.add(new Book("La sombra de los otros", juliaNavarro));
        
        library.add(new Book("El secreto", carmenPosadas));
        library.add(new Book("La lluvia en los zapatos", carmenPosadas));
        library.add(new Book("Esquivel", lauraEsquivel));
        library.add(new Book("El jardín de los finzi-Contini", jorgeLuisBorges));
        library.add(new Book("El alquimista", marioVargasLlosa));
        
        library.add(new Book("Como agua para chocolate", lauraEsquivel));
        library.add(new Book("Los pilares de la tierra", gabrielGarciaMarquez));
        library.add(new Book("Poesía completa", jorgeLuisBorges));
        library.add(new Book("El otoño del patriarca", gabrielGarciaMarquez));

   
		
		/*Para guardarlo habría que hacerlo de esa manera, porque
		Se crea como un Stream del tipo que está trabajando.
		
		Stream<Book> miStream = library.stream(); */ 
		
		//Imprimir la lista de autores
        
        System.out.println("Imprimir la lista de autores");
        
        library.stream()
		.map(b -> b.getAuthor())
		.forEach(a -> System.out.println(a));;
		
		/*Está entrando un Book y salen autores
		 * */
		
		//Imprimir la lista de autores únicos
		
		System.out.println("Imprimir la lista de autores únicos");
	       
		library.stream()
		.map(b -> b.getAuthor())
		.distinct()
		.forEach(System.out::println); //Esto es lo mismo que la línea del forEach anterior
		
		//Contar autores únicos
		
		System.out.println("Contar autores únicos");
	    System.out.println(library.stream()
			.map(b -> b.getAuthor())
			.distinct()
			.count());  
		
		//Contar autores únicos menores de 60 años 
	    
	    System.out.println("Contar autores únicos menores de 60 años");
	    
	    System.out.println(library.stream()
				.map(b -> b.getAuthor()) //Otra forma de expresarlo: .map(Book::getAuthor)
				.distinct()
				.filter( b -> b.getAge() < 60)
				.count()); 
	    
	    
	    //Contar autoras únicas 
	    
	    System.out.println("Contar autoras únicas");
	    
	    System.out.println(library.stream()
				.map(b -> b.getAuthor())
				.distinct()
				.filter( b -> b.getGender().equals(Gender.FEMALE))
				.count()); 
	    
	    /*Mostrar el nombre y la edad de autores cuyo nombre tenga menos de
	     * 6 caracteres.*/ 
	    
	    System.out.println("Mostrar el nombre y edad autores cuyo nombre tiene menos de 6 caracteres");
		
	    library.stream()
	    .map(b -> b.getAuthor())
	    .distinct()
	    .filter(b -> b.getName().length() < 6)
	    .forEach(a -> System.out.printf("Nombre: %s y Edad: %d.%n", a.getName(), a.getAge()));
	    
	    
	    /*Mostrar el nombre y el apellido de autoras cuyo nombre y apellido
	     * conjuntamente tengan menos de 25 caracteres.*/ 
	    
	    
	    System.out.println("Mostrar el nombre y el apellido de autoras cuyo nombre y "
	    		+ "apellido conjuntamente tengan menos de 25 caracteres.");
		
	    library.stream()
	    .map(b -> b.getAuthor())
	    .distinct()
	    .filter(a -> a.getGender().equals(Gender.FEMALE))
	    .filter(a -> a.getName().length() + a.getSurname().length() < 25)
	    .forEach(a -> System.out.printf("Nombre: %s y Apellido: %s%n", a.getName(), a.getSurname()));
	    
	    // Obtener los apellidos únicos en mayúsculas de los 15 primeros autores
	    //que sean 50 años o mayores
	    
	    System.out.println("STREAM EXAMPLES");
	    
	    System.out.println(library.stream()
	    	.map(b -> b.getAuthor())
	    	//.peek(a -> System.out.println("Todos los Autores " + a)) //lazy execution por eso necesita tener una operación terminal para mostrarse
	    	.filter(a -> a.getAge() >= 50)
	    	//.peek(a -> System.out.println("Autores mayores de 50 años o mayores: " + a)) 
	    	.distinct()
	    	.map(a -> a.getSurname())
	    	.map(sur -> sur.toUpperCase())
	    	.toList()) ;	    	
	    	
	    	
	    	
	    	
	    
	    
	}

}
