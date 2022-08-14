package myCharpter2_5;

import java.util.Comparator;

public class MyPointed2D implements Comparable<MyPointed2D>{
	private double x;
	private double y;
	private double r;
	private double theta;
	private int index;
	
	public MyPointed2D(double x,double y)
	{
		this.x = x;
		this.y = y;
		this.r = Math.pow(x*x+y*y, 0.5);
		this.theta = Math.atan(y/x);
	}
	
	public void setIndex(int index)
	{this.index = index;}
	
	public int getIndex()
	{ return index;}
	
	public double getX()
	{ return x;}
	
	public double getY()
	{ return y;}
	
	public double getR()
	{ return r;}
	
	public double getTheta()
	{ return theta;}
	
	public static int compareX(MyPointed2D v,MyPointed2D w) {
		if(v.getX()<w.getX()) return -1;
		if(v.getX()>w.getX()) return +1;
		return 0;
	}
	
	public static int compareY(MyPointed2D v,MyPointed2D w) {
		if(v.getY()<w.getY()) return -1;
		if(v.getY()>w.getY()) return +1;
		return 0;
	}
	
	public static int compareR(MyPointed2D v,MyPointed2D w) {
		if(v.getR()<w.getR()) return -1;
		if(v.getR()>w.getR()) return +1;
		return 0;
	}
	
	public int compareDis(MyPointed2D that,MyPointed2D third) {
		double dis1X = this.getX()-third.getX();
		double dis1Y = this.getY()-third.getY();
		double dis2X = that.getX()-third.getX();
		double dis2Y = that.getY()-third.getY();
		double dis1 = dis1X*dis1X+dis1Y*dis1Y;
		double dis2 = dis2X*dis2X+dis2Y*dis2Y;
		double minus = dis1 - dis2;
		if(Math.abs(minus)<=10e-5) return 0;
		if(minus<0) return -1;
		return +1;
	}
	
	public int compareAng(MyPointed2D that,MyPointed2D third) {
		double dis1X = this.getX()-third.getX();
		double dis1Y = this.getY()-third.getY();
		double dis2X = that.getX()-third.getX();
		double dis2Y = that.getY()-third.getY();
		double theta1 = Math.atan(dis1Y/dis1X);
		double theta2 = Math.atan(dis2Y/dis2X);
		if(theta1>theta2) return +1;
		if(theta1<theta2) return -1;
		return 0;
	}
	
	public int compareTo(MyPointed2D that)
	{
		if(this.y<that.getY()) return -1;
		if(this.y>that.getY()) return +1;
		if(this.x<that.getX()) return -1; 
		if(this.x>that.getX()) return +1;
		return 0;
	}
	
	public static class AngleOrder implements Comparator<MyPointed2D>
	{
		public int compare(MyPointed2D v,MyPointed2D w) {
			double theta1 = Math.atan(v.getY()/v.getX());
			double theta2 = Math.atan(w.getY()/w.getX());
			if(v.getX()<0&&v.getY()>0) theta1 = Math.PI - theta1;  //’‚¿Ô◊¢“‚∞°£°
			if(w.getX()<0&&w.getY()>0) theta2 = Math.PI - theta2;
			if(theta1>theta2) return +1;
			if(theta1<theta2) return -1;
			return 0;
		}
	}
}
