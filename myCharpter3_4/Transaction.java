package myCharpter3_4;

import edu.princeton.cs.algs4.Date;

public class Transaction {
	private final String who;
	private final Date when;
	private final double amount;
	private Integer hashTemp;
	
	public Transaction(String who,Date when,double amount) {
		this.who = who;
		this.when = when;
		this.amount = amount;
	}
	
	public int hashCode() {
		if(hashTemp==null) {
			int hash = 17;
			hash = 31 * hash + who.hashCode();
			hash = 31 * hash + when.hashCode();
			hash = 31 * hash + ((Double)amount).hashCode();
			hashTemp = hash;
			return hash;	
		}else return hashTemp;
		
	}
}
