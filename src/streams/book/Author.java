package streams.book;

public class Author {
	
	//Propiedades
	private String name;
	private String surname;
	private Gender gender;
	private int age;
	
	
	//Constructores
	public Author(String name, String surname, int age, Gender gender) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
	}


	//Getters
	public String getName() {
		return name;
	}



	public String getSurname() {
		return surname;
	}



	public Gender getGender() {
		return gender;
	}



	public int getAge() {
		return age;
	}

	//Métodos

	@Override
	public String toString() {
		return "Author [name=" + name + ", surname=" + surname + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
	
	
}
