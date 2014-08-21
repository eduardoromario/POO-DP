package Aula06;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person ref;
		Student studentObject = new Student();
		Employee employeeObject = new Employee();
		
		ref = studentObject;
		String temp = ref.getName();		
		System.out.println(temp);
		
		ref = employeeObject;		
		temp = ref.getName();
		System.out.println(temp);

	}

}
