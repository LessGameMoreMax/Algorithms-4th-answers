package myCharpter1_5;

import edu.princeton.cs.algs4.StdIn;

public class QuickUnionUF {
	private int[] id;
	private int count;
//	private int arrCount;
	
	public QuickUnionUF(int N) {
		count = N;
		id = new int[N];
		for(int i = 0; i<N;i++)
			id[i] = i;
	}
	
	public int count()
	{ return count;}
	
	public boolean connected(int p,int q)
	{ return find(p)==find(q);}
	
	public int find(int p)
	{	
//		arrCount++;
		while(id[p]!=p) {
			p = id[p];
//			arrCount += 2;
		}
		return p;
	}
	//不变者乃根触点也
	public void union(int p,int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		
		if(pRoot==qRoot) {
//			System.out.println(arrCount);
//			arrCount = 0;
			return;
		}
		
//		arrCount++;
		id[pRoot] = qRoot;
//		System.out.println(arrCount);
		count--;
//		arrCount = 0;
		return;
	}
	
	public void printString()
	{ 
		for(int i =0;i<id.length;i++)
			System.out.print(id[i]+" ");
		System.out.println();
	}
	
//	public static void main(String[] args) {
//		QuickUnionUF uf = new QuickUnionUF(10);
//		while(!StdIn.isEmpty()) {
//			int q = StdIn.readInt();
//			int p = StdIn.readInt();
//			uf.union(p, q);
//			uf.printString();	
//		}
//	}
}
