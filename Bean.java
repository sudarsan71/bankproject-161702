package customer;

import java.util.ArrayList;
import java.util.List;


public class Bean {
	int accno;
	String name;
	int age;
	String phoneno;
	String address;
	String aadharno;
	int bal;
	static int count = 1000;
	public List<Integer> pt=new ArrayList<Integer>();
	
	public Bean() {

	}

	
	
	public Bean(String name, int age, String phoneno, String address, String aadharno) {
		super();

		this.name = name;
		this.age = age;
		this.phoneno = phoneno;
		this.address = address;
		this.aadharno = aadharno;
	}

	public List<Integer> getPt() {
		return pt;
	}

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}

	public void setPt(int a) {
		pt.add(a);
		System.out.println(a);
	}
	
	public int getAccno() {
		return accno;
	}

	public void setAccno() {
		accno = ++count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAadharno() {
		return aadharno;
	}

	public void setAadharno(String aadharno) {
		this.aadharno = aadharno;
	}

	@Override
	public String toString() {
		return "Bean [accno=" + accno + ", name=" + name + ", age=" + age + ", phoneno=" + phoneno + ", address="
				+ address + ", aadharno=" + aadharno + ", bal=" + bal + "]";
	}

	

}
