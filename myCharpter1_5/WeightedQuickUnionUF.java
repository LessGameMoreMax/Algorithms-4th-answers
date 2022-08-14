package myCharpter1_5;

import edu.princeton.cs.algs4.StdIn;

public class WeightedQuickUnionUF {
	private int[] id;
	private int[] sz;
	private int count;
	
	private int arrayCount = 0; 
	
	public WeightedQuickUnionUF(int N) {
		count = N;
		id = new int[N];
		sz = new int[N];
		for(int i = 0;i<N;i++)
			id[i] = i;
		for(int i = 0;i<N;i++)
			sz[i] = 1;
	}
	
	public int count()
	{return count;}
	
	public boolean connected(int p,int q)
	{return find(p)==find(q);}
	
	public int find(int p) {
		arrayCount++;
		while(id[p]!=p) {
			arrayCount += 2;
			p = id[p];
		}
		return p;
	}
	
	public void union(int p,int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		
		if(pRoot==qRoot) {
			System.out.println(arrayCount);
			arrayCount = 0;
			return;
		}
		
		if(sz[pRoot]>sz[qRoot]) {
			id[qRoot] = pRoot;
			sz[pRoot] += sz[qRoot];
		}else {
			id[pRoot] = qRoot;
			sz[qRoot] += sz[pRoot];
		}
		arrayCount++;
		System.out.println(arrayCount);
		arrayCount = 0;
		count--;
	}
	
	public void stringPrint()
	{
		for(int i =0;i<id.length;i++)
			System.out.print(id[i]+" ");
		System.out.println();
		for(int i =0;i<sz.length;i++)
			System.out.print(sz[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		WeightedQuickUnionUF test = new WeightedQuickUnionUF(10);
		while(!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			test.union(p, q);
			test.stringPrint();	
		}
	}
}
