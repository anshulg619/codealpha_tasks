package ExceptionsAndValidations;

import java.time.LocalDate;
import java.util.HashMap;

import com.app.banking.AccountType;
import com.app.banking.BankAccount;

public class Validations {
	public static AccountType validateAccountType(String type) {
		return AccountType.valueOf(type.toUpperCase());
	}

	public static LocalDate validateAccountOpeningDate(String strDate) {
		LocalDate date = LocalDate.parse(strDate);
		return date;
	}

	// Checking Account No. is Already Exsist or Not
	public static String validateAccountNumber(String accountNumber, HashMap<String, BankAccount> customerMap)
			throws InvalidInputException {
		if (customerMap.get(accountNumber) != null)
			throw new InvalidInputException("Account Number Already Exsist....");
		return accountNumber;
	}

	public static BankAccount checkAccountPresent(String accountNumber, HashMap<String, BankAccount> customerMap)
			throws InvalidInputException {
		if (customerMap.containsKey(accountNumber))
			throw new InvalidInputException("Account with account number " + accountNumber + " already present");
		return customerMap.get(accountNumber);

	}

	public static BankAccount getAccountIfPresent(String accountNumber, HashMap<String, BankAccount> customerMap)
			throws AccountNotFoundException {
		if (customerMap.containsKey(accountNumber)) {
			return customerMap.get(accountNumber);
		}
		throw new AccountNotFoundException("Account with account number \"" + accountNumber + "\" is not present");

	}
}
