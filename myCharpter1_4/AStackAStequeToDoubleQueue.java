package myCharpter1_4;

import edu.princeton.cs.algs4.Stack;

public class AStackAStequeToDoubleQueue<Item> 
{
	private int numSteque = 0;
	private int numStack = 0;
	private TwoStackToSteque<Item> steque = new TwoStackToSteque<Item>();
	private Stack<Item> stack = new Stack<Item>();
	
	public int size()
	{ return numSteque+numStack;}
	public boolean isEmpty()
	{return (numSteque+numStack)==0;}
	
	public void pushLeft(Item item) {
		steque.push(item);
		numSteque++;
	}
	
	public void pushRight(Item item) {
		if(!stack.isEmpty()) {
			stack.push(item);
			numStack++;
			return;
		}
		numSteque++;
		steque.enqueue(item);
		return;
	}
	
	public Item popLeft() {
		if(isEmpty()) throw new RuntimeException("Sorry,it's empty!");
		if(numSteque==0) 
			while(!stack.isEmpty()) {
				steque.push(stack.pop());
				numStack--;
				numSteque++;
			}
		numSteque--;
		return steque.pop();
	}
	
	public Item popRight() {
		if(isEmpty()) throw new RuntimeException("Sorry,it's empty!");
		if(stack.isEmpty()) 
			while(numSteque!=0) {
				stack.push(steque.pop());
				numSteque--;
				numStack++;
			}
		numStack--;
		return stack.pop();
	}
}
