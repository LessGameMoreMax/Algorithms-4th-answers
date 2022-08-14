package myCharpter3_5;

public class LRUTemp <Key extends Comparable<Key>,Value>{
	private Node first;
	private class Node{
		private Key key;
		private Value val;
		private Node next;
		public Node(Key key,Value val,Node next){
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	private int N;
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public void get(Key key,Value val) {
		N++;
		Node x = first;
		while(x!=null) {
			if(key.compareTo(x.key)==0)
				deleteSample(key);
			x = x.next;
		}
		Node temp = new Node(key,val,first);
		first = temp;
	}
	
	public void delete() {
		deleteSample(first.key);
	}
	
	private void deleteSample(Key key) {
		if(this.isEmpty()) return;
		if(key.equals(first.key)) {
			first = first.next;
			N--;
			return;
		}
		if(this.size()==1) return;
		Node nodeFirst = first.next;
		Node nodeSecond = first;
		while(nodeFirst!=null) {
			if(key.equals(nodeFirst.key)) {
				nodeSecond.next = nodeFirst.next;
				N--;
				return;
			}
			nodeFirst = nodeFirst.next;
			nodeSecond = nodeSecond.next;
		}
	}
}
