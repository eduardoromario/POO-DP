package Aula05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Schedule {
	public RegistrationSchedule[] rSchedule = new RegistrationSchedule [100];
	public static File fileSchedule = new File("C:\\Users\\eduardo.romario\\workspace\\POO-DP\\src\\Aula05\\files\\schedule.txt");
	
	/**
	 * Adiciona um novo registro na agenda;
	 * asdasdaasdasdad
	 * @param name String
	 * @param addres String
	 * @param number String
	 * @param email String 
	 * 
	 */
	public void AddSchedule(String name, String addres, String number, String email)
	{	
		try
		{
			//FileReader read = new FileReader(fileSchedule);
			FileWriter fileWriter = new FileWriter(fileSchedule, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			RegistrationSchedule register = new RegistrationSchedule(name, addres, number, email);
			printWriter.print(register.getName()+";");
			printWriter.print(register.getAddres()+";");
			printWriter.print(register.getEmail()+";");
			printWriter.print(register.getNumber()+"\r\n");
			printWriter.flush();
			printWriter.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Remove um registro da agenda a partir do email;
	 * @param email String
	 * 
	 */
	public void RemoveSchedule(String email)
	{
		try {
			String position = SearchSchedulePosition(email);
			BufferedReader fileRead = new BufferedReader(new FileReader(fileSchedule));
			
			File tempFile = new File(fileSchedule.getAbsolutePath() + ".tmp");
			
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
			String line = null;
			
			while ((line = fileRead.readLine()) != null) 
			{
				if (!line.trim().equals(position)) 
				{
				
				  pw.println(line);
				  pw.flush();
				}
			}
			
			pw.close();
			fileRead.close();
			/*
			if (!fileSchedule.delete()) 
			{
			    System.out.println("Não foi possível excluir o arquivo");
				return;
			}
			*/
			if (!tempFile.renameTo(fileSchedule))
				System.out.println("Não foi possível renomear o arquivo");
			
		}catch (IOException ex) 
		{
			ex.printStackTrace();
	    }

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
		System.out.println("Todos registros da agenda: \r\n");
		try
		{
			FileReader fileReader = new FileReader(fileSchedule);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String fileLine = "";
			while ( (fileLine = bufferedReader.readLine()) != null) {
				String schedule[] = fileLine.split(";");
				
				System.out.println("Nome:" + schedule[0]);
				System.out.println("Endereço:" + schedule[1]);
				System.out.println("E-mail:" + schedule[2]);
				System.out.println("Número:" + schedule[3] + "\r\n");
				
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Procura e exibe um registro da agenda pelo e-mail;
	 * @param search String email
	 */
	public void SearchSchedules(String search)
	{	
		try 
		{
			FileReader fileReader = new FileReader(fileSchedule);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String fileLine = "";
			if ((fileLine = bufferedReader.readLine()).contains(search)) {
				String schedule[] = fileLine.split(";");
				
				String name = schedule[0];
				String addres = schedule[1];
				String email = schedule[2];
				String number = schedule[3];
				
				RegistrationSchedule register = new RegistrationSchedule(name, addres, number, email);
				
				ShowSchedule(register);
			}
			else
			{
				ShowSchedule(null);
			}
			
			fileReader.close();
			bufferedReader.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Retorna a linha do arquivo onde o registro está;
	 * @param search String
	 * @return String
	 * 
	 */
	public String SearchSchedulePosition(String search)
	{
		try 
		{
			FileReader fileReader = new FileReader(fileSchedule);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String fileLine = "";
			if ((fileLine = bufferedReader.readLine()).contains(search)) {
				return (fileLine);
			}			

			fileReader.close();
			bufferedReader.close();
			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return null;
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
		/*String att = field.toLowerCase();
		int position = SearchSchedulePosition(name);
		if(position > -1)
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
		}*/
	}
	
	
	public void menu()
	{
	        System.out.println("\tCRUD menu:");
	        System.out.println("0. Sair");
	        System.out.println("1. Adicionar registro");
	        System.out.println("2. Alterar um registro");
	        System.out.println("3. Excluir um registro");
	        System.out.println("4. Consultar um registro");
	        System.out.println("5. Consultar todos os registros \r\n");
	        System.out.println("Opcao:");
	}
	 
	private static void read() 
	{
		try 
		{
			String search = "email@email.com";
			FileReader fileReader = new FileReader(fileSchedule);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linha = "";
			while ( (linha = bufferedReader.readLine()).contains(search)) {
				
				System.out.println(linha);
			}
			
			fileReader.close();
			bufferedReader.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		Schedule sc = new Schedule();
		int option;
		
		sc.RemoveSchedule("email@email.com");
		

		/*
		Scanner userEntry = new Scanner(System.in);
        do
        {
            menu();
            option = userEntry.nextInt();
            
            switch(option)
            {
	            case 1:
	            	System.out.println("\t Adicionando Registro");
	            	sc.AddSchedule("Eduardo", "Mostardeiro", "5599999999", "email@email.com");
	                break;
	                
	            case 2:
	            	System.out.println("\t Alterando Registro");
	                break;
	                
	            case 3:
	            	System.out.println("\t Excluindo Registro");
	                break;
	                
	            case 4:
	            	System.out.println("\t Consultando Registro");
	                break;
	                
	            case 5:
	            	System.out.println("\t Exibindo todos os registros");
	                break;
	            
	            default:
	                System.out.println("Opção inválida.");
            }
        } while(option != 0);
        */
	}
}
