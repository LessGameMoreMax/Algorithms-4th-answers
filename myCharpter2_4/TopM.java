package myCharpter2_4;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.StdIn;

public class TopM {
	private class Coordinate implements Comparable<Coordinate>{
		int x;
		int y;
		int z;
		int distance;
		public Coordinate(int x,int y,int z) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.distance = x*x+y*y+z*z;
		}
		
	    public int compareTo(Coordinate that) {
	        if (this.distance < that.distance) return -1;
	        if (this.distance > that.distance) return +1;
	        return 0;
	    }
	    
	    public String toString() {
	        return  x + " " + y + " " + z;
	    }
	}

	
	
	public static void main(String[] args)
	{
		System.out.println("Please input the number:");
		int M = StdIn.readInt();
		MaxPQ<Coordinate> test = new MaxPQ<Coordinate>(M);
		System.out.println("How many do you want to input?");
		int k = StdIn.readInt();
		System.out.println("Please input your coordinate:");
		for(int i = 0;i<k;i++) {
			int x = StdIn.readInt();
			int y = StdIn.readInt();
			int z = StdIn.readInt();
			TopM a = new TopM();
			Coordinate input = a.new Coordinate(x,y,z);
			if(test.size()<M)
			test.insert(input);
			else {
				Coordinate output = test.delMax();
				if(input.compareTo(output)<0)
					test.insert(input);
				else
					test.insert(output);
			}
		}
		System.out.println("Now the min distance is below:");
		while(!test.isEmpty())
			System.out.println(test.delMax());
	}
}
