package Aula05;

import java.util.Scanner;

public class Transmitter {
	public Account[] accounts = new Account[100];
	
	public boolean Account(Account account){
		if(SearchAccount(account.getAccount()).getAccount() == null){
			for (int i = 0; i < accounts.length; i++) {
				if (accounts[i] == null) {
					accounts[i] = account;
					return true;
				}
			}
		}
		return false;
	}
	
	public Account SearchAccount(String search) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null && accounts[i].getAccount().equals(search))				
				return accounts[i];
		}
		return new Account();
	}
	
	public double getBalance(String account){
		Account acc = SearchAccount(account);
		if(acc.getAccount() != null){
			return acc.getBalance();
		}
		
		return 0;
	} 
	
	public boolean CreditAccount(Double value, String account){
		Account acc = SearchAccount(account);
		if(acc.getAccount() != null){
			double credit = acc.getBalance() + value;
			acc.setBalance(credit);
			return true;
		}
		return false;
	}
	
	public boolean DebitAccount(Double value, String account){
		Account acc = SearchAccount(account);
		if(acc.getAccount() != null){
			double debit = acc.getBalance() - value;
			if(debit >= 0){
				acc.setBalance(debit);
				return true;
			}
		}
		return false;
	}
	
	public boolean DeleteAccount(String account){
		Account acc = SearchAccount(account);
		if(acc.getAccount() != null){
			for (int i = 0; i < accounts.length; i++) {
				if (accounts[i].getAccount().equals(acc.getAccount())) {
					accounts[i] = null;
					return true;
				}
			}
		}
		return false;
	}
	
	public static Account Crud() {
		Account acc = new Account();
		
		Scanner userInfo = new Scanner(System.in);
		System.out.printf("\nInforme o banco:\n");
		acc.setBank(userInfo.nextLine());

		System.out.printf("\nInforme o número da conta:\n");
		acc.setAccount(userInfo.nextLine());
		
		acc.setBalance(0);
		
		return acc;
	}
	
	public static String CrudSearch() {
		Scanner userInfo = new Scanner(System.in);

		System.out.printf("\nInforme a Conta:\n");
		String account = userInfo.nextLine();		
		
		return account;
	}
	
	public static void main(String[] args) {
		Transmitter transmitter = new Transmitter();
		int option;

		boolean next = true;
		Scanner userEntry = new Scanner(System.in);

		do {
			System.out.println("Bem vindo ao caixa 24horas:");
			System.out.println("0. Finalizar");
			System.out.println("1. Creditar");
			System.out.println("2. Debitar");
			System.out.println("3. Consultar Saldo");
			System.out.println("4. Cadastrar Nova Conta");
			System.out.println("5. Remover Conta \r\n");
			System.out.println("Opcao:");

			option = userEntry.nextInt();

			switch (option) {
			case 1:
				String account = Transmitter.CrudSearch();
				
				Account acc = transmitter.SearchAccount(account);
				if (acc.getAccount() != null) {
					System.out.print("Seu saldo é de:");
					System.out.println(acc.getBalance());
				} else {
					System.out.println("Essa conta não existe.");
				}
				break;

			case 2:
				/*System.out.println("\t Alterando Registro");

				RegistrationSchedule editReg = Schedule.Crud();

				if (sc.AlterSchedule(editReg)) {
					System.out.println("Registro alterado com sucesso");
				} else {
					System.out.println("Email não existente");
				}*/
				break;

			case 3:
				/*System.out.println("\t Excluindo Registro");
				String searchEmail = Schedule.CrudSearch();
				if (sc.RemoveSchedule(searchEmail)) {
					System.out.println("Registro excluido com sucesso");
				} else {
					System.out.println("Registro não existe.");
				}*/
				break;

			case 4:
				/*System.out.println("\t Consultando Registro");
				String search = Schedule.CrudSearch();
				if (!sc.SearchSchedules(search))
					System.out.println("Registro não encontrado.");
*/
				break;

			case 5:
				/*System.out.println("\t Exibindo todos os registros");
				sc.ShowAllSchedules();*/
				break;

			case 0:
				next = false;
				break;

			default:
				System.out.println("Opção inválida.");
			}
		} while (next == true);

	}
	
}
