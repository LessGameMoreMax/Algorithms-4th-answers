package myCharpter5_1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class QueueSort {
	public static void sort(Student[] a) {
		ST<Integer,Queue<Student>> st = new ST<Integer,Queue<Student>>();
		for(Student s : a) {
			if(!st.contains(s.key())) st.put(s.key(), new Queue<Student>());
			st.get(s.key()).enqueue(s);
		}
		int index = 0;
		for(Integer c : st.keys())
			for(Student s : st.get(c)) {
				a[index] = s;
				index++;
			}
	}
	
	public static void main(String[] args) {
		Student[] std = new Student[10];
		for(int i = 0;i<std.length;i++)
			std[i] = new Student(""+(char)(i+97),StdRandom.uniform(5));
		QueueSort.sort(std);
		for(Student t : std)
			StdOut.println(t);
	}
}
