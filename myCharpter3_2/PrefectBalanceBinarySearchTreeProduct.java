package myCharpter3_2;

import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.StdIn;

public class PrefectBalanceBinarySearchTreeProduct {
	public static void main(String[] args) {
		System.out.println("How many things would you like to input?");
		int N = StdIn.readInt();
		BST<String,Integer> treePre = new BST<String,Integer>();
		System.out.println("Please input:");
		for(int i = 0;i<N;i++)
			treePre.put(StdIn.readString(), StdIn.readInt());
		System.out.println("Loading......");
		BST<String,Integer> tree = new BST<String,Integer>();
		processBST(treePre,tree,0,N-1);
	}
	
	public static void processBST(BST<String,Integer> treePre,BST<String,Integer> tree,int lo,int hi) {
		if(lo>hi) return;
		int mid = lo + (hi-lo)/2;
		tree.put(treePre.select(mid), treePre.get(treePre.select(mid)));
		processBST(treePre,tree,lo,mid-1);
		processBST(treePre,tree,mid+1,hi);
	}
}
