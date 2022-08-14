package myCharpter1_3;

public class RingBuffer<Item> 
{
	private int length;
	private int N = 0;
	private int head = 0;
	private int tail = 0;
	private Item[] cirArr;
	
	public RingBuffer(int length) {
		this.length = length;
		cirArr = (Item[]) new Object[length];
	}
	
	public boolean isEmpty()
	{ return N==0;}
	public int size()
	{ return N;}
	
	public void enqueue(Item item) {
		if(N==length) throw new RuntimeException("Sorry,the buffer is full!");
		if(N!=0) tail = (tail+1)%length;
		cirArr[tail] = item;
		N++;
		return;
	}
	
	public Item dequeue() {
		if(N==0) throw new RuntimeException("Sorry,the buffer is empty!");
		Item temp = cirArr[head];
		cirArr[head] = null;
		if(N!=1) head = (head+1)%length;
		N--;
		return temp;
	}
}
