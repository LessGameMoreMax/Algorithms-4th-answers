package myCharpter5_1;

public class LinearListQuick3String {
	private static int charAt(String s,int d)
	{ if(d<s.length()) return s.charAt(d); else return -1;}
	
	public static void sort(LinearList L) {
		String[] a = new String[L.size()];
		int index = 0;
		for(String s : L.allString())
			a[index++] = s;
		sort(a,0,a.length-1,0);
		L.change(a);
	}
	
	private static void sort(String[] a,int lo,int hi,int d) {
		if(hi<=lo) return;
		int lt = lo;
		int gt = hi;
		int v = charAt(a[lo],d);
		int i = lo+1;
		while(i<=gt) {
			int t = charAt(a[i],d);
			if(t<v) exch(a,lt++,i++);
			else if(t>v) exch(a,i,gt--);
			else i++;
		}
		
		sort(a,lo,lt-1,d);
		if(v>=0) sort(a,lt,gt,d+1);
		sort(a,gt+1,hi,d);
	}
	
	private static void exch(String[] a,int v,int w)
	{ String temp = a[v]; a[v] = a[w]; a[w] = temp;}
	
	public static void main(String[] args) {
		LinearList L = new LinearList();
		L.add("a");
		L.add("suh");
		L.add("aaaaa");
		L.add("aaa");
		L.add("tdiug");
		L.add("aa");
		L.add("aaaaaa");
		L.add("dhgrui");
		L.add("vn");
		L.add("aqds");
		LinearListQuick3String.sort(L);
		for(String s : L.allString())
			System.out.println(s);
	}
}
