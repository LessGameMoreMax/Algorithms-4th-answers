package myCharpter1_5;

import edu.princeton.cs.algs4.StdIn;

public class DistanceZIPQuickUnion {
	private int count;
	private int[] id;
	
	public DistanceZIPQuickUnion(int N) {
		count = N;
		id = new int[N];
		for(int i =0;i<N;i++)
			id[i] = i;
	}
	
	public int count()
	{ return count;}
	
	public boolean connected(int p,int q)
	{return find(p)==find(q);}
	
	public int find(int p) {
		if(id[p]==p) return p;
		id[p] = find(id[p]);
		return id[p];
	}
	
	public void union(int p,int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		
		if(pRoot==qRoot) return;
		
		id[pRoot] = qRoot;
		
		count--;
		return;
	}
	
	public void printId() {
		for(int i =0;i<id.length;i++)
			System.out.print(id[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		DistanceZIPQuickUnion test = new DistanceZIPQuickUnion(5);
		while(!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			test.union(p, q);
			test.printId();
		}
	}
}
