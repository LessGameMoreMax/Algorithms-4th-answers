package myCharpter3_5;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;

public class UniQueue<Key>{
	private Queue<Key> q;
	private SET set;
	
	public UniQueue() {
		q = new Queue<Key>();
		set = new SET();
	}
	
	public void enqueue(Key key) {
		if(set.contains((Comparable) key)) return;
		set.add((Comparable) key);
		q.enqueue(key);
	}
	
	public Key dequeue() {
		Key temp = q.dequeue();
		set.delete((Comparable) temp);
		return temp;
	}
}
