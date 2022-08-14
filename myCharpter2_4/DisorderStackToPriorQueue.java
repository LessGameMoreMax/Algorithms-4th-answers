package myCharpter2_4;

public class DisorderStackToPriorQueue<Key extends Comparable<Key>> {
	private Node first = null;
	private class Node{
		Key item;
		Node next;
	}
	private int N = 0;
	
	public boolean isEmpty()
	{return N==0;}
	
	public int size()
	{return N;}
	
	public void insert(Key v) {
		Node node = new Node();
		N++;
		node.item = v;
		node.next = first;
		first = node;
	}
	
	public Key delMax() {
		if(N==0) return null;
		N--;
		Node police = first;
		while(police!=null) {
			if(less(first.item,police.item)) exch(first,police);
			police = police.next;
		}
		Key max = first.item;
		first = first.next;
		return max;
	}
	
	private boolean less(Key v,Key w)
	{ return v.compareTo(w)<0;}
	
	private void exch(Node v,Node w) {
		Key temp = v.item;
		v.item = w.item;
		w.item = temp;
	}
	
	public static void main(String[] args) {
		DisorderStackToPriorQueue<Integer> test = new DisorderStackToPriorQueue<Integer>();
		test.insert(4);
		test.insert(7);
		test.insert(4);
		test.insert(1);
		test.insert(9);
		test.delMax();
		test.delMax();
		test.insert(7);
		test.insert(8);
		test.insert(9);
		while(!test.isEmpty())
			System.out.print(test.delMax());
	}
}
