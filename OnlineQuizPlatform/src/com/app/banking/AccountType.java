package com.app.banking;

public enum AccountType {
SAVING(2000.0), CURRENT(5000.0),FD(10000.0);
	
	private double minimumBalance;
	
	private AccountType(double minimumBalance)
	{
		this.minimumBalance=minimumBalance;
	}

	public double getMinimumBalance()
	{
		return this.minimumBalance;
	}
    @Override
    public String toString()
    {
        return name().toLowerCase();
    }

}
