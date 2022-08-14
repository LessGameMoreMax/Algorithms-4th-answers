package myCharpter2_5;


public class InsertionIndex {
		public static void sort(Comparable[] a) {
			int N = a.length;
			for(int i = 1; i < N; i++) 
				for(int j = i;j>=1 && less(a[j],a[j-1]);j--)
					exch(a,j,j-1);
		}
		
		public static int[] indirectSort(Comparable[] a) {
			Comparable[] temp = new Comparable[a.length];
			int[] index = new int[a.length];
			for(int i = 0;i<a.length;i++) {
				temp[i] = a[i];
				index[i] = i;
			}
			int N = temp.length;
			for(int i = 1; i < N; i++) 
				for(int j = i;j>=1 && less(temp[j],temp[j-1]);j--)
				{
					exch(temp,j,j-1);
					exchIndex(index,j,j-1);
				}
			return index;
		}
		
		private static void exch(Comparable[] a,int i,int j)
		{ Comparable t = a[i]; a[i] = a[j]; a[j] = t; }
		
		private static void exchIndex(int[] a,int i,int j)
		{ int t = a[i]; a[i] = a[j]; a[j] = t; }
		
		private static boolean less(Comparable v,Comparable w)
		{ return v.compareTo(w) < 0;}
		
		public static void main(String[] args) {
			Integer[] a = {2,6,3,7,5,4,6,7};
			int index[] = indirectSort(a);
			for(int s:index) System.out.print(s+" ");
		}
}
