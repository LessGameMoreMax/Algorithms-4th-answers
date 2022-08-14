package myCharpter1_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import myCharpter1_2.TestCharpter1_2.SmartDate;

public class TestCharpter1_2 {
	//1.2.1
//	public static void main(String[] args) {
//		StdDraw.setXscale(0, 1);
//		StdDraw.setYscale(0, 1);
//		StdDraw.setPenRadius(.01);
//		StdDraw.square(0.5, 0.5, 0.5);
//		StdDraw.setPenRadius(.02);
//		System.out.println("Please input the N:");
//		int N=StdIn.readInt();
//		Point2D[] point = new Point2D[N];
//		for(int i = 0;i<N;i++) {
//			point[i] = new Point2D(StdRandom.random(),StdRandom.random());
//			point[i].draw();
//		}
//		if(N!=1) {
//		double distance = 2;
//		for(int i = 0;i<N-1;i++) 
//			for(int j = i+1;j<N;j++) 
//				if(point[i].distanceTo(point[j])<distance)
//					distance = point[i].distanceTo(point[j]);
//		System.out.println(distance);
//		}
//    }
//********************************************************************************************************
	//1.2.3
//	public static void main(String[] args) {
//		System.out.println("Please input the N:");
//		int N = StdIn.readInt();
//		System.out.println("please input the min:");
//		double min = StdIn.readDouble();
//		System.out.println("please input the max:");
//		double max = StdIn.readDouble();
//		StdDraw.setXscale(0,1.0);
//		StdDraw.setYscale(0,1.0);
//		StdDraw.setPenRadius(.01);
//		Interval2D[] interval = new Interval2D[N];
//		double[] loXNumber = new double[N];
//		double[] hiXNumber = new double[N];
//		double[] loYNumber = new double[N];
//		double[] hiYNumber = new double[N];
//		for(int i=0;i<N;i++) {
//			double lo = StdRandom.uniform(min,max);
//			double hi = StdRandom.uniform(min,max);
//			while(lo>=hi){
//				lo = StdRandom.uniform(min,max);
//				hi = StdRandom.uniform(min,max);
//			}
//			loXNumber[i] = lo;
//			hiXNumber[i] = hi;
//			Interval1D x = new Interval1D(lo,hi);
//			lo = StdRandom.uniform(min,max);
//			hi = StdRandom.uniform(min,max);
//			while(lo>=hi){
//				lo = StdRandom.uniform(min,max);
//				hi = StdRandom.uniform(min,max);
//			}
//			loYNumber[i] = lo;
//			hiYNumber[i] = hi;
//			Interval1D y = new Interval1D(lo,hi);
//			interval[i] = new Interval2D(x,y);
//			interval[i].draw();
//		}
//		int cross = 0;
//		int contain = 0;
//		for(int i = 0;i<N-1;i++) {
//			for(int j = i+1;j<N;j++) {
//				if((loXNumber[i]>=loXNumber[j]&&hiXNumber[i]<=hiXNumber[j]
//					&&loYNumber[i]>=loYNumber[j]&&hiYNumber[i]<=hiYNumber[j])
//					||(loXNumber[j]>=loXNumber[i]&&hiXNumber[j]<=hiXNumber[i]
//						&&loYNumber[j]>=loYNumber[i]&&hiYNumber[j]<=hiYNumber[i]))
//				     contain++;
//				if(interval[i].intersects(interval[j])) cross++;
//			}
//		}
//		System.out.println("cross :"+cross);
//		System.out.println("contain :"+contain);
//    }
//*****************************************************************************************************
	//1.2.6
	public static boolean cirRotation(String s,String t) {
		if((s+s).indexOf(t)==-1)   return false;
		return true;
	}
//******************************************************************************************************
	//1.2.7
	public static String mystery(String s) {
		int N = s.length();
		if(N<=1) return s;
		String a = s.substring(0,N/2);
		String b = s.substring(N/2,N);
		return mystery(b)+mystery(a);
	}
//*******************************************************************************************************
	//1.2.10
	public class VisualCounter
	{
		private int N;
		private int max;
		private int count;
		public VisualCounter() {
			
		}
		public VisualCounter(int max) {
			this.max = max;
		}
		public void add() {
			if(Math.abs(count)<max) {
				count++;
				N = max - count;
				System.out.println("You can add:"+N);
			}
			else
				System.out.println("Sorry,it is full:"+count);
		}
		public void sub() {
			if(Math.abs(count)<max) {
				count--;
				N = max + count;
				System.out.println("You can sub:"+N);
			}
			else
				System.out.println("Sorry,it is out:"+count);
		}
		public int diplay() {
			StdDraw.setXscale(0,1);
			StdDraw.setYscale(0,1);
			StdDraw.setPenRadius(0.01);
			StdDraw.line(0, 0.5, 1, 0.5);
			StdDraw.setPenRadius(0.02);
			if(count>0) {
				StdDraw.setPenColor(StdDraw.RED);
				for(int i=0;i<count;i++)
				StdDraw.point(StdRandom.uniform(0,1.0), StdRandom.uniform(0.55, 1.0));
			}
			else {
				StdDraw.setPenColor(StdDraw.BLUE);
				for(int i=0;i>count;i--)
				StdDraw.point(StdRandom.uniform(0, 1.0), StdRandom.uniform(0, 0.45));
			}
			return count;
		}
	}
//***********************************************************************************************
	//1.2.12
	public static class SmartDate
	{
		private int month;
		private int day;
		private int year;
		public SmartDate() {
			
		}
		public SmartDate(int month, int day,int year) {
			if(year<0) throw new RuntimeException("Year can not be smaller than zero!");
			if(month<=0) throw new RuntimeException("Month must be bigger than zero!");
			if(day<=0) throw new RuntimeException("Day must be bigger than zero!");	
			if(month == 1 || month == 3 || month == 5||month == 7||month == 8||month == 10|| month == 12)
				if(day>31) throw new RuntimeException("Big month's days can't be bigger than 31");
			if(month == 4||month == 6||month==9||month==11)
				if(day>30) throw new RuntimeException("Small month's days can't be bigger than 30");
			if(year % 4 == 0) if(month==2&&day>28) throw new RuntimeException("Leap year's February days can't be bigger than 28");
			else              if(month==2&&day>29) throw new RuntimeException("Not leap year's February month's days can't be bigger than 29");
			this.month = month;
			this.day = day;
			this.year = year;
		}
		public int month() {
			return month;
		}
		public int day() {
			return day;
		}
		public int year() {
			return year;
		}
		public String dayOfTheWeek() {
			if(this.year<2000||this.year>=2100) throw new RuntimeException("Year has to be 21th century");
			int[] chart = {6,2,2,5,0,3,5,1,4,6,2,4};
			if(this.year%4==0) {
				chart[0] = 5;
				chart[1] = 1;
			}
			int a = this.year%2000;
			int b = this.month-1;
			int result = (a+a/4+chart[b]+day)%7;
			switch (result) {
			case 1: return "Monday";
			case 2: return "Tuesday";
			case 3: return "Wednesday";
			case 4: return "Thursday";
			case 5: return "Friday";
			case 6: return "Saturday";
			default: return "Sunday";
			}
		}
		public boolean equals(Object x) {
			if(this==x) return true;
			if(x==null) return false;
			if(this.getClass()!=x.getClass()) return false;
			SmartDate that = (SmartDate) x;
			if(this.day!=that.day) return false;
			if(this.month!=that.month) return false;
			if(this.year!=that.year) return false;
			return true;
		}
		public String toString() {
			return month()+"/"+day()
			        +"/"+year()+" "+dayOfTheWeek();
		}
	}
//********************************************************************************************
	//1.2.13&1.2.14
	class Transaction 
	{
		private String who;
		private SmartDate when;
		private double amount;
		Transaction() {
			
		}
		Transaction(String transaction) {
			String[] str = transaction.split("\\s+");
			this.who = str[0];
			this.when = new SmartDate(Integer.parseInt(str[1]),Integer.parseInt(str[2]),Integer.parseInt(str[3]));
			this.amount = Double.parseDouble(str[4]);
		}
		public String toString() {
			return who+":"+when+" "+amount;
		}
		public boolean equals(Object x) {
			if(this == x) return true;
			if(x == null) return false;
			if(this.getClass()!=x.getClass()) return false;
			Transaction that = (Transaction)x;
			if(!this.who.equals(that.who)) return false;
			if(this.amount!=that.amount) return false;
			if(!this.when.equals(that.when)) return false;
			return true;
		}
	}
//***************************************************************************************************************
	//1.2.15
	public static int[] myReadInts(String name) {
		In in = new In(name);//打开文件输入流
		String input = in.readAll();//读取输入
		String[] strArray = input.split("\\s+");//注意符号写法
		int[] number = new int[strArray.length];
		for(int i =0;i<strArray.length;i++)
		    number[i] = Integer.parseInt(strArray[i]);
		return number;
	}
//*****************************************************************************************************************
	//1.2.16&1.2.17
	class Rational
	{
		private int numerator;
		private int denominator;
		
		Rational(){
			
		}
		
		Rational(int numerator,int denominator){
			int commonFactor = gcd(Math.abs(numerator),Math.abs(denominator));
			if(denominator == 0) throw new RuntimeException("Denominator is not zero!");
			else if(commonFactor == 1||numerator == 0) {
				if(denominator<0) {
					this.numerator = 0-numerator;
					this.denominator = 0-denominator;
				}
				else {
					this.numerator = numerator;
					this.denominator = denominator;
				}
			}  
			else {
				this.numerator = numerator/commonFactor;
				this.denominator = denominator/commonFactor;
			}
		}
		
		public Rational plus(Rational b) {
			if(this.numerator == 0 && b.numerator != 0) return b;
			if(this.numerator == 0 && b.numerator == 0) return this;
			if(this.numerator != 0 && b.numerator == 0) return this;
			int denom = this.denominator * b.denominator;
			int numer = this.numerator * b.denominator + b.numerator * this.denominator;
			int commonFactor = gcd(Math.abs(numer),Math.abs(denom));
			return	new Rational(numer/commonFactor,denom/commonFactor);
		}
		
		public Rational minus(Rational b) {
			if(this.numerator == 0 && b.numerator != 0) return new Rational(0-b.numerator,b.denominator);
			if(this.numerator == 0 && b.numerator == 0) return this;
			if(this.numerator != 0 && b.numerator == 0) return this;
			int denom = this.denominator * b.denominator;
			int numer = this.numerator * b.denominator - b.numerator * this.denominator;
			int commonFactor = gcd(Math.abs(numer),Math.abs(denom));
			return	new Rational(numer/commonFactor,denom/commonFactor);
		}
		
		public Rational times(Rational b) {
			if(this.numerator == 0 || b.numerator == 0) return this;
			int denom = this.denominator * b.denominator;
			int numer = this.numerator * b.numerator;
			int commonFactor = gcd(Math.abs(numer),Math.abs(denom));
			return	new Rational(numer/commonFactor,denom/commonFactor);
		}

		public Rational divides(Rational b) {
			if(this.numerator == 0 && b.numerator != 0) return this;
			if(b.numerator == 0) throw new RuntimeException("0 can not be the divisor");
			int denom = this.denominator * b.numerator;
			int numer = this.numerator * b.denominator;
			if(denom<0) {
				numer = 0-numer;
				denom = 0-denom;
			}
			int commonFactor = gcd(Math.abs(numer),Math.abs(denom));
			return	new Rational(numer/commonFactor,denom/commonFactor);
		}
		
		public boolean equals(Rational that) {
			if(that == null) return false;
			if(this == that) return true;
			if(this.numerator == 0&&that.numerator==0) return true;
			if(this.numerator==that.numerator&&this.denominator==that.denominator) return true;
			return false;
		}
		
		public String toString() {
			if(numerator == 0) return "the number is 0";
			return "numerator is: "+numerator+" denominator is: "+denominator;
		}
		private static int gcd(int p,int q) {
			if(q==0) return p;
			int r = p%q;
			return gcd(q,r);
		}	
	}
//*****************************************************************************************************************
	//1.2.18
	class Accumulator
	{
		private double m;
		private double s;
		private int N;
		public void addDateValue(double x) {
			N++;
			 s = s+1.0*(N-1)/N*(x-m)*(x-m);
			 m = m+(x-m)/N;
			 //注释为答案的实现
//			s +=x * x;
//			m = (m * (N-1) + x) / N;
		}
		public double mean() {
			return m;
		}
		public double var()//计算addDateValue()的方差 
		{
			return s/N;
//			return (s - N * m * m) / N;
		}
		public double stddev()//计算addDateValue()的标准差 
		{
			return Math.sqrt(this.var());
		}
	}
//*******************************************************************************************************************
	//1.2.19
	//提示
	//String[] fields = date.split("/");
	//String[] fields = str[1].spilt("/");
//***********************************************************************************************************************
}
