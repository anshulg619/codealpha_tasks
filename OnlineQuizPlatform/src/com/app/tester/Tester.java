package com.app.tester;

import static ExceptionsAndValidations.Validations.getAccountIfPresent;
import static ExceptionsAndValidations.Validations.validateAccountOpeningDate;
import static ExceptionsAndValidations.Validations.validateAccountType;

import java.util.HashMap;
import java.util.Scanner;

import com.app.banking.BankAccount;

import utils.SampleData;

public class Tester {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			HashMap<String, BankAccount> customerMap = SampleData.populateCustomerMap();
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println(
							"Application Menu:\n1. Create a new Account\n2. Display all Account\n3. Display particular account\n4. deposit\n"
									+ "5. withdraw\n6. transfer\n0. Exit");
					System.out.print("Enter choice:> ");

					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter account number, name, account type(saving/current), "
								+ "initial balance, account opening date");
						String accountNumber = sc.next();
						customerMap.put(accountNumber,
								new BankAccount(accountNumber, sc.next(), validateAccountType(sc.next()),
										sc.nextDouble(), validateAccountOpeningDate(sc.next())));
						System.out.println("Account opened successfully...");
						System.out.println();
						break;

					case 2:
						customerMap.forEach((accNo, acc) -> System.out.println(acc));
						System.out.println();
						break;

					case 3:
						System.out.println("Enter account number");
						System.out.println(getAccountIfPresent(sc.next(), customerMap));
						System.out.println();
						break;

					case 4:
						System.out.println("Enter amount, Account number");
						BankAccount.deposit(sc.nextDouble(), sc.next(),customerMap);
						System.out.println();
						break;

					case 5:
						System.out.println("Enter Account number");
						BankAccount account = getAccountIfPresent(sc.next(), customerMap);
						System.out.println("Enter amount: ");
						account.withdraw(sc.nextDouble());
						System.out.println();

						break;

					case 6:
						System.out.println("Enter sender's account number");
						BankAccount senderAccount = getAccountIfPresent(sc.next(), customerMap);
						System.out.println("Enter amount, recipient's account number");
						senderAccount.transfer(sc.nextDouble(), sc.next(), customerMap);
						System.out.println();
						break;

					case 0:
						exit = true;
						break;

					default:
						System.out.println("Invalid Input");
						break;

					}
				} catch (Exception e) {
					System.out.println(e);
					sc.next();

				}

			}

		} catch (Exception e) {
			System.out.println(e);

		}

	}

}
