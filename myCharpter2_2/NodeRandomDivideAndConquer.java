package myCharpter2_2;

import edu.princeton.cs.algs4.StdRandom;

public class NodeRandomDivideAndConquer {
	private class Node{
		Integer number;
		Node next;
	}
	
	private int size = 0;
	
	public void randomSort(Node first) {
		for(Node temp = first;temp!=null;temp = temp.next)
			size++;
		randomSort(first,0,size-1);
	}
	
	public void randomSort(Node first,int lo,int hi) {
		if(lo>=hi) return;
		int mid = lo + (hi-lo)/2;
		randomSort(first,lo,mid);
		randomSort(first,mid+1,hi);
		merge(first,lo,hi);
	}
	
	public void merge(Node first,int lo,int hi) {
		for(int i = 0;i<lo;i++)
			first = first.next;
		int num = 0;
		while((lo+num+1)<(hi+1)) {
			Node temp = first;
			int tempNum = StdRandom.uniform(lo+num+1,hi+1); 
			for(int i = 0;i<tempNum-lo-num;i++)
				temp = temp.next;
			Integer tempNumber = temp.number;
			temp.number = first.number;
			first.number = tempNumber;
			num++;
			first = first.next;
		}
	}
	
	public static void show(Node node) {
		while(node!=null) {
			System.out.print(node.number+" ");
			node = node.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		NodeRandomDivideAndConquer temp = new NodeRandomDivideAndConquer();
		Node test1 = temp.new Node();
		Node test2 = temp.new Node();
		Node test3 = temp.new Node();
		Node test4 = temp.new Node();
		Node test5 = temp.new Node();
		Node test6 = temp.new Node();
		Node test7 = temp.new Node();
		Node test8 = temp.new Node();
		
		test1.number = 1;
		test2.number = 2;
		test3.number = 3;
		test4.number = 4;
		test5.number = 5;
		test6.number = 6;
		test7.number = 7;
		test8.number = 8;
		
		test1.next = test2;
		test2.next = test3;
		test3.next = test4;
		test4.next = test5;
		test5.next = test6;
		test6.next = test7;
		test7.next = test8;
		
		temp.randomSort(test1);
		show(test1);
		
	}
}
