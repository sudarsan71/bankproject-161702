package service;

import java.util.List;

import Exception.BankException;

public interface BankInterface {
	
	public int createAccount(String name,int age,String ph,String addr,String aadhar) throws BankException;
	public int showBalance(int eaccno) throws BankException;
	public int deposit(int eacc1,int edamnt) throws BankException;
	public int withdraw(int eacc2,int wamnt) throws BankException;
	public boolean transfer(int sacc,int racc,int tamnt) throws BankException;
	public List<Integer> printTransactions(int ptaccno) throws BankException;

}
