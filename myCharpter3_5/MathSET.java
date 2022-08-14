package myCharpter3_5;

import java.util.Iterator;

import edu.princeton.cs.algs4.SET;

public class MathSET <Key extends Comparable>{
	private SET U;
	private SET set;
	
	public MathSET(SET U) {
		this.U = U;
	}
	
	public void add(Key key) {
		set.add(key);
	}
	
	public MathSET<Key> complement(){
		MathSET<Key> newSet = new MathSET<Key>(U);
		Iterator<Key> t = U.iterator();
		while(t.hasNext()) {
			Key key = t.next();
			if(!set.contains(key))
				newSet.add(key);
		}
		return newSet;	
	}
	
	public void union(MathSET<Key> a) {
		Iterator<Key> t = a.iterator();
		while(t.hasNext()) {
			Key key = t.next();
			if(!set.contains(key))
				this.set.add(key);
		}
	}
	
	public void intersection(MathSET<Key> a) {
		Iterator<Key> t = set.iterator();
		while(t.hasNext()) {
			Key key = t.next();
			if(!a.contains(key))
				this.set.delete(key);
		}
	}
	
	public void delete(Key key) {
		this.set.delete(key);
	}
	
	public Iterator<Key> iterator(){
		return this.set.iterator();
	}
	
	public boolean contains(Key key) {
		return this.set.contains(key);
	}
	
	public boolean isEmpty() {
		return this.set.isEmpty();
	}
	
	public int size() {
		return this.set.size();
	}
}
