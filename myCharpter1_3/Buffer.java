package myCharpter1_3;


public class Buffer {
	private int Nfront = 0;
	private int Nbehind = 0;
	MyStack<Character> front = new MyStack<Character>();
	MyStack<Character> behind = new MyStack<Character>();
	
	public int size()
	{ return Nfront+Nbehind;}

	public void insert(char c) {
		front.push(c);
		Nfront++;
	}
	
	public char delete() {
		Nfront--;
		return front.pop();
	}
	
	public void left(int k) {
		for(int i = 0;i<k;i++) {
			Nfront--;
			Nbehind++;
			behind.push(front.pop());
		}
	}
	
	public void right(int k) {
		for(int i = 0;i<k;i++) {
			Nfront++;
			Nbehind--;
			front.push(behind.pop());
		}
	}
}
