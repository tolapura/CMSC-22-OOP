import java.io.*;

public class Account {
	private int accountNumber;
	private double balance;
	Account(int accountNumber, double balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	Account(int accountNumber){
		this(accountNumber, 0.0);
	}
	public int getAccountNumber(){
		return accountNumber;
	}
	public double getBalance(){
		return balance;
	}
	public void setBalance(double balance){
		this.balance = balance;
	}
	public void credit(double amount){
		balance += amount;
	}
	public void debit(double amount){
		if (balance >= amount){
			balance -= amount;
		} else {
			throw new IllegalArgumentException("Amount withdrawn exceeds the current balance!");
		}
	}
	public String toString(){
		return String.format("A/C no: %d, Balance = %f", accountNumber, balance);
	}
}