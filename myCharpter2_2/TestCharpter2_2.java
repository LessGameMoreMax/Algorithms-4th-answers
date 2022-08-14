package myCharpter2_2;

import edu.princeton.cs.algs4.Queue;

public class TestCharpter2_2 {
	//2.2.14
	public static Queue<Integer> mergeQueue(Queue<Integer> a,Queue<Integer> b) {
		Queue<Integer> output = new Queue<Integer>();
		Integer p = null;
		Integer q = null;
		int number = a.size()+b.size();
		if(!a.isEmpty()) p = a.dequeue();
		if(!b.isEmpty()) q = b.dequeue();
		for(int i = 0;i<number;i++) {
			if	   (a.isEmpty()&&p==null) 	{output.enqueue(q); if(!b.isEmpty()) q = b.dequeue();else q =null;} 
			else if(b.isEmpty()&&q==null) 	{output.enqueue(p); if(!a.isEmpty()) p = a.dequeue();else p =null;}
			else if(p.compareTo(q)<0)       {output.enqueue(p); if(!a.isEmpty()) p = a.dequeue();else p =null;}
			else   							{output.enqueue(q); if(!b.isEmpty()) q = b.dequeue();else q =null;}
		}
		return output;
	}
//	public static void main(String[] args) {
//		Queue<Integer> a = new Queue<Integer>();
//		Queue<Integer> b = new Queue<Integer>();
//		a.enqueue(2);
//		b.enqueue(1);
//		Queue<Integer> out = mergeQueue(a,b);
//		for(Integer s:out)
//			System.out.print(s+" ");
//	}
//*****************************************************************************************************************
	
}
