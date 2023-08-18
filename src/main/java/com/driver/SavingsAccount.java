package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
    	super(name,balance,0);
    	this.maxWithdrawalLimit = maxWithdrawalLimit;
    	this.rate = rate;

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
    	try {
    		if(maxWithdrawalLimit<0)
    				throw new Exception("Maximum Withdraw Limit Exceed");
    		super.withdraw(amount);
    		maxWithdrawalLimit -=1; 
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
    		return getBalance()*(1+this.rate*1.0*years);
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
    		double nn = 1.0*times*1.0*years;
    		
    		return getBalance()*Math.pow(1+this.rate/(1.0*times),nn);
    		
    }
	public double getRate() {
		return rate;
	}
	public double getMaxWithdrawalLimit() {
		return maxWithdrawalLimit;
	}

}
