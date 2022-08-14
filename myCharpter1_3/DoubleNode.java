package myCharpter1_3;

public class DoubleNode<Item> 
{
	private int N;
	private Node head;
	private Node tail;
	private class Node{
		Item item;
		Node previous;
		Node next;
	}
	
	public boolean isEmpty()
	{return N==0;}
	public int size()
	{return N;}
	
	public void headEnter(Item item) {
		Node temp = new Node();
		temp.item = item;
		if(N==0) {
			tail = temp;
			temp.previous = null;
			temp.next = null;
		}else {
			temp.next = head;
			temp.previous = null;
			head.previous = temp;
		}
		head = temp;
		N++;
		return;
	}
	
	public void tailEnter(Item item) {
		Node temp = new Node();
		temp.item = item;
		if(N==0) {
			head = temp;
			temp.previous = null;
			temp.next = null;
		}else {
			temp.next = null;
			temp.previous = tail;
			tail.next = temp;
		}
		tail = temp;
		N++;
		return;
	}
	
	public Item headDelete() {
		if(N==0) throw new RuntimeException("Sorry,the DoubleNode is empty!");
		Item temp = head.item;
		if(N==1) {
			head = null;
			tail = null;
		}else {
			head = head.next;
			head.previous.next = null;//¿ÉÐ´¿É²»Ð´
			head.previous = null;
		}
		N--;
		return temp;
	}
	
	public Item tailDelete() {
		if(N==0) throw new RuntimeException("Sorry,the DoubleNode is empty!");
		Item temp = tail.item;
		if(N==1) {
			head = null;
			tail = null;
		}else {
			tail = tail.previous;
			tail.next = null;
		}
		N--;
		return temp;
	}
	
	public void frontEnterAppoint(int k ,Item item) {
		if(N==0) throw new RuntimeException("Sorry,the DoubleNode is empty!");
		if(k<=0) throw new RuntimeException("Sorry,the k must be bigger than zero!");
		else if(k>N) throw new RuntimeException("Sorry,the k is bigger than the node number!");
		if(k==1) 
			headEnter(item);
		else {
			Node target = null;
			if(k<=N/2) {
				target = head;
				for(int i=1;i<k;i++) 
					target = target.next;
			}else {
				target = tail;
				for(int i=0;i<(N-k);i++) 
					target = target.previous;
			}
			Node temp = new Node();
			temp.item = item;
			target.previous.next = temp;
			temp.previous = target.previous;
			target.previous = temp;
			temp.next = target;
			N++;
		}
		return;
	}
	
	public void behindEnterAppoint(int k ,Item item) {
		if(N==0) throw new RuntimeException("Sorry,the DoubleNode is empty!");
		if(k<=0) throw new RuntimeException("Sorry,the k must be bigger than zero!");
		else if(k>N) throw new RuntimeException("Sorry,the k is bigger than the node number!");
		if(k==N) 
			tailEnter(item);
		else {
			Node target = null;
			if(k<=N/2) {
				target = head;
				for(int i=1;i<k;i++) 
					target = target.next;
			}else {
				target = tail;
				for(int i=0;i<(N-k);i++) 
					target = target.previous;
			}
			Node temp = new Node();
			temp.item = item;
			target.next.previous = temp;
			temp.next = target.next;
			target.next = temp;
			temp.previous = target;
			N++;
		}
		return;
	}
	
	public Item deleteNodeAppoint(int k) {
		if(N==0) throw new RuntimeException("Sorry,the DoubleNode is empty!");
		if(k<=0) throw new RuntimeException("Sorry,the k must be bigger than zero!");
		else if(k>N) throw new RuntimeException("Sorry,the k is bigger than the node number!");
		if(k==1) return headDelete();
		else if(k==N) return tailDelete();
		else {
			Node target = null;
			if(k<=N/2) {
				target = head;
				for(int i=1;i<k;i++) 
					target = target.next;
			}else {
				target = tail;
				for(int i=0;i<(N-k);i++) 
					target = target.previous;
			}
			Item item = target.item;
			target.previous.next = target.next;
			target.next.previous = target.previous;
			target.previous = null;
			target.next = null;
			N--;
			return item;
		}
	}
}
