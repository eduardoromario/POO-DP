package Aula06;

public class Person {
	protected String name;
	protected String address;
	
	/**
	* Construtor padr�o
	*/
	public Person(){
		System.out.println(
		"Inside Person:Constructor");
		name = ""; address = "";
	}
}