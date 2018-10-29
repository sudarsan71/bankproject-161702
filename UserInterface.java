package ui;

import java.util.Scanner;

import Exception.BankException;
import customer.Bean;
import service.BankService;

public class UserInterface {

	public static void main(String[] args) {
		
		//declaring variables for main 
		Scanner sc = new Scanner(System.in);
		Bean cus = new Bean();
		BankService s2=new BankService();
		boolean flag;
		int rv,rv1,rv2,rv3;
		int ch;
		
		System.out.println("welcome to the wallet");
		
		do
		{
		System.out.println("press 1 to create account" + "\npress 2 to show balance" + "\npress 3 to deposit"
				+ "\npress 4 to withdraw" + "\npress 5 to transfer" + "\npress 6 to print transactions");
		ch=sc.nextInt();
		switch (ch) {
		case 1:
			//create account
			try
			{
			BankService s = new BankService();
			//getting name
			System.out.println("enter your name");
			String name;
			int age;
			String ph;
			String addr;
			String aadhar;
			do {
				name = sc.next();
			} while (s.isName(name) == false);
			
			
			//getting age
			System.out.println("enter your age");
			
			do {
				age = sc.nextInt();
			} while (s.isAge(age) == false);
			
			
			//getting phoneNo
			System.out.println("enter your phone number");
			
			do {
				ph = sc.next();
			} while (s.isPh(ph) == false);
			
			
			//getting address
			System.out.println("enter your address");
			
			do {
				addr = sc.next();
			} while (s.isAddr(addr) == false);
			
			
			//getting aadharno
			System.out.println("enter your aadhar number");
			
			do {
				aadhar = sc.next();
			} while (s.isAadhar(aadhar) == false);
			
			
			//invoking create account and printing output
			rv = s.createAccount(name,age,ph,addr,aadhar);
			
			if (rv>=1) {
				System.out.println("your account number is" + rv);
			} else {
				System.out.println("error!!! try again");
			}
		}catch(BankException be)
		{
			System.out.println("the exception is" + be.getMessage());
		}
			
			break;
			
			
			
		case 2:
			//show balance
			try
			{System.out.println("enter account number");
			int eaccno;
			do{
				eaccno = sc.nextInt();
				flag=s2.isAccno(eaccno);
				if(flag== false)
				{
					System.out.println("account number is invalid");
				}
			}while(flag == false);
			
			//invoking show balance and printing output
			rv1 = s2.showBalance(eaccno);
			if (rv1>=1) {
				System.out.println("your balance is" + rv1);
			} else {
				System.out.println("error!!! try again");
			}
			}catch(BankException be)
			{
				System.out.println("the exception is" + be.getMessage());
			}
			break;
			
			
			
		case 3:
			//deposit
			try
			{
				System.out.println("enter the account no and amount to deposit");
			int eacc1;
			int edamnt;
			do{
				eacc1 = sc.nextInt();
				flag = s2.isAccno(eacc1);
				if(flag == false)
				{
					System.out.println("account number is invalid");
				}
			}while(flag == false);
			
			do{
				edamnt = sc.nextInt();
				flag = s2.isAmount(edamnt);
				if(flag == false)
				{
					System.out.println("enter valid amount");
				}
			}while(flag == false);
			
			//invoking deposit and printing output
			rv2 = s2.deposit(eacc1,edamnt);
			if (rv2>=1) {
				System.out.println("your new balance is" + rv2);
			} else {
				System.out.println("error!!! try again");
			}
			}catch(BankException be)
			{
				System.out.println("the exception is" + be.getMessage());
			}
			break;
			
			
			
		case 4:
			//withdraw
			try
			{
				System.out.println("enter the account no and amount to withdraw");
			int eacc2;
			do{
				eacc2 = sc.nextInt();
				flag = s2.isAccno(eacc2);
				if(flag == false)
				{
					System.out.println("account number is invalid");
				}
			}while(flag == false);
			int ewamnt;
			do{
				ewamnt = sc.nextInt();
				flag = s2.isAmount(ewamnt);
				if(flag == false)
				{
					System.out.println("enter valid amount");
				}
			}while(flag == false);
			
			//invoking withdraw and printing output
			rv3 = s2.withdraw(eacc2,ewamnt);
			if (rv3>=1) {
				System.out.println("your new balance is" + rv3);
			} else {
				System.out.println("error!!! try again");
			}
			}catch(BankException be)
			{
				System.out.println("the exception is" + be.getMessage());
			}
			break;
			
			
			
		case 5:
			//fund transfer
			try
			{
			System.out.println("enter the sender and receiver account number and amount to transfer");
			int sacc;
			do{
				sacc = sc.nextInt();
				flag=s2.isAccno(sacc);
				if(flag== false)
				{
					System.out.println("account number is invalid");
				}
			}while(flag == false);
			int racc;
			do{
				racc = sc.nextInt();
				flag=s2.isAccno(racc);
				if(flag == false)
				{
					System.out.println("account number is invalid");
				}
			}while(flag == false);
			int tamnt;
			do{
				tamnt = sc.nextInt();
				flag = s2.isAmount(tamnt);
				if(flag == false)
				{
					System.out.println("enter valid amount");
				}
			}while(flag == false);
			System.out.println(s2.transfer(sacc,racc,tamnt));
			}catch(BankException be)
			{
				System.out.println("the exception is" + be.getMessage());
			}
			
			break;
			
			
			
		case 6:
			//print transaction
			try
			{
				System.out.println("print transactions");
			System.out.println("enter the account number");
			int ptaccno;
			do{
				ptaccno = sc.nextInt();
				flag=s2.isAccno(ptaccno);
				if(flag== false)
				{
					System.out.println("enter valid account number");
				}
			}while(flag == false);
			
			System.out.println(s2.printTransactions(ptaccno));
			}
			catch(BankException be)
			{
				System.out.println("the exception is" + be.getMessage());
			}
			
			
			break;
			
			
			
		}
		}while(ch<=6);
		

	}
	

}
