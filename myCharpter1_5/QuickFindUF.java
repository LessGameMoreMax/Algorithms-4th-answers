package myCharpter1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFindUF 
{
	private int[] id;
	private int count;
	
	public QuickFindUF(int N) {
		count = N;
		id = new int[N];
		for(int i =0;i<N;i++)
			id[i] = i;
	}
	
	public int count()
	{ return count;}
	
	public int find(int p)
	{ return id[p];}
	
	public boolean connected(int p,int q) 
	{ return id[p]==id[q];}
	
	public void union(int p, int q) {
//		int arrayCount = 0;
		int pId = id[p];
		int qId = id[q];
		
//		arrayCount += 2;
		
		if(pId==qId) {
//			System.out.println(arrayCount);
			return;
		}
		
		for(int i = 0;i < id.length;i++) {
//			arrayCount++;
			if(id[i]==pId) {
//				arrayCount++;
				id[i] = qId;
			}
		}
//		System.out.println(arrayCount);
		count--;
		return;
	}
	
	public void printString() {
		for(int i = 0;i<id.length;i++)
			System.out.print(id[i]+" ");
		System.out.println();
	}
	
//	public static void main(String[] args) {
//		QuickFindUF uf = new QuickFindUF(10);
//		while(!StdIn.isEmpty()) {
//			int p = StdIn.readInt();
//			int q = StdIn.readInt();
//			uf.union(p, q);
//			uf.printString();
//			StdOut.println(p + " " + q);
//		}
//		StdOut.println(uf.count() + "components");
//	}
	
}
