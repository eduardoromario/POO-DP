package Aula5;


public class Schedule {
	public RegistrationSchedule[] rSchedule = new RegistrationSchedule [52]; 
	
	/**
	 * Adiciona um novo registro na agenda;
	 * 
	 * @param name String
	 * @param addres String
	 * @param number String
	 * @param email String 
	 * 
	 */
	public void AddSchedule(String name, String addres, String number, String email)
	{
		for (int i = 0; i < rSchedule.length; i++) 
		{
			if(rSchedule[i] == null)  
			{
				rSchedule[i] = new RegistrationSchedule(name, addres, number, email);		
				break;
			}
		}
	}
	
	/**
	 * Remove um registro da agenda a partir do nome;
	 * @param name String
	 * 
	 */
	public void RemoveSchedule(String name)
	{
		int position = SearchSchedulePosition(name);
		
		if(position > 0)
			rSchedule[position] = null;
	}
	
	/**
	 * Exibe o registro;
	 * @param schedule RegistrationSchedule
	 * 
	 */
	public void ShowSchedule(RegistrationSchedule schedule)
	{
		
		if(schedule != null)
		{
			System.out.println("Resultado da Busca para "+ schedule.getName());
			System.out.println("Nome:" + schedule.getName());
			System.out.println("Endereço:" + schedule.getAddres());
			System.out.println("Número:" + schedule.getNumber());
			System.out.println("E-mail:" + schedule.getEmail() + "\r\n");
		}
		else
		{
			System.out.println("Registro não encontrado.");
		}
	}
	
	/**
	 * Exibe todos os registros da agenda;
	 * 
	 */
	public void ShowAllSchedules()
	{
		System.out.println("Todos registros da agenda:");
		for (int i = 0; i < rSchedule.length; i++) 
		{
			if(rSchedule[i] != null)
			{
				System.out.println("Nome:" + rSchedule[i].getName());
				System.out.println("Endereço:" + rSchedule[i].getAddres());
				System.out.println("Número:" + rSchedule[i].getNumber());
				System.out.println("E-mail:" + rSchedule[i].getEmail() + "\r\n");
			}
		}
	}
	
	/**
	 * Procura e exibe um registro da agenda;
	 * @param search String
	 */
	public void SearchSchedules(String search)
	{
		for (int i = 0; i < rSchedule.length; i++) 
		{
			if(rSchedule[i] != null && rSchedule[i].getName().equals(search))
			{
				ShowSchedule(rSchedule[i]);
				return;
			}
		}
		ShowSchedule(null);
	}
	
	
	/**
	 * Retorna o indice do registro na agenda;
	 * @param search String
	 * @return int
	 * 
	 */
	public int SearchSchedulePosition(String search)
	{
		for (int i = 0; i < rSchedule.length; i++) 
		{
			if(rSchedule[i] != null && rSchedule[i].getName().equals(search))
			{
				return i;
			}
		}		
		return 0;
	}
	
	/**
	 * Edita um campo de um registro da agenda;
	 * 
	 * @param name String
	 * @param field String
	 * @param newValue String
	 */
	public void AlterSchedule(String name, String field, String newValue)
	{
		String att = field.toLowerCase();
		int position = SearchSchedulePosition(name);
		if(position > 0)
		{
			switch (att) 
			{
				case "name":
					System.out.println("Nome alterado de:" + rSchedule[position].getName()+". Para:" + newValue);
					rSchedule[position].setName(newValue);
					break;
				case "addres":
					System.out.println("Endereço alterado de:" + rSchedule[position].getAddres()+". Para:" + newValue);
					rSchedule[position].setAddres(newValue);
					break;
				case "number":
					System.out.println("Número alterado de:" + rSchedule[position].getNumber()+". Para:" + newValue);
					rSchedule[position].setNumber(newValue);
					break;
				case "email":
					System.out.println("E-mail alterado de:" + rSchedule[position].getEmail()+" para: " + newValue);
					rSchedule[position].setEmail(newValue);
					break;
				default:
					System.out.println("Não existe o campo: " + att + "\r\n");
					break;
			}
		}
		else
		{
			System.out.println("Não há registro com esse nome.");
		}
	}
	
	public static void main(String[] args)
	{
		Schedule a = new Schedule();
		a.AddSchedule("Eduardo", "Mostardeiro", "5599999999", "email@email.com");
		a.AddSchedule("Joao", "Mostardeiro", "5599999999", "email@email.com");
		a.AddSchedule("Maria", "Mostardeiro", "5599999999", "email@email.com");
		
		a.SearchSchedules("Joao");
		
		a.AlterSchedule("Joao", "Namsadae", "Pedro");
		
		a.SearchSchedules("Pedro");
	}
}
