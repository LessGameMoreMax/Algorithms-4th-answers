package myCharpter1_3;

import java.lang.reflect.Array;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

class GenericsArray{
	@SuppressWarnings({"unchecked","hiding"})
	public static <Item> Item[] getArray(Class<Item> componentType,int length) {
		return (Item[])Array.newInstance(componentType, length);
	}
}

public class RandomBag<Item> implements Iterable<Item>
{   //感觉可以使用class数组来替代
	//见算法4表1.3.4即84页中创建了泛型数组
	private class RanBag{
		Item item;
		public RanBag(Item item) {
			this.item = item;
		}
	}
	private int N = 0;
	@SuppressWarnings("static-access")
	RanBag[] bag = new GenericsArray().getArray(RanBag.class, 1);
	
	public boolean isEmpty()
	{return N==0;}
	public int size()
	{return N;}
	
	public void add(Item item) {
		bag[N] = new RanBag(item);
		N++;
		if(bag.length==N) {
			RanBag[] bagTemp = new GenericsArray().getArray(RanBag.class, 2*N);
			for(int i =0;i<N;i++) {
				bagTemp[i]=new RanBag(bag[i].item);
			}
			bag = bagTemp;
		}
		return;
	}
	
	public Iterator<Item> iterator()
	{return new ListIterator();}
	public class ListIterator implements Iterator<Item>{
		int number = 0;
		RanBag[] bagTemp = new GenericsArray().getArray(RanBag.class, N);
		public ListIterator() {
			for(int i = 0;i<N;i++) {
				bagTemp[i] = new RanBag(bag[i].item);
			}
			for(int i = 0;i<N;i++) {
				int r = i + StdRandom.uniform(N-i);
				Item temp = bagTemp[i].item;
				bagTemp[i].item = bagTemp[r].item;
				bagTemp[r].item = temp;
			}
		}
		
		public boolean hasNext() {
			return number<N;
		}
		public void remove() {}

		
		public Item next() {
			Item item = bagTemp[number].item;
			number++;
			return item;
		}
	}
	
	
	
}
