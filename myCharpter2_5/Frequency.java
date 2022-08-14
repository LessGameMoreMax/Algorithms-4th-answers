package myCharpter2_5;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdIn;

public class Frequency {
	private static Integer[] pqChance; 
	private static String[] pqString; 
	
	public static void chancePrint(String[] a)
	{
		MinPQ<String> pq = new MinPQ<String>();
		for(int i = 0;i<a.length;i++)
			pq.insert(a[i]);
		Queue<String> stringTemp = new Queue<String>();
		Queue<Integer> numberTemp = new Queue<Integer>();
		int number = 1;
		String prev = null;
		String str = null;
		for(prev = pq.delMin();!pq.isEmpty();prev = str)
		{
			str = pq.delMin();
			if(prev.equals(str)) 
				number++;
			else {
				stringTemp.enqueue(prev); 
				numberTemp.enqueue(number);
				number = 1;
			}                 
		}
		stringTemp.enqueue(prev); 
		numberTemp.enqueue(number);
		
		pqChance = new Integer[numberTemp.size()];
		for(int i = 0;i<pqChance.length;i++)
			pqChance[i] = numberTemp.dequeue();
		pqString = new String[stringTemp.size()];
		for(int i = 0;i<pqString.length;i++)
			pqString[i] = stringTemp.dequeue();
		
		sort();
		
		for(int i = 0;i<pqString.length;i++)
			System.out.println(pqString[i]+" "+pqChance[i]);
	}
	
	private static void sort()
	{
		int N = pqString.length;
		for(int k = N/2;k>=1;k--)
			sink(k,N);
		while(N>1)
		{
			exch(1,N--);
			sink(1,N);
		}
	}
	
	private static void sink(int k,int N)
	{
		while(2*k<=N)
		{
			int j = 2*k;
			if(j<N&&less(j,j+1)) j++;
			if(!less(k,j)) break;
			exch(k,j);
			k = j;
		}
	}
	
	private static boolean less(int i,int j)
	{
		i--;
		j--;
		return pqChance[j]<pqChance[i];
	}
	
	private static void exch(int i,int j)
	{
		i--;
		j--;
		
		String str = pqString[i];
		pqString[i] = pqString[j];
		pqString[j] = str;
		
		int num = pqChance[i];
		pqChance[i] = pqChance[j];
		pqChance[j] = num;
	}
	
	
	public static void main(String[] args)
	{
		System.out.println("How many strings would you like to input?");
		int N = StdIn.readInt();
		System.out.println("Please input:");
		String[] input = new String[N];
		for(int i = 0;i<N;i++)
		input[i] = StdIn.readString();
		chancePrint(input);
	}
}
