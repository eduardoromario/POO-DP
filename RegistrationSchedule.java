package Aula5;

public class RegistrationSchedule {
	private String name;
	private String addres;
	private String number;
	private String email;
	private static int count;
	
	public RegistrationSchedule() {
		count++;
	}
	
	public RegistrationSchedule(String name, String addres, String number, String email) {
		this.name = name;
		this.addres = addres;
		this.number = number;
		this.email = email;
		
		count++;
	}
	

	public static int getCount() {
		return count;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
