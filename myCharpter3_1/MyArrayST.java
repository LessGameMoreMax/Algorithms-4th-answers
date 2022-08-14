package myCharpter3_1;

import edu.princeton.cs.algs4.StdIn;

public class MyArrayST<Key extends Comparable<Key>,Value> {
	private Key[] keys;
	private Value[] vals;
	private int N;

	public MyArrayST() {
		keys = (Key[]) new Comparable[1];
		vals = (Value[]) new Object[1];
	}
	
	public int size()
	{ return N;}
	
	public boolean isEmpty()
	{ return this.size()==0;}
	
	public boolean contains(Key key)
	{ return get(key)!=null;}
	
	public void delete(Key key) {
		int i = rank(key);
		if(i==N) return;
		keys[i] = null;
		vals[i] = null;
		N--;
		while(i<N) 
		{keys[i]=keys[i+1];	vals[i]=vals[i+1]; i++;}
		
		if(N<=keys.length/4) {
			Key[] keyTemp = (Key[]) new Comparable[keys.length/2];
			Value[] valTemp = (Value[]) new Object[vals.length/2];
			for(int j = 0;j<N;j++)
				keyTemp[j] = keys[j];
			for(int j = 0;j<N;j++)
				valTemp[j] = vals[j];
			keys = keyTemp;
			vals = valTemp;
		}
	}
	
	public Value get(Key key) {
		if(this.isEmpty()) return null;
		int i = rank(key);
		return vals[i];
	}
	
	public void put(Key key,Value val) {
		int j = rank(key);
		if(j<N&&keys[j].compareTo(key)==0) vals[j] = val;
		keys[N] = key;
		vals[N] = val;
		N++;
		if(N==keys.length) {
			Key[] keyTemp = (Key[]) new Comparable[2*N];
			Value[] valTemp = (Value[]) new Object[2*N];
			for(int i = 0;i<keys.length;i++)
				keyTemp[i] = keys[i];
			for(int i = 0;i<vals.length;i++)
				valTemp[i] = vals[i];
			keys = keyTemp;
			vals = valTemp;
		}
	}
	
	public int rank(Key key) {
		for(int i = 0;i<N;i++)
			if(keys[i].compareTo(key)==0)
				return i;
		return N;
	}
	
	public static void main(String[] args) {
	MyArrayST<String,Double> reportCard = new MyArrayST();
	reportCard.put("A+",4.33);
	reportCard.put("A", 4.00);
	reportCard.put("A-",3.67);
	reportCard.put("B+",3.33);
	reportCard.put("B",3.00);
	reportCard.put("B-", 2.67);
	reportCard.put("C+", 2.33);
	reportCard.put("C", 2.00);
	reportCard.put("C-", 1.67);
	reportCard.put("D", 1.00);
	reportCard.put("F", 0.00);
	System.out.println("How many grades would you like to input?");
	int N = StdIn.readInt();
	System.out.println("Please input:");
	double sum = 0;
	for(int i = 0;i<N;i++)
	 sum += reportCard.get(StdIn.readString());
	System.out.printf("Your GPA is:%.2f.",sum/(N*1.0));
	}
}
