package myCharpter4_4;

public class Maxtrix {
	private int N;
	private int[][] maxtrix;
	
	public Maxtrix(int N) {
		this.N = N;
		maxtrix = new int[N][N];
	}
	
	public int get(int h,int l) {
		if(h<0||l<0||h>=N||l>=N) return 0;
		return maxtrix[h][l];
	}
	
	public int size()
	{ return N;}
	
	public void add(int h,int l,int number) {
		if(h<0||l<0||h>=N||l>=N) return;
		maxtrix[h][l] = number;
	}
}
