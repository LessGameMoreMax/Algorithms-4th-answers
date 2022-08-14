package myCharpter1_3;

public class GeneralizedQueueArray<Item>
{
	private int N = 0;
	private Item[] arr = (Item[]) new Object[1];
	
	public boolean isEmpty()
	{return N==0;}
	
	public void insert(Item item) {
		arr[N] = item;
		N++;
		if(N==arr.length) {
			Item[] newArr = (Item[]) new Object[2*N];
			for(int i = 0;i < N;i++)
				newArr[i] = arr[i];
			arr = newArr;
		}
		return;
	}
	
	public Item delete(int k) {
		if(k>N) throw new RuntimeException("Sorry,k must smaller than number!");
		else if(k<=0) throw new RuntimeException("Sorry,k must be bigger than zero!");
		Item temp = arr[k-1];
		for(int i = k;i<N;i++) {
			arr[i-1]  = arr[i];
		}
		arr[--N] = null;
		if(N < arr.length/4) {
			Item[] newArr = (Item[]) new Object[arr.length/2];
			for(int i =0;i<N;i++)
				newArr[i] = arr[i];
			arr = newArr;
		}
		return temp;
	}
}
