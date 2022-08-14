package myCharpter6_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class MyParticle {
	private static final double kb = 1.3806503E-23;
	private double rx;
	private double ry;
	private double vx;
	private double vy;
	private double s;
	private double mass;
	private int count;
	private int sign;
	public MyParticle() {
        rx     = StdRandom.uniform(0.0, 1.0);
        ry     = StdRandom.uniform(0.0, 1.0);
        vx     = StdRandom.uniform(-0.005, 0.005);
        vy     = StdRandom.uniform(-0.005, 0.005);
		s = 0.02;
		mass = 0.5;
	}
	
	public MyParticle(double T) {
		this();
		this.changeV(T);
	}
	
	public MyParticle(int sign) {
		this();
		this.sign = sign;
	}
	
	public int getSign()
	{ return sign;}
	
	public void changeV(double T) {
		double v = Math.sqrt(2 * kb * T / mass);
		vx = StdRandom.uniform(-v,v);
		double x = StdRandom.random();
		double vTemp = Math.sqrt(v * v - vx * vx);
		if(x<0.5) vy = vTemp;
		else      vy = -vTemp;
	}
	
	public void draw() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(rx, ry, s);
	}
	
	public void move(double dt) {
		rx += dt * vx;
		ry += dt * vy;
	}
	
	public int count() 
	{ return count;}
	
	public double timeToHit(MyParticle b) {
		 if(this==b) return Double.POSITIVE_INFINITY;
		 double rxDelta = b.rx - rx;
		 double ryDelta = b.ry - ry;
		 double vxDelta = b.vx - vx;
		 double vyDelta = b.vy - vy;
		 double deltaVR = vxDelta * rxDelta + vyDelta * ryDelta;
		 if(deltaVR>0) return Double.POSITIVE_INFINITY;
		 double deltaVV = vxDelta * vxDelta + vyDelta * vyDelta;
		 if(deltaVV==0) return Double.POSITIVE_INFINITY;
		 double deltaRR = rxDelta * rxDelta + ryDelta * ryDelta;
		 double d = deltaVR * deltaVR - deltaVV * (deltaRR - 4 * s * s);
		 if(d<0) return Double.POSITIVE_INFINITY;
		 return -(deltaVR + Math.sqrt(d))/deltaVV;
	}
	
	public double timeToHitVerticalWall() {
		if(vx == 0) return Double.POSITIVE_INFINITY;
		if(vx > 0) return (1.0 - rx - s)/vx;
		return -(rx - s)/vx;
	}
	
	public double timeToHitHorizontalWall() {
		if(vy == 0) return Double.POSITIVE_INFINITY;
		if(vy > 0) return (1.0 - ry - s)/vy;
		return -(ry - s)/vy;
	}
	
	public void bounceOff(MyParticle b) {
		 double rxDelta = b.rx - rx;
		 double ryDelta = b.ry - ry;
		 double vxDelta = b.vx - vx;
		 double vyDelta = b.vy - vy;
		 double deltaVR = vxDelta * rxDelta + vyDelta * ryDelta;
		 double dist = this.s + b.s;
		 double J = 2 * this.mass * b.mass * deltaVR / ((this.mass + b.mass) * dist);
		 double JX = rxDelta * J / dist;
		 double JY = ryDelta * J / dist;
		 vx += JX / mass;
		 vy += JY / mass;
		 b.vx -= JX / b.mass;
		 b.vy -= JY / b.mass;
	     this.count++;
	     b.count++;
	}
	
	public void bounceOffHorizontalWall() 
	{ vy = -vy; count++;}
	
	public void bounceOffVerticalWall()
	{ vx = -vx; count++;}
	
	public double temperature() 
	{return mass * (vx * vx + vy * vy) / (2 * kb);}
}
