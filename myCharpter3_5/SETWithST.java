package myCharpter3_5;

import edu.princeton.cs.algs4.ST;

public class SETWithST <Key extends Comparable>{
	private ST st;
	
	public void add(Key key) {
		st.put(key, null);
	}
	
	public void delete(Key key) {
		st.delete(key);
	}
	
	public boolean contains(Key key) {
		return st.contains(key);
	}
	
	public boolean isEmpty() {
		return st.isEmpty();
	}
	
	public int size() {
		return st.size();
	}
	
	public String toString() {
		return st.toString();
	}
	
}
