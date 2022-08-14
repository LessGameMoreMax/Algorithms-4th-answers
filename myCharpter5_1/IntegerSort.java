package myCharpter5_1;

public class IntegerSort {
	private static int charAt(String s,int d)
	{ if(d<s.length()) return s.charAt(s.length()-d-1); else return -1;}
	
	public static void sort(int[] num) {
		int maxIndex = 0;
		String[] a = new String[num.length];
		for(int i = 0;i<num.length;i++) {
			a[i] = "" + num[i];
			maxIndex = Math.max(maxIndex, a[i].length());
		}
			
		sort(a,0,a.length-1,maxIndex-1);
		for(int i = 0;i<num.length;i++)
			num[i] = Integer.parseInt(a[i]);
	}
	private static void sort(String[] a,int lo,int hi,int d) {
		if(hi<=lo) return;
		int lt = lo;
		int gt = hi;
		int v = charAt(a[lo],d);
		int i = lo + 1;
		while(i<=gt) {
			int t = charAt(a[i],d);
			if(t<v) exch(a,lt++,i++);
			else if(t>v) exch(a,i,gt--);
			else 	i++;
		}
		
		sort(a,lo,lt-1,d);
		sort(a,lt,gt,d-1);
		sort(a,gt+1,hi,d);
	}
	
	private static void exch(String[] a,int v,int w)
	{ String temp = a[v]; a[v] = a[w]; a[w] = temp;} 
	
	public static void main(String[] args) {
		int[] a = {24,768,9,6,51,56,645,2,99,20,64};
		IntegerSort.sort(a);
		for(int s : a)
			System.out.println(s);
	}
}
