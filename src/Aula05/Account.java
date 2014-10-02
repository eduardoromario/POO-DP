package Aula05;

public class Account {
	private String bank;
	private String account;
	private double balance;
	
	public Account() {}
	
	public Account(String bank, String account, double balance) {		
		this.bank = bank;
		this.account = account;
		this.balance = balance;
	}
	
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}	
}
