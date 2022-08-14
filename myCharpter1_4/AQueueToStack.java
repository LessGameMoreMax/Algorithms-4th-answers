package myCharpter1_4;

import edu.princeton.cs.algs4.Queue;

public class AQueueToStack<Item> 
{
	private Queue<Item> quStack = new Queue<Item>();
	private int num = 0;
	
	public int size()
	{ return num;}
	public boolean isEmpty() 
	{ return num==0;}
	
	public void push(Item item) {
		quStack.enqueue(item);
		num++;
	}
	
	public Item pop() {
		if(num==0) throw new RuntimeException("Sorry,it's empty!");
		num--;
		for(int i = 0;i<num;i++)
			quStack.enqueue(quStack.dequeue());
		return quStack.dequeue(); 
	}
	
}
