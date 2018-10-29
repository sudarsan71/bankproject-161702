package service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Exception.BankException;
import customer.Bean;
import dao.DaoClass;

public class BankService implements BankInterface{
	
	DaoClass d1=new DaoClass();
	Bean bean=new Bean();
	
	public int createAccount(String name,int age,String ph,String addr,String aadhar) throws BankException
	{
		bean.setAccno();
		bean.setName(name);
		bean.setAge(age);
		bean.setPhoneno(ph);
		bean.setAddress(addr);
		bean.setAadharno(aadhar);
		return d1.createAccount(bean);
		
		
	}
	
	
	public int showBalance(int eaccno) throws BankException
	{
		return d1.showBalance(eaccno);
	}
	
	
	public int deposit(int eacc1,int edamnt) throws BankException
	{
		return d1.deposit(eacc1,edamnt);
	}
	
	
	public int withdraw(int eacc,int wamnt) throws BankException
	{
		return d1.withdraw(eacc,wamnt);
	}
	
	
	public boolean transfer(int sacc,int racc,int tamnt) throws BankException
	{
		return d1.transfer(sacc,racc,tamnt);
	}
	
	
	@Override
	public List<Integer> printTransactions(int ptaccno) throws BankException
	{
		return d1.printTransactions(ptaccno);
	}
	
	
	//validating name
	public boolean isName(String name)
	{
		Pattern pName=Pattern.compile("[A-Z][a-z]+");
		Matcher match=pName.matcher(name);
		if(match.matches())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//validating age
	public boolean isAge(int age)
	{
		if (age >= 1) {

			return true;
		}
		else
		{
			return false ;
		}
	}
	
	//validating phoneNumber
		public boolean isPh(String ph)
		{
			Pattern pPh=Pattern.compile("[6-9][0-9]{9}");
			Matcher match=pPh.matcher(ph);
			if(match.matches())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		//validating address
		public boolean isAddr(String addr)
		{
			Pattern pAddr=Pattern.compile("[0-9a-zA-Z\\.,\\s]+");
			Matcher match=pAddr.matcher(addr);
			if(match.matches())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		//validating aadhar no
		public boolean isAadhar(String aadhar)
		{
			Pattern pAadhar=Pattern.compile("[0-9]{12}");
			Matcher match=pAadhar.matcher(aadhar);
			if(match.matches())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		//validating accno
		public boolean isAccno(int accno)
		{
			if (accno >= 1000) {

				return d1.isAcc(accno);
			}
			else
			{
				return false ;
			}
		}
		
		//validating amount
		public boolean isAmount(int amnt)
		{
			if (amnt >= 1) {

				return true;
			}
			else
			{
				return false ;
			}
		}


		
}


