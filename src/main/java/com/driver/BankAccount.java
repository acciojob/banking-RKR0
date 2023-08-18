package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
    
    	this.name = name;
    	this.balance = balance;
    	this.minBalance=minBalance;
  
   
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
    	int sum1 = 0;
    	while(digits>0) {
    		sum1+=digits%10;
    		digits /=10;
    	}
    	try {
    		if(sum==sum1) {
        		return Integer.toString(digits);
        	}
    		else
    			throw new Exception("Account Number can not be generated");
    	}
    	catch(Exception e) {
    		return e.getMessage();
    	}
    	
    }

    public void deposit(double amount) {
        //add amount to balance
    	this.balance+=amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
    	try {
    	if(this.balance-amount>=minBalance)
    		this.balance-=amount;
    	else
    		throw new Exception("Insufficient Balance");
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public double getMinBalance() {
		return minBalance;
	}

}