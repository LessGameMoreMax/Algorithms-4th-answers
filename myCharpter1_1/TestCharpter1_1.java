package myCharpter1_1;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class TestCharpter1_1 {
	//My solution for print a number to binary -----no negative number
	//1.1.9
	public static void myToBinaryPrint(int num) {
		if(num == 0) return;
		myToBinaryPrint(num/2);
		System.out.print(num%2);	
	}
	//The solution which translating a number to the binary string----no negative number
	public static String bookToBinaryString(int num) {
		String s = "";
		for(int n = num;n>0;n/=2)
			s = (n % 2) + s;//That is terrific,I think it is related to the Stack;
		return s;
	}
	//However command to use the function provided by Java:Integer.toBinaryString(N)-----be used in any conditions
//*******************************************************************************************
	//1.1.13
	//My way to print the transposing array;
	public static void myArrayTransposePrint(int[][] array,int row,int column) {
		for(int j = 0;j < column;j ++) {
			for(int i = 0;i < row;i ++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}
//********************************************************************************************
	//1.1.14
	public static int lg(int N) {
		int num = 0;
		while((1 << num) <= N)
			num++;
		return --num;
	}
//*********************************************************************************************
	//1.1.20
	public static double lnFactorial(int N) {
		if(N==1) return 0;
		return Math.log(N)+lnFactorial(N-1);
	}
//*********************************************************************************************
	//1.1.27
    public static double myBinomial(int N,int k,double p) {
    	int tempN = N;
    	int tempk = k;
    	double child = 1.0;
    	double mother = 1.0;
    	double first = 1.0;
    	double second = 1.0;
    	for(int i = 1;i<=k;i++) 
    		child *= tempN--;
    	for(int i = 1;i<=k;i++)
    		mother *= tempk--;
    	for(int i = 1;i<=k;i++)
    		first *= p;
    	for(int i = 1;i<=(N-k);i++)
    		second *= (1-p);
    	return child/mother*first*second;
    }
//********************************************************************************************
    //1.1.28
    public static int[] deleteRepeat(int[] arrayIn) {
    	int count = 1;
    	for(int i=0,j;i<arrayIn.length;i=j)
    		for(j=i+1;j<arrayIn.length;j++)
    			if(arrayIn[i]!=arrayIn[j]) {
    				count++;
    				break;
    			}
    	int[] arrayOut = new int[count];
    	int sign = 0;
    	for(int i=0,j;i<arrayIn.length;i=j) {
    		arrayOut[sign]=arrayIn[i];
    		for(j=i+1;j<arrayIn.length;j++) {
    			if(arrayIn[i]!=arrayIn[j]) {
    			sign++;
    			break;
    		  }
    		}
    	}
    	return arrayOut;	
    }
//*********************************************************************************************
    //1.1.29
	public static int rank(int key,int[] array) {
		int count;
		for(count =0;count<array.length&&key!=array[count];count++)  continue;
		if(count==array.length&&array[0]>key)       return 0;
		else                                        return count;
	}
	public static int count(int key,int[] array) {
		int count = 0;
		boolean flag = false;
		for(int i=0;i<array.length;i++) 
			if(array[i]==key) {count++; flag = true;}
			else if(array[i]!=key&&flag) break; 
		return count;
	}
//**********************************************************************************************
	//1.1.31
	public static void myRandomLink(int N,double p) {
		StdDraw.setXscale(-2,2);
		StdDraw.setYscale(-2,2);
		StdDraw.setPenRadius(0.02);
		StdDraw.circle(0, 0, 1);
		StdDraw.setPenRadius(0.05);
		for(int i = 0;i<N;i++) 
			StdDraw.point(Math.cos(i*2*Math.PI/N),Math.sin(i*2*Math.PI/N));
		StdDraw.setPenRadius(0.01);
		for(int i = 0;i<N;i++) 
			for(int j = i+1;j<N;j++) 
				if(p >= StdRandom.random())
					StdDraw.line(Math.cos(i*2*Math.PI/N), Math.sin(i*2*Math.PI/N), Math.cos(j*2*Math.PI/N), Math.sin(j*2*Math.PI/N));
	}
//***********************************************************************************************
	public static void main_1_1_32(String[] args) {
		System.out.println("How many numbers do you want to input?");
		int num = StdIn.readInt();
		double[] oriNumber = new double[num];
		System.out.println("Please input numbers:");
		for(int i = 0;i<num;i++) 
	    oriNumber[i] = StdIn.readDouble();
		System.out.println("Please input the number of N:");
		int N = StdIn.readInt();
		System.out.println("Please input the l and r:");
		double l = StdIn.readDouble();
		double r = StdIn.readDouble();
		int[] count = new int[N];
		for(int i = 0;i<N;i++)
			for(int j = 0;j < oriNumber.length;j++) {
				if(oriNumber[j]> l+i*(r-l)/N&&oriNumber[j]<l+(i+1)*(r-l)/N)
					count[i]++;
			}
		for(int i = 0;i<N;i++) {
			double x = 0.1*(i+1)/N;
			double y = count[i]/20.0;
			double rw = 0.05/N;
			double rh = count[i]/20.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}
//****************************************************************************************************
	//1.1.36
	public static void shuffleTest(int M,int N) {
		int[] a = new int[M];
		int[][] count = new int[a.length][a.length];
		for(int k=0;k<N;k++) {		  
		  for(int i = 0;i<a.length;i++)
			a[i]=i;
		  StdRandom.shuffle(a);
		  for(int i = 0;i<a.length;i++)
		  count[i][a[i]]++;
		}
		for(int i = 0;i<a.length;i++) {
			for(int j=0;j<a.length;j++)
				System.out.print(count[i][j]+" ");
			System.out.println();
		}
	}
//*****************************************************************************************************
	//1.1.39
	public static void myRandomMatch(int T) {
		int N = 1000;
		for(int i = 0;i < 4;i++,N*=10) {
			double sum = 0;
			for(int j = 0;j<T;j++) {
				int[] array1 = new int[N];
				int[] array2 = new int[N];
				for(int k = 0;k<N;k++)
					array1[k]=StdRandom.uniform(100000, 1000000);
				for(int k = 0;k<N;k++)
					array2[k]=StdRandom.uniform(100000,1000000);
				for(int k = 0;k<N;k++)
					if(BinarySearch.rank(array1[k], array2) != -1)
						sum++;
			}
			System.out.println(N+" : "+sum/(double)T);
		}
	}
//******************************************************************************************************
}
