package myCharpter5_1;

import edu.princeton.cs.algs4.StdRandom;

public class RandomString {
	public static String[] randomDecimalKeys(int N,int W) {
		String[] a = new String[N];
		for(int i = 0;i<N;i++) {
			String s = "0.";
			int j = 0;
			while(j<W) {
				int r = StdRandom.uniform(10);
				if(j==W-1&&r==0) continue;
				s += r;
				j++;
			}
			a[i] = s;
		}
		return a;
	}
	
	public static String[] randomPlatesCA(int N,int W) {
		String[] a = new String[N];
		for(int i = 0;i<N;i++) {
			String s = "";
			for(int j = 0;j<W;j++) 
				s += randomChar();
			a[i] = s;
		}
		return a;
	}
	
	public static String[] randomFixedLengthWords(int N,int W) {
		String[] a = new String[N];
		for(int i = 0;i<N;i++) {
			String s = "";
			for(int j = 0;j<W;j++) 
				s += randomWord();
			a[i] = s;
		}
		return a;
	}
	
	public static String[] randomItems(int N) {
		String[] a = new String[N];
		String[] first = randomPlatesCA(10,StdRandom.uniform(3,6));
		String[] second = randomPlatesCA(50,StdRandom.uniform(3,6));
		String[] third = randomPlatesCA(2,StdRandom.uniform(3,6));
		String[] forth = randomLength(N,4,15);
		for(int i = 0;i<N;i++) {
			String s = "";
			for(int j = 0; j < 4; j++) s += randomGetFromString(first); 
			for(int k = 0; k < 10; k++) s += randomGetFromString(second); 
			s += randomGetFromString(third);
			s += forth[i];
			a[i] = s;
		}
		return a;
	}
	
	private static char randomGetFromString(String[] a) {
		int N = a.length;
		int W = a[0].length();
		return a[StdRandom.uniform(N)].charAt(StdRandom.uniform(W));
	}
	
	private static String[] randomLength(int N,int lo,int hi) {
		String[] a = new String[N];
		for(int i = 0;i<N;i++) {
			int W = StdRandom.uniform(lo,hi+1);
			String s = "";
			for(int j = 0;j<W;j++) 
				s += randomChar();
			a[i] = s;
		}
		return a;
	}
	
	private static char randomChar() {
		int num = 60;
		while((num>=58&&num<=64)||(num>=91&&num<=96))
			num = StdRandom.uniform(48,123);
		return (char)num;
	}
	
	private static char randomWord() {
		int num = 94;
		while(num>=91&&num<=96)
			num = StdRandom.uniform(65,123);
		return (char)num;
	}
}
