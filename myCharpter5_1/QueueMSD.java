package myCharpter5_1;
import edu.princeton.cs.algs4.MSD;
import edu.princeton.cs.algs4.Queue;

public class QueueMSD {
	private static int R = 256;
	private static String[] aux;
	private static int charAt(String s,int d)
	{ if(d<s.length()) return s.charAt(d); else return -1;}
	
	public static void sort(String[] a) {
		int N = a.length;
		aux = new String[N];
		Queue<String>[] queue = new Queue[R+2];
		for(int i = 0;i<R+2;i++)
			queue[i] = new Queue<String>();
		sort(a,0,N-1,0,queue);
	}
	
	private static void sort(String[] a,int lo,int hi,int d,Queue<String>[] queue) {
		if(hi<=lo) return;
		int[] count = new int[R+2];
		for(int i = lo;i<=hi;i++) {
			queue[charAt(a[i],d)+2].enqueue(a[i]);
			count[charAt(a[i],d)+2]++;
		}
		for(int r = 0;r<R+1;r++)
			count[r+1] += count[r];
		int num = lo;
		for(Queue<String> q : queue)
			while(!q.isEmpty())
				a[num++] = q.dequeue();
		for(int r = 0;r<R;r++)
			sort(a , lo + count[r] , lo + count[r+1] - 1, d+1,queue);
	}
	
	public static void main(String[] args) {
		String[] a = new String[10];
		a[2] = "a";
		a[5] = "aa";
		a[6] = "aaa";
		a[4] = "aaaa";
		a[3] = "aaaaa";
		a[1] = "aaaaaa";
		a[0] = "aaaaaaa";
		a[9] = "aaaaaaaa";
		a[8] = "aaaaaaaaa";
		a[7] = "aaaaaaaaaa";
		QueueMSD.sort(a);
		for(String s : a)
			System.out.println(s);
	}
}
