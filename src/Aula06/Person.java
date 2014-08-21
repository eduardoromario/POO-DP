package Aula06;

public class Person {
	protected String name;
	protected String address;
	
	/**
	* Construtor padrão
	*/
	public Person(){
		System.out.println(
		"Inside Person:Constructor");
		name = ""; address = "";
	}
	
//	class Person {
	public String getName() {
		System.out.println("Parent: getName");
		return name;
	}
}
 