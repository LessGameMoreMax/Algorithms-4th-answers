package myCharpter3_5;

import java.util.Iterator;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;

public class LinearProbingHashSTSameKey <Key,Value>{
	private int N;
	private int M = 16;
	private Key[] keys;
	private Queue<Value>[] vals;
	public LinearProbingHashSTSameKey() {
		keys = (Key[]) new Object[M];
		vals = new Queue[M];
		for(int i = 0;i<M;i++)
			vals[i] = new Queue();
	}
	
	public LinearProbingHashSTSameKey(int num) {
		keys = (Key[]) new Object[num];
		vals = new Queue[num];
		for(int i = 0;i<num;i++)
			vals[i] = new Queue();
		M = num;
	}
	
	private int hash(Key key)
	{ return (key.hashCode()&0x7fffffff)%M;}
	
	private void resize(int cap) {
		LinearProbingHashSTSameKey<Key,Value> t = new LinearProbingHashSTSameKey<Key,Value>(cap);
		for(int i = 0;i<M;i++)
			if(keys[i]!=null)
				while(!vals[i].isEmpty())
				t.put(keys[i],vals[i].dequeue());
		keys = t.keys;
		vals = t.vals;
		M = t.M;
	}
	
	public void put(Key key,Value val) {
		if(N>=M/2) resize(2*M);
		int i;
		for(i = hash(key);keys[i]!=null;i=(i+1)%M)
			if(keys[i].equals(key)) {
				vals[i].enqueue(val);
				return;
			}
		keys[i] = key;
		vals[i].enqueue(val);
		N++;
	}
	
	public Value get(Key key) {
		for(int i = hash(key);keys[i]!=null;i = (i+1)%M)
			if(keys[i].equals(key)) return random(vals[i]);
		return null;
	}
	
	private Value random(Queue q) {
		int N = StdRandom.uniform(q.size()) + 1;
		Iterator<Value> t = q.iterator();
		Value val = null;
		for(int i = 0;i<N;i++)
			val = t.next();
		return val;
	}
	
	public void delete(Key key) {
		if(!contains(key)) return;
		int i = hash(key);
		while(!key.equals(keys[i]))
			i = (i+1)%M;
		keys[i] = null;
		vals[i] = null;
		i = (i+1)%M;
		while(keys[i]!=null) {
			Key keyToRedo = keys[i];
			Queue valToRedo = vals[i];
			keys[i] = null;
			vals[i] = new Queue();
			N--;
			while(!valToRedo.isEmpty())
			put(keyToRedo,(Value) valToRedo.dequeue());
			i = (i+1)%M;
		}
		N--;
		if(N>0&&N==M/8) resize(M/2);
	}
	
	public boolean contains(Key key)
	{return get(key)!=null;}
	
	public static void main(String[] args) {
		LinearProbingHashSTSameKey<String,Integer> s = new LinearProbingHashSTSameKey<String,Integer>();
		s.put("A", 1);
		s.put("A", 2);
		s.put("A", 3);
		s.put("B", 4);
		s.put("B", 5);
		System.out.println(s.get("B"));
	}
}
