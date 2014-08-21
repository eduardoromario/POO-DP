package Aula06;

public class Student extends Person {
	public Student() {
		System.out.println(
		"Inside Student:Constructor");
	}
	
	@Override
	public String getName() {
		System.out.println("Student: getName");
		return name;
	}
}
