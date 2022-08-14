package myCharpter5_1;

public class SublinearSort {
	public static void sort(int[] num) {
		String[] s = new String[num.length];
		toString(s,num);
		sortLSD(s,16);
		insertionSort(s,16);
		toNumber(s,num);
	}
	
	private static void sortLSD(String[] a,int W) {
		int N = a.length;
		int R = 256;
		String[] aux = new String[N];
		
		for(int d = W - 1;d>=0;d--) {
			int[] count = new int[R+1];
			for(int i = 0;i<N;i++)
				count[a[i].charAt(d)+1]++;
			for(int r = 0;r<R;r++)
				count[r+1] += count[r];
			for(int i = 0;i<N;i++)
				aux[count[a[i].charAt(d)]++] = a[i];
			for(int i = 0;i<N;i++)
				a[i] = aux[i];
		}
	}
	
	public static void insertionSort(String[] a,int d) {
		for(int i = 0;i<=a.length-1;i++)
			for(int j = i;j>0&&less(a[j],a[j-1],d);j--)
				exch(a,j,j-1);
	}
	
	private static boolean less(String v,String w,int d)
	{ return v.substring(d).compareTo(w.substring(d)) < 0;}
	
	private static void exch(String[] a,int i,int j) 
	{ String temp = a[i]; a[i] = a[j]; a[j] = temp;} 
	
	private static void toNumber(String[] a,int[] num) {
		for(int i = 0;i<a.length;i++)
			num[i] = Integer.parseInt(a[i]);
	}
	
	private static void toString(String[] a,int[] num) {
		for(int i = 0;i<a.length;i++)
			a[i] = ""+num[i];
	}
}
