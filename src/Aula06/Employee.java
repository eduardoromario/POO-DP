package Aula06;

public class Employee extends Person {
	public Employee() {
		System.out.println(
		"Inside Employee:Constructor");
	}
	
	@Override
	public String getName() {
		System.out.println("Employee: getName");
		return name;
	}
}
