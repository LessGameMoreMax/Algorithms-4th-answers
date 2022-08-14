package myCharpter1_3;

public class MoveToFront 
{
	private int N = 0;
	private Node head = null;
	private class Node{
		String str;
		Node previous;
		Node next;	
	}
	
	public void enter(String input) {
		Node temp = new Node();
		temp.str = input;
		if(N==0) {
			head = temp;
			temp.previous = null;
			temp.next = null;
			N++;
			return;
		}
		temp.previous = null;
		temp.next = head;
		head.previous = temp;
		head = temp;
		N++;
		Node current = head.next;
		while(current.next!=null) {
			if(current.str.equals(input)) {
				current.previous.next = current.next;
				current.next.previous = current.previous;
			}
			current = current.next;
		}
		if(current.str.equals(input)) current.previous.next = null;
		return;
	}
	
	public void printlnAll() {
		if(N==0) throw new RuntimeException("Sorry,it is empty!");
		Node current = head;
		while(current!=null) {
			System.out.println(current.str);
			current = current.next;
		}
	}
}
