package com.app.banking;

import static ExceptionsAndValidations.Validations.checkAccountPresent;

import java.time.LocalDate;
import java.util.HashMap;

import ExceptionsAndValidations.AccountNotFoundException;
import ExceptionsAndValidations.InvalidInputException;
import ExceptionsAndValidations.MinimumBalanceException;

public class BankAccount {
	private String accountNumber;
	private String name;
	private AccountType type;
	private double balance;
	private LocalDate accountOpeningdate;

	public BankAccount(String accountNumber, String name, AccountType type, double balance,
			LocalDate accountOpeningdate) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.type = type;
		this.balance = balance;
		this.accountOpeningdate = accountOpeningdate;
	}

	public BankAccount(String accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}

	public double withdraw(double amount) throws MinimumBalanceException {
		if ((this.balance - amount) < this.type.getMinimumBalance())
			throw new MinimumBalanceException("Transaction Failed !!!\nMinimum Balnce required for " + this.type
					+ " is " + this.type.getMinimumBalance());
		this.balance -= amount;
		System.out.println(amount + " debited succesfully from account number " + this.accountNumber);
		return amount;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getName() {
		return name;
	}

	public AccountType getType() {
		return type;
	}

	public double getBalance() {
		return balance;
	}

	public LocalDate getAccountOpeningdate() {
		return accountOpeningdate;
	}

//	public static double deposit(double amount, BankAccount account) {
//		account.balance += amount;
//		System.out.println(amount + " credited succesfully from account number " + account.accountNumber);
//		return amount;
//	}

	public static double deposit(double amount, String anotherAccountNumber, HashMap<String, BankAccount> customerMap)
			throws InvalidInputException {
		BankAccount recipientAccount = checkAccountPresent(anotherAccountNumber, customerMap);
		recipientAccount.balance += amount;
		System.out.println(amount + " credited succesfully from account number " + recipientAccount.accountNumber);
		return amount;
	}

//	public double transfer(double amount, BankAccount anotherAccount) throws MinimumBalanceException {
//		this.withdraw(amount);
//		BankAccount.deposit(amount, anotherAccount);
//		return amount;
//	}

	public double transfer(double amount, String anotherAccountNumber, HashMap<String, BankAccount> cutomerList)
			throws MinimumBalanceException, AccountNotFoundException, InvalidInputException {
		this.withdraw(amount);
		BankAccount.deposit(amount, anotherAccountNumber, cutomerList);
		return amount;
	}

	@Override
	public String toString() {
		return "BankAccount [AccNO:" + accountNumber + "\t Name:" + name + "\t type:" + type + "\t\t balance:" + balance
				+ "\t accountOpeningdate:" + accountOpeningdate + "]";
	}

}
