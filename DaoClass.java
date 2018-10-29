package dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Exception.BankException;
import customer.Bean;

public class DaoClass implements DaoInterface{

	Map<Integer,Bean> hm=new HashMap<Integer,Bean>();
	Bean cus1=null;
	
	@Override
	public int createAccount(Bean bean) throws BankException{
		// TODO Auto-generated method stub
		int temp=bean.getAccno();
		hm.put(temp,bean);
				
		return temp;
	}

	@Override
	public int showBalance(int eaccno) throws BankException{
		Iterator<Integer> it=hm.keySet().iterator();
		while(it.hasNext())
		{
			Integer accno=it.next();
			if(accno==eaccno)
			{
				Bean b2=new Bean();
				b2=hm.get(accno);
				it.remove();
				System.out.println(hm);
				int bal=b2.getBal();
				b2=null;
				return bal;
			}
		}
		
		return 0;
	}

	@Override
	public int deposit(int eacc1,int edamnt) throws BankException{
		// TODO Auto-generated method stub
		Bean b3=null;
		int d=0;
		for (Bean b2 : hm.values()) {
			if(b2.getAccno()==eacc1)
				b3=b2;
				d=b3.getBal()+edamnt;
				b3.setBal(d);
				
				return d;
			}
		return 0;
	}
	
	
/*	@Override
	public int deposit (int eacc1,int amnt)
	{
		
		int bal=0;
		for (Bean b2 : hm.values()) {
			if(b2.getAccno()==eacc1)
				bal=b2.getBal();
				bal+=amnt;
				return bal;
			}
		return 0;
	}*/

	@Override
	public int withdraw(int eacc2, int wamnt) throws BankException{
		
		Set<Integer> key = hm.keySet();
		Iterator<Integer> it = key.iterator();
		while (it.hasNext()) {
			Integer accno = it.next();
			if (accno == eacc2) {
				Bean b2=new Bean();
				b2=hm.get(accno);
				System.out.println(b2);
				int bal=b2.getBal();
				bal-=wamnt; 
				b2.setBal(bal);
				hm.put(accno,b2);
				b2.setPt(wamnt);
				return bal;
			}
		}
		return 0;

	}

	@Override
	public boolean transfer(int sacc,int racc,int tamnt) throws BankException{
		
		Set<Integer> key = hm.keySet();
		Iterator<Integer> it = key.iterator();
		
		
			//checking bal in sacc
			while (it.hasNext()) {
				Integer saccno = it.next();
				if (sacc == saccno) {
					Bean b2 = new Bean();
					b2 = hm.get(saccno);
					int bal=b2.getBal();
					if (bal >= tamnt) {
						
						//transferring amount
						while (it.hasNext()) {
							Integer raccno = it.next();
							if (raccno == racc) {
								Bean b3 = new Bean();
								b3 = hm.get(raccno);
								int bal2=b3.getBal();
								bal2-=tamnt;
								System.out.println("sender new balance" + bal);
								bal2+=tamnt;
								System.out.println("receiver new balance is" + bal2);
								hm.put(sacc,b2);
								hm.put(racc,b3);
								return true;
								}
								
							}
						
						}
					
					}
					
				}
			
			
		return false;
		}
	
	public List<Integer> printTransactions(int ptaccno) throws BankException
	{
		Set<Integer> key=hm.keySet();
		Iterator<Integer> it=key.iterator();
		while(it.hasNext())
		{
			Integer accno=it.next();
			if(accno==ptaccno)
			{
				Bean b2=new Bean();
				b2=hm.get(accno);
				return b2.pt;
			}
		}
		
		return null;
	}
			
		

	
	//validating accno
	public boolean isAcc(int accno) 
	{
		if(hm.containsKey(accno))
		{
			return true;
		}
		else
		{
		return false;

		}
	
	

	}

	
}
