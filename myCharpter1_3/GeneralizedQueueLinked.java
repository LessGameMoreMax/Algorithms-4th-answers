package myCharpter1_3;

public class GeneralizedQueueLinked<Item> 
{
	private int N = 0;
	private Node head = null;
	private Node tail = null;
	private class Node{
		Item item;
		Node previous;
		Node next;
	}
	
	public boolean isEmpty()
	{ return N==0;}
	
	public void insert(Item item) {
		Node temp = new Node();
		temp.item = item;
		if(N==0) {
			temp.previous = null;
			head = temp;
		}else {
			temp.previous = tail;
			tail.next = temp;
		}
		temp.next = null;
		tail = temp;
		N++;
		return;
	}
	
	public Item delete(int k) {
		if(k>N||k<=0) throw new RuntimeException("Sorry,it is wrong!");
		if(N==1) {
			Item temp = head.item;
			head = null;
			tail = null;
			N--;
			return temp;
		}
		if(k==1) {
			Item temp = head.item;
			head = head.next;
			head.previous = null;
			N--;
			return temp;
		}else if(k==N) {
			Item temp = tail.item;
			tail = tail.previous;
			tail.next = null;
			N--;
			return temp;
		}else {
			Node target = null;
			if(k<N/2) {
				target = head;
				for(int i =1;i<k;i++){
					target = target.next;
				}
			}else {
				target = tail;
				for(int i =0;i<N-k;i++) {
					target = target.previous;
				}
			}
			Item temp = target.item;
			target.next.previous = target.previous;
			target.previous.next = target.next;
			N--;
			return temp;
		}
	}
}
