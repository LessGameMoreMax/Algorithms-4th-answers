package myCharpter1_4;

import edu.princeton.cs.algs4.Stack;

public class TwoStackToSteque<Item> 
{
	private int numStack = 0;
	private int numQueue = 0;
	private Stack<Item> stStack = new Stack<Item>();
	private Stack<Item> quStack = new Stack<Item>();
	
	public int size()
	{ return numStack+numQueue;}
	public boolean isEmpty()
	{ return numStack+numQueue==0;}
	
	public void push(Item item) {
		stStack.push(item);
		numStack++;
	}
	
	public void enqueue(Item item) {
		quStack.push(item);
		numQueue++;
	}
	
	public Item pop() {
		if(numStack==0&&numQueue==0) throw new RuntimeException("Sorry,it's empty!");
		if(numStack==0) 
			while(!quStack.isEmpty()) {
				stStack.push(quStack.pop());
				numQueue--;
				numStack++;
			}
		numStack--;
		return stStack.pop();
	}
}
