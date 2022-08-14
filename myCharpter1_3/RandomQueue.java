package myCharpter1_3;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

public class RandomQueue<Item> implements Iterable<Item>
{
	private Item[] arr = (Item[]) new Object[1];
	private int N;
	
	public boolean isEmpty()
	{ return N==0;}
	
	public void enqueue(Item item) {
		arr[N] = item;
		N++;
		if(N==arr.length) {
			Item[] newArr = (Item[]) new Object[2*N];
			for(int i=0;i<N;i++)
				newArr[i]=arr[i];
			arr=newArr;
		}
		return;
	}
	
	public Item dequeue() {
		if(N==0) throw new RuntimeException("Sorry,this randomqueue is empty!");
		int num =StdRandom.uniform(N);
		Item temp = arr[num];
		arr[num] = arr[N-1];
		arr[N-1] = null;
		N--;
		return temp;
	}
	
	public Item sample() {
		if(N==0) throw new RuntimeException("Sorry,this randomqueue is empty!");
		return arr[StdRandom.uniform(N)];
	}
	
	public Iterator<Item> iterator(){
		return new ListIterator();}
	private class ListIterator implements Iterator<Item>{
		int number =0;
		private Item[] newArr = (Item[]) new Object[N];
		
		public ListIterator() {                   //使用构造器以创建一个打乱顺序的新数组
			for(int i = 0;i<N;i++) {
				newArr[i] = arr[i];
			}
			for(int i=0;i<N;i++) {
				int random = i+StdRandom.uniform(N-i);
				Item temp = newArr[i];
				newArr[i] = newArr[random];
				newArr[random] = temp;
			}
		}
		
		public boolean hasNext()
		{return number<N;}              //注意判断条件
		
		public void remove() {}
		
		public Item next() {
			Item temp = newArr[number];
			number++;
			return temp;
		}
		
	}
	
}
