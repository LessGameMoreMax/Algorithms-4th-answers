package myCharpter2_3;

public class QuickBestInput {
	public static int[] best(int N) {
		int[] a = new int[N];
		for(int i = 0;i<N;i++)
			a[i] = i;
		best(a,0,N);
		return a;
	}
	
	private static void best(int[] a,int lo,int hi) {
		if(lo>=hi) return;
		int mid = lo + (hi-lo)/2;
		best(a,lo,mid-1);
		best(a,mid+1,hi);
		exch(a,lo,mid);
	}
	
	private static void exch(int[] a,int v,int w) {
		int temp = a[v];
		a[v] = a[w];
		a[w] = temp;
	}
	
	public static void main(String[] args) {
		int[] a = best(10);
		for(int s:a)
			System.out.print(s+" ");
	}
}
