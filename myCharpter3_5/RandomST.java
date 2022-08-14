package myCharpter3_5;

import edu.princeton.cs.algs4.ST;

public class RandomST<Key extends Comparable<Key>,Value> {
	private ST<Key,Value> st;
	private BinarySearchSET<Key> set;
	
	public RandomST() {
		st = new ST<Key,Value>();
		set = new BinarySearchSET<Key>();
	}
	
	public void put(Key key,Value val) {
		set.put(key);
		st.put(key, val);
	}
	
	public Value get(Key key) {
		return st.get(key);
	}
	
	public void delete() {
		Key key = set.deleteRandom();
		st.delete(key);
	}
}
