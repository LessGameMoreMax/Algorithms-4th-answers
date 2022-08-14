package myCharpter2_2;

import edu.princeton.cs.algs4.Queue;

public class FromGroundToTopMergeQueue {
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
	
	public static Queue<Integer> sort(Queue<Integer> input) {
		Queue<Queue> immortal = new Queue<Queue>();
		while(!input.isEmpty()) {
			Queue<Integer> temp = new Queue<Integer>();
			temp.enqueue(input.dequeue());
			immortal.enqueue(temp);
		}
		
		while(immortal.size()>1) 
			immortal.enqueue(mergeQueue(immortal.dequeue(),immortal.dequeue()));
		return immortal.dequeue();
	}
	
	public static void main(String[] args) {
		Queue<Integer> test = new Queue<Integer>();
		test.enqueue(2);
		test.enqueue(1);
		test.enqueue(8);
		test.enqueue(5);
		test.enqueue(9);
		test.enqueue(6);
		test = sort(test);
		for(Integer s:test)
			System.out.print(s+" ");
	}
}
