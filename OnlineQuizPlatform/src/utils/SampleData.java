package utils;

import static ExceptionsAndValidations.Validations.validateAccountNumber;
import static ExceptionsAndValidations.Validations.validateAccountOpeningDate;
import static ExceptionsAndValidations.Validations.validateAccountType;

import java.util.HashMap;

import com.app.banking.BankAccount;

import ExceptionsAndValidations.InvalidInputException;

public class SampleData {
	public static HashMap<String, BankAccount> populateCustomerMap() throws InvalidInputException {
		HashMap<String, BankAccount> customerMap = new HashMap<>();
		

		customerMap.put(validateAccountNumber("abc123", customerMap), new BankAccount("abc123", "Tarjan",
				validateAccountType("saving"), 20000, validateAccountOpeningDate("2023-04-19")));

		customerMap.put(validateAccountNumber("dac234", customerMap), new BankAccount("dac234", "Shashwat",
				validateAccountType("current"), 80000, validateAccountOpeningDate("2023-02-28")));

		customerMap.put(validateAccountNumber("pdd087", customerMap), new BankAccount("pdd087", "Saad",
				validateAccountType("saving"), 12000, validateAccountOpeningDate("2023-03-01")));

		customerMap.put(validateAccountNumber("abc034", customerMap), new BankAccount("abc034", "Siraj",
				validateAccountType("FD"), 150300, validateAccountOpeningDate("2023-02-10")));

		customerMap.put(validateAccountNumber("dac087", customerMap), new BankAccount("dac087", "Pradeep",
				validateAccountType("saving"), 25000, validateAccountOpeningDate("2023-01-15")));

		customerMap.put(validateAccountNumber("wer001", customerMap), new BankAccount("wer001", "Tarjan",
				validateAccountType("FD"), 543000, validateAccountOpeningDate("2023-02-21")));

		customerMap.put(validateAccountNumber("dac187", customerMap), new BankAccount("dac187", "Rohan",
				validateAccountType("current"), 55000, validateAccountOpeningDate("2023-04-01")));

		customerMap.put(validateAccountNumber("pdd174", customerMap), new BankAccount("pdd174", "Suraj",
				validateAccountType("saving"), 25000, validateAccountOpeningDate("2023-02-20")));

		// customerMap.forEach((i ,p)-> System.out.println(p));

		return customerMap;
	}

}
