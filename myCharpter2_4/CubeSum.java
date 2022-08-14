package myCharpter2_4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class CubeSum implements Comparable<CubeSum> {
	private int sum;
	private int i;
	private int j;
	
	public CubeSum(int i,int j)
	{
		sum = i*i*i+j*j*j;
		this.i = i;
		this.j = j;
	}
	
    public int compareTo(CubeSum that) {
        if (this.sum < that.sum) return -1;
        if (this.sum > that.sum) return +1;
        return 0;
    }

    public String toString() {
        return sum + " = " + i + "^3" + " + " + j + "^3";
    }
    
    public static void main(String[] args) {

    	int n = StdIn.readInt();
        // initialize priority queue
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>(n);
        CubeSum prev = new CubeSum(0,0);
        for (int i = 0; i < n; i++) {
            pq.insert(new CubeSum(i, i));
        }
        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
            if(s.sum==prev.sum) {
            	StdOut.println(prev);
            	StdOut.println(s);	
            }
            if (s.j < n)
                pq.insert(new CubeSum(s.i, s.j + 1));
            prev = s;
        }
    }
}
