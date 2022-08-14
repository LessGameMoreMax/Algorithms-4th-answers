package myCharpter3_5;

import java.util.Iterator;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.ST;

public class Invert {
	public static ST<String,Bag<String>> invert(ST<String,Bag<String>> st){
		ST<String,Bag<String>> ts = new ST<String,Bag<String>>();
		for(String key : st.keys()) {
			Bag<String> bag = st.get(key);
			Iterator<String> vals = bag.iterator();
			while(vals.hasNext()) {
				String val = vals.next();
				if(!ts.contains(val)) ts.put(val, new Bag<String>());
				ts.get(val).add(key);
			}
		}
		return ts;
	}
}
