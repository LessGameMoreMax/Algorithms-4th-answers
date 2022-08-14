package myCharpter1_3;

public class ResizingArrayDeque //注意可以使用84页创建泛型数组
{								//注意使用数组实现有关数据结构时要避免对象游离 形如a[N] = null;
	private String[] arr = new String[3];
	private int flag = 1;
	private int head = 1;
	private int tail = 1;
	private int N = 0;
	
	public boolean isEmpty()
	{ return N==0; }
	public int size()
	{ return N; }
	
	public void pushLeft(String str) {
		arr[head] = str;
		if(head==tail) {
			head--;
			tail++;
			N++;
			return;
		}
		if(head==0) {
			flag++;
			String[] newArr = new String[3*myPow(flag-1)];
			for(int i=0;i<(tail-head);i++)
				newArr[flag+i] = arr[i];
			arr = newArr;
			tail += flag; 
			head = flag - 1;
		}else 
			head--;
		N++;
		return;
	}
	
	public void pushRight(String str) {
		arr[tail] = str;
		if(head==tail) {
			head--;
			tail++;
			N++;
			return;
		}
		if(tail==(arr.length-1)) {
			flag++;
			String[] newArr = new String[3*myPow(flag-1)];
			for(int i=0;i<(tail-head);i++)
				newArr[newArr.length-1-flag-i] = arr[arr.length-1-i];
			arr = newArr;
			head = arr.length-flag-N-2;
			tail = arr.length-flag; 
		}else 
			tail++;
		N++;
		return;
	}
	
	public String popLeft() {
		if(N==0) throw new RuntimeException("Sorry,it is empty!");
		head++;
		String temp = arr[head];
		arr[head] = null;
		N--;
		if(N==0) {
			return temp;
		}
		if(N<arr.length/3) {
			flag--;
			String[] newArr = new String[3*myPow(flag-1)];
			for(int i=0;i<N;i++) 
				newArr[flag+i] = arr[head+1+i];
			arr = newArr;
			head = flag-1;
			tail = flag+N;
		}
		return temp;
	}
	
	public String popRight() {
		if(N==0) throw new RuntimeException("Sorry,it is empty!");
		tail--;
		String temp = arr[tail];
		arr[tail] = null;
		N--;
		if(N==0) return temp;
		if(N<arr.length/3) {
			flag--;
			String[] newArr = new String[3*myPow(flag-1)];
			for(int i=0;i<N;i++) 
				newArr[newArr.length-1-flag-i] = arr[tail-1-i];
			arr = newArr;
			head = arr.length-flag-N-1;
			tail = arr.length - flag;
		}
		return temp;
	}
	
	private static int myPow(int n) {
		if(n==0) return 1;
		return 2*myPow(n-1);
	}
	
	
	
}
