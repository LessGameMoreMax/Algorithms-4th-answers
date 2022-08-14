package myCharpter2_1;

import myCharpter1_2.TestCharpter1_2.SmartDate;

public class Transactions implements Comparable<Transactions>
{
	private String who;
	private SmartDate when;
	private double amount;
	Transactions() {
		
	}
	Transactions(String transaction) {
		String[] str = transaction.split("\\s+");
		this.who = str[0];
		String[] fields = str[1].split("/");
		this.when = new SmartDate(Integer.parseInt(fields[0]),Integer.parseInt(fields[1]),Integer.parseInt(fields[2]));
		this.amount = Double.parseDouble(str[2]);
	}
	public String toString() {
		return who+":"+when+" "+amount;
	}
	public boolean equals(Object x) {
		if(this == x) return true;
		if(x == null) return false;
		if(this.getClass()!=x.getClass()) return false;
		Transactions that = (Transactions)x;
		if(!this.who.equals(that.who)) return false;
		if(this.amount!=that.amount) return false;
		if(!this.when.equals(that.when)) return false;
		return true;
	}
	
	public int compareTo(Transactions that) {
		if(this.amount>that.amount) return +1;
		else if(this.amount<that.amount) return -1;
		else return 0;
	}
}
