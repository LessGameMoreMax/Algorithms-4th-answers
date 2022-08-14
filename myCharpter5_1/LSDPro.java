package myCharpter5_1;

public class LSDPro {
	private static int charAt(String s,int d){
		int num = s.length() - d - 1;
		if(num<0) return -1;
		return s.charAt(d);
	}
	
	public static void sort(String[] a) {
		int N = a.length;
		int R = 256;
		String[] aux = new String[N];
		int W = 0;
		for(int i = 0;i<a.length;i++)
			W = Math.max(W, a[i].length());
		for(int d = W-1;d>=0;d--) {
			int[] count = new int[R+2];
			for(int i = 0;i<N;i++)
				count[charAt(a[i],d)+2]++;
			for(int r = 0;r<R;r++)
				count[r+1] += count[r];
			for(int i = 0;i<N;i++)
				aux[count[charAt(a[i],d)+1]++] = a[i];
			for(int i = 0;i<N;i++)
				a[i] = aux[i];
		}
	}

	
	public static void main(String[] args) {
		String[] a = new String[10];
		a[6] = "a";
		a[5] = "h";
		a[1] = "h";
		a[9] = "h";
		a[4] = "a";
		a[3] = "o";
		a[2] = "o";
		a[0] = "o";
		a[7] = "a";
		a[8] = "a";
		LSDPro.sort(a);
		for(String s : a)
			System.out.println(s);
	}
}
