package com.cg.beans;

public class Account {
	
	private int accNO;
	private double amount;
	private String accHolderName;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(int accNO, String accHolderName, double amount) {
		this.accNO = accNO;
		this.accHolderName = accHolderName;
		this.amount = amount;
		
		
		// TODO Auto-generated constructor stub
	}
	public int getAccNO() {
		return accNO;
	}
	public void setAccNO(int accNO) {
		this.accNO = accNO;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.accNO;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Account acc = (Account) obj;
		if(acc.getAccNO() == this.accNO)
			return true;
		
		return false;
	}

}
