package myCharpter3_5;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

public class MyList <Item>{
	ST<Integer,Item> st = new ST<Integer,Item>();
	SeparateChainingHashST<Item,Integer> ts = new SeparateChainingHashST<Item,Integer>();
	
	public int size() {
		return st.size();
	}
	
	public boolean isEmpty() {
		return st.isEmpty();
	}
	
	public boolean contains(Item item) {
		return ts.contains(item);
	}
	
	public void addFront(Item item) {
		for(Item i : ts.keys()) 
			st.put(ts.get(item)+1, i);
		st.put(1,item);
		for(int i : st.keys())
			ts.put(st.get(i), i);
	}
	
	public void addBack(Item item) {
		st.put(st.size()+1, item);
		ts.put(item, st.size());
	}
	
	public Item deleteFront() {
		Item temp = st.get(1);
		for(Item i : ts.keys()) 
			st.put(ts.get(i)-1, i);
		st.delete(0);
		st.delete(st.size()-1);
		for(int i : st.keys())
			ts.put(st.get(i), i);
		ts.delete(temp);
		return temp;
	}
	
	public Item deleteBack() {
		int temp = st.size();
		Item i = st.get(temp);
		st.delete(temp);
		ts.delete(i);
		return i;
	}
	
	public void delete(Item item) {
		for(int i = ts.get(item);i<st.size();i++) {
			st.put(i, st.get(i+1));
			ts.put(st.get(i), i);
		}
		st.delete(st.size());
		ts.delete(item);
	}
	
	public void add(int i,Item item) {
		if(i<1||i>st.size()+1) return;
		
		for(int j = st.size()+1;j>i;j--) {
			ts.put(st.get(j-1), j);
			st.put(j, st.get(j-1));
		}
		ts.put(item, i);
		st.put(i, item);
	}
	
	public Item delete(int i) {
		if(i<1||i>st.size()+1) return null;
		
		Item temp = st.get(i);
		
		for(int j = i;j<st.size();j++) {
			ts.put(st.get(j+1), j);
			st.put(j, st.get(j+1));
		}
		ts.delete(temp);
		st.delete(st.size());
		
		return temp;
	}
	
}
