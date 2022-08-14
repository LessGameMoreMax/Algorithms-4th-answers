package myCharpter1_4;

import edu.princeton.cs.algs4.Stack;

public class ThreeStackToDoubleQueue<Item>
{
	private int numLeft = 0;
	private int numRight = 0;
	private Stack<Item> leftSt = new Stack<Item>();
	private Stack<Item> rightSt = new Stack<Item>();
	private Stack<Item> tempSt = new Stack<Item>();
	
	public int size()
	{return numLeft+numRight;}
	public boolean isEmpty()
	{return (numLeft+numRight)==0;}
	
	public void pushLeft(Item item) {
		leftSt.push(item);
		numLeft++;
	}
	
	public void pushRight(Item item) {
		rightSt.push(item);
		numRight++;
	}
	
	public Item popRight() {
		if((numLeft+numRight)==0) throw new RuntimeException("Sorry,its empty!");
		if(numRight==0) {
			while(!leftSt.isEmpty()) {
				tempSt.push(leftSt.pop());
				numLeft--;
				numRight++;
			}
			Stack temp;
			temp = tempSt;
			tempSt = rightSt;
			rightSt = temp;
		}
		numRight--;
		return rightSt.pop();
	}
	
	public Item popLeft() {
		if((numLeft+numRight)==0) throw new RuntimeException("Sorry,its empty!");
		if(numLeft==0) {
			while(!rightSt.isEmpty()) {
				tempSt.push(rightSt.pop());
				numLeft++;
				numRight--;
			}
			Stack temp;
			temp = tempSt;
			tempSt = leftSt;
			leftSt = temp;
		}
		numLeft--;
		return leftSt.pop();
	}
}
