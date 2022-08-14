package myCharpter1_4;

import edu.princeton.cs.algs4.Stack;

public class TwoStackToAQueue<Item> 
{
	private Stack<Item> enStack = new Stack<Item>();
	private Stack<Item> deStack = new Stack<Item>();
	
	public void enqueue(Item item) {
		enStack.push(item);
	}
	
	public Item dequeue() {
		if(deStack.isEmpty()) 
			if(enStack.isEmpty()) throw new RuntimeException("Sorry,it's empty!");
			else
				while(!enStack.isEmpty())
					deStack.push(enStack.pop());
		return deStack.pop();
	}
}
