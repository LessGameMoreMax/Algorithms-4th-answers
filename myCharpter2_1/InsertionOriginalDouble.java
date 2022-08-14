package myCharpter2_1;

public class InsertionOriginalDouble {
	public static void sort(double[] a) {
		int N = a.length;
		for(int i = 1; i < N; i++) 
			for(int j = i;j>=1 && less(a[j],a[j-1]);j--)
				exch(a,j,j-1);
	}
	
	private static void exch(double[] a,int i,int j)
	{ double t = a[i]; a[i] = a[j]; a[j] = t; }
	
	private static boolean less(double v,double w)
	{ return v<w;}
}
