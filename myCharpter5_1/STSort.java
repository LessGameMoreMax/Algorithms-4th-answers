package myCharpter5_1;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class STSort {
	private Student[] aux;
	
	public STSort(Student[] a) {
		aux = new Student[a.length];
		ST<Integer,Integer> st = new ST<Integer,Integer>(); 
		for(int i = 0;i<a.length;i++)
			if(st.contains(a[i].key())) st.put(a[i].key(), st.get(a[i].key())+1);
			else						st.put(a[i].key(), 1);
		boolean isFirst = true;
		int index = 0;
		for(Integer key : st.keys())
			if(isFirst) {
				index = st.get(key);
				st.put(key, 0);
				isFirst = false;
			}else {
				int temp = st.get(key);
				st.put(key, index);
				index += temp;
			}
		for(int i = 0;i<a.length;i++) {
			aux[st.get(a[i].key())] = a[i];
			st.put(a[i].key(), st.get(a[i].key())+1);
		}
		for(int i = 0;i<a.length;i++)
			a[i] = aux[i]; 
	}
	
	public static void main(String[] args) {
		Student[] std = new Student[10];
		for(int i = 0;i<std.length;i++)
			std[i] = new Student(""+(char)(i+97),StdRandom.uniform(5));
		STSort s = new STSort(std);
		for(Student t : std)
			StdOut.println(t);
	}
}
