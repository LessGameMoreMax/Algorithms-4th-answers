package myCharpter2_5;

public class KendallTau {
	public static int count(int[] v,int[] w) {
		if(v.length!=w.length) throw new RuntimeException("Sorry,it is wrong!");
		int[] ainv = new int[v.length];
		for(int i = 0;i<v.length;i++)
			ainv[v[i]] = i;
		int[] newW = new int[v.length];
		for(int i = 0;i<v.length;i++)
			newW[i] = ainv[w[i]];
		return officialCount(newW);
	}
	
	private static int officialCount(int[] a)
	{
		int number = 0;
		int N = a.length;
		for(int i = 1; i < N; i++) 
			for(int j = i;j>=1 && less(a[j],a[j-1]);j--)
			{
				exch(a,j,j-1);
				number++;
			}
		return number;
	}
	private static void exch(int[] a,int i,int j)
	{ int t = a[i]; a[i] = a[j]; a[j] = t; }
	
	private static boolean less(int v,int w)
	{ return v<w;}
	
	
}
