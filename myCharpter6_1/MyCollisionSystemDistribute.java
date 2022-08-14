package myCharpter6_1;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdDraw;

public class MyCollisionSystemDistribute {
	private class Event implements Comparable<Event>{
		private final double time;
		private final MyParticleDistribute a,b,c;
		private final int countA,countB,countC;
		
		public Event(double t,MyParticleDistribute a,MyParticleDistribute b,MyParticleDistribute c) {
			this.time = t;
			this.a = a;
			this.b = b;
			this.c = c;
			if(a!=null) countA = a.count(); else countA = -1;
			if(b!=null) countB = b.count(); else countB = -1;
			if(c!=null) countC = c.count(); else countC = -1;
		}
		
		public int compareTo(Event that) {
			if(this.time < that.time) return -1;
			else if(this.time > that.time) return +1;
			return 0;
		}
		
		public boolean isValid() {
			if(a!=null&&a.count()!=countA) return false;
			if(b!=null&&b.count()!=countB) return false;
			if(c!=null&&c.count()!=countC) return false;
			return true;
		}
	}
	
	private MinPQ<Event> pq;
	private double t = 0.0;
	private MyParticleDistribute[] particles;
	
	public MyCollisionSystemDistribute(MyParticleDistribute[] particles)
	{ this.particles = particles.clone();}
	
	private void predictCollisions(MyParticleDistribute a,double limit) {
		if(a==null) return;
		for(int i = 0;i<particles.length;i++) {
			double dt = a.timeToHit(particles[i]);
			if(t+dt <= limit)
				pq.insert(new Event(t+dt,a,particles[i],null));
		}
		double dtX = a.timeToHitVerticalWall();
		if(t+dtX <= limit)
			pq.insert(new Event(t+dtX,a,null,null));
		double dtY = a.timeToHitHorizontalWall();
		if(t+dtY <= limit)
			pq.insert(new Event(t+dtY,null,a,null));
		double dtZ = a.timeToHitMiddleWall();
		if(t+dtZ <= limit)
			pq.insert(new Event(t+dtZ,null,null,a));
	}
	
	public void redraw(double limit,double Hz) {
		StdDraw.clear();
		StdDraw.line(0.5, 1.0, 0.5, 0.6);
		StdDraw.line(0.5, 0.0, 0.5, 0.4);
		for(int i = 0;i<particles.length;i++) particles[i].draw();
        StdDraw.show();
        StdDraw.pause(20);
		if(t<limit) pq.insert(new Event(t+1.0/Hz,null,null,null));
	}
	
	public void simulate(double limit,double Hz) {
		pq = new MinPQ<Event>();
		for(int i = 0;i<particles.length;i++)
			predictCollisions(particles[i],limit);
		pq.insert(new Event(0,null,null,null));
		while(!pq.isEmpty()) {
			Event event = pq.delMin();
			if(!event.isValid()) continue;
			if(event.c!=null&&!event.c.isHitMiddleWall()) continue;
			for(int i = 0;i<particles.length;i++)
				particles[i].move(event.time - t);
			t = event.time;
			MyParticleDistribute a = event.a;
			MyParticleDistribute b = event.b;
			MyParticleDistribute c = event.c;
			if(a!=null&&b!=null&&c==null) a.bounceOff(b);
			else if(a!=null&&b==null&&c==null) a.bounceOffVerticalWall();
			else if(a==null&&b!=null&&c==null) b.bounceOffHorizontalWall();
			else if(c!=null) 		  		   c.bounceOffMiddleWall();
			else if(a==null&&b==null&&c==null) redraw(limit,Hz);
			predictCollisions(a,limit);
			predictCollisions(b,limit);
			predictCollisions(c,limit);
		}
	}
	public static void main(String[] args) {
        StdDraw.setCanvasSize(600, 600);

        StdDraw.enableDoubleBuffering();

		StdDraw.show();
		int N = Integer.parseInt(args[0]);
		MyParticleDistribute[] particles = new MyParticleDistribute[N];
		
		for(int i = 0;i<N/2;i++)
			particles[i] = new MyParticleDistribute(true);
		for(int i = N/2;i<N;i++)
			particles[i] = new MyParticleDistribute(false);
		MyCollisionSystemDistribute system = new MyCollisionSystemDistribute(particles);
		system.simulate(10000, 0.5);
	}
}