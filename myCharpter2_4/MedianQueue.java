package myCharpter2_4;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.MinPQ;

public class MedianQueue {
	MinPQ<Integer> second;
	MaxPQ<Integer> first;
	Integer median;
	
	public MedianQueue()
	{
		second = new MinPQ<Integer>();
		first = new MaxPQ<Integer>();
	}
	
	
	public void insert(Integer num)
	{
		if(median==null) {
			median = num;
			return;
		}
		if(num<median) first.insert(num);
		else 		   second.insert(num);
		if(Math.abs(second.size()-first.size())>1) averge();
	}
	
	private void averge()
	{
		while(first.size()-second.size()>1) {
			second.insert(median);
			median = first.delMax();
		}
		
		while(second.size()-first.size()>1) {
			first.insert(median);
			median = second.delMin();
		}
	}
	
	public Integer delMedian()
	{
		if(median==null) return null;
		
		Integer temp = median;
		median = null;
		if(first.size()==0&&second.size()==0) return temp;
		
		if(first.size()>second.size())
			median = first.delMax();
		else
			median = second.delMin();
		return temp;
	}
}
