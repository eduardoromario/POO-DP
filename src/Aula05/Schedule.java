package Aula05;

import java.util.Scanner;

public class Schedule {
	public RegistrationSchedule[] rSchedule = new RegistrationSchedule[100];

	/**
	 * Adiciona um novo registro na agenda;
	 *
	 * @param RegistrationSchedule
	 *            @return boolean
	 *
	 */
	public boolean AddSchedule(RegistrationSchedule sc) {
		if (!SearchSchedules(sc.getEmail())) {
			for (int i = 0; i < rSchedule.length; i++) {
				if (rSchedule[i] == null) {
					rSchedule[i] = sc;
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Remove um registro da agenda a partir do nome;
	 * 
	 * @param name
	 *            String
	 *            @return boolean
	 *
	 */
	public boolean RemoveSchedule(String email) {
		int position = SearchSchedulePosition(email);
		if (position > -1) {
			rSchedule[position] = null;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Exibe o registro;
	 * 
	 * @param schedule
	 *            RegistrationSchedule
	 *
	 */
	public void ShowSchedule(RegistrationSchedule schedule) {
		if (schedule != null) {
			System.out
					.println("Resultado da Busca para " + schedule.getEmail());
			System.out.println("Nome:" + schedule.getName());
			System.out.println("Endereço:" + schedule.getAddres());
			System.out.println("Número:" + schedule.getNumber());
			System.out.println("E-mail:" + schedule.getEmail() + "\r\n");
		}
	}

	/**
	 * Exibe todos os registros da agenda;
	 *
	 */
	public void ShowAllSchedules() {
		System.out.println("Todos registros da agenda:");
		for (int i = 0; i < rSchedule.length; i++) {
			ShowSchedule(rSchedule[i]);
		}
	}

	/**
	 * Procura e exibe um registro da agenda;
	 * 
	 * @param search
	 *            String
	 *            @return boolean
	 */
	public boolean SearchSchedules(String search) {
		for (int i = 0; i < rSchedule.length; i++) {
			if (rSchedule[i] != null && rSchedule[i].getEmail().equals(search)) {
				ShowSchedule(rSchedule[i]);
				return true;
			}
		}
		return false;
	}

	/**
	 * Retorna o indice do registro na agenda;
	 * 
	 * @param search
	 *            String
	 * @return int
	 *
	 */
	public int SearchSchedulePosition(String search) {
		for (int i = 0; i < rSchedule.length; i++) {
			if (rSchedule[i] != null && rSchedule[i].getEmail().equals(search)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Edita um campo de um registro da agenda;
	 *
	 * @param RegistrationSchedule
	 * 
	 *            @return boolean
	 */
	public boolean AlterSchedule(RegistrationSchedule alter) {
		for (int i = 0; i < rSchedule.length; i++) {
			if (rSchedule[i] != null
					&& rSchedule[i].getEmail().equals(alter.getEmail())) {
				if (alter.getAddres() == null || alter.getAddres().isEmpty())
					alter.setAddres(rSchedule[i].getAddres());

				if (alter.getName() == null || alter.getName().isEmpty())
					alter.setName(rSchedule[i].getName());

				if (alter.getNumber() == null || alter.getNumber().isEmpty())
					alter.setNumber(rSchedule[i].getNumber());

				rSchedule[i] = alter;

				return true;
			}
		}
		return false;
	}

	public static RegistrationSchedule Crud() {
		RegistrationSchedule sc = new RegistrationSchedule();
		Scanner userInfo = new Scanner(System.in);
		System.out.printf("\nInforme o email:\n");
		sc.setEmail(userInfo.nextLine());

		System.out.printf("\nInforme o telefone:\n");
		sc.setNumber(userInfo.nextLine());

		System.out.printf("\nInforme o nome:\n");
		sc.setName(userInfo.nextLine());

		System.out.printf("\nInforme o endereço:\n");
		sc.setAddres(userInfo.nextLine());

		return sc;
	}

	public static String CrudSearch() {
		Scanner userInfo = new Scanner(System.in);

		System.out.printf("\nInforme o email:\n");
		String email = userInfo.nextLine();

		return email;
	}

	public static void main(String[] args) {
		Schedule sc = new Schedule();
		int option;

		boolean next = true;
		Scanner userEntry = new Scanner(System.in);

		do {
			System.out.println("\tCRUD menu:");
			System.out.println("0. Sair");
			System.out.println("1. Adicionar registro");
			System.out.println("2. Alterar um registro");
			System.out.println("3. Excluir um registro");
			System.out.println("4. Consultar um registro");
			System.out.println("5. Consultar todos os registros \r\n");
			System.out.println("Opcao:");

			option = userEntry.nextInt();

			switch (option) {
			case 1:
				System.out.println("\t Adicionando Registro");
				RegistrationSchedule newReg = Schedule.Crud();
				if (sc.AddSchedule(newReg)) {
					System.out.println("Registro criado com sucesso.");
				} else {
					System.out.println("Email já cadastrado.");
				}
				break;

			case 2:
				System.out.println("\t Alterando Registro");

				RegistrationSchedule editReg = Schedule.Crud();

				if (sc.AlterSchedule(editReg)) {
					System.out.println("Registro alterado com sucesso");
				} else {
					System.out.println("Email não existente");
				}
				break;

			case 3:
				System.out.println("\t Excluindo Registro");
				String searchEmail = Schedule.CrudSearch();
				if (sc.RemoveSchedule(searchEmail)) {
					System.out.println("Registro excluido com sucesso");
				} else {
					System.out.println("Registro não existe.");
				}
				break;

			case 4:
				System.out.println("\t Consultando Registro");
				String search = Schedule.CrudSearch();
				if (!sc.SearchSchedules(search))
					System.out.println("Registro não encontrado.");

				break;

			case 5:
				System.out.println("\t Exibindo todos os registros");
				sc.ShowAllSchedules();
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
