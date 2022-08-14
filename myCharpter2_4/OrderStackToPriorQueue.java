package myCharpter2_4;

public class OrderStackToPriorQueue<Key extends Comparable<Key>> {
	private int N = 0;
	private class Node{
		Key key;
		Node next;
	}
	private Node first = null;
	
	public boolean isEmpty()
	{ return N==0;}
	
	public int size()
	{ return N;}
	
	public void insert(Key v) {
		Node node = new Node();
		node.key = v;
		node.next = first;
		first = node;
		N++;
		Node police = first;
		while(police.next!=null&&less(police,police.next)) {
			exch(police,police.next);
			police = police.next;
		}
	}
	
	public Key delMax() {
		if(N==0) return null;
		N--;
		Key temp = first.key;
		first = first.next;
		return temp;
	}
	
	private boolean less(Node v,Node w)
	{ return v.key.compareTo(w.key)<0;}
	
	private void exch(Node v,Node w) {
		Key temp = v.key;
		v.key = w.key;
		w.key = temp;
	}
	
	public static void main(String[] args) {
		OrderStackToPriorQueue<Integer> test = new OrderStackToPriorQueue<Integer>();
		test.insert(6);
		test.insert(4);
		test.insert(8);
		test.insert(4);
		test.insert(2);
		test.insert(7);
		test.insert(3);
		while(!test.isEmpty())
			System.out.print(test.delMax()+" ");
	}
	
}
