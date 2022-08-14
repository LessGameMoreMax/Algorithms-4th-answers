package myCharpter2_1;

import edu.princeton.cs.algs4.StdIn;
import myCharpter1_3.MyQueue;

public class SortTransaction {
	public static Transactions[] readTransactions() {
		MyQueue<Transactions> trans = new MyQueue<Transactions>();
		int flag = 0;
		String temp = null;
		while(!StdIn.isEmpty()) {
			String read = StdIn.readString();
			flag++;
			if(flag % 3 == 0) {
				temp = temp.concat(" "+read);
				Transactions transactions = new Transactions(temp);
				trans.enqueue(transactions);
				flag = 0;
			}
			else if(flag % 3 == 1){
				temp = read;
			}
			else {
				temp = temp.concat(" "+read); //×¢Òâ´Ë´¦
			}
		}
		Transactions[] result = new Transactions[trans.size()];
		for(int i = 0;i<result.length;i++) {
			result[i] = trans.dequeue();
		}
		return result;
	}
	
	public static void main(String[] args) {
		Transactions[] input = readTransactions();
		Shell.sort(input);
		for(Transactions s:input)
			System.out.println(s);
	}
}
