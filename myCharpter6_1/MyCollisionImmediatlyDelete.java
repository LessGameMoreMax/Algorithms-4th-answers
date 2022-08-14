package myCharpter6_1;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdDraw;

public class MyCollisionImmediatlyDelete {
	private class Event implements Comparable<Event>{
		private final double time;
		private final MyParticle a,b;
		
		public Event(double t,MyParticle a,MyParticle b) {
			this.time = t;
			this.a = a;
			this.b = b;
		}
		
		public int compareTo(Event that) {
			if(this.time < that.time) return -1;
			else if(this.time > that.time) return +1;
			return 0;
		}
	}
	
	private IndexMinPQ<Event> pq;
	private double t = 0.0;
	private MyParticle[] particles;
	
	public MyCollisionImmediatlyDelete(MyParticle[] particles)
	{ this.particles = particles.clone();}
	
	private void predictCollisions(MyParticle a,double limit) {
		if(a==null) return;
		for(int i = 0;i<particles.length;i++) {
			double dt = a.timeToHit(particles[i]);
			if(t+dt <= limit) comparableAndInsert(a,particles[i],t+dt);
		}
		double dtX = a.timeToHitVerticalWall();
		if(t+dtX <= limit) comparableAndInsert(a,null,t+dtX);
		double dtY = a.timeToHitHorizontalWall();
		if(t+dtY <= limit) comparableAndInsert(null,a,t+dtY);
	}
	
	private void comparableAndInsert(MyParticle a,MyParticle b,double time) {
		if(a!=null&&b==null) {
			int index = a.getSign();
			if(pq.contains(index)) {
				if(pq.keyOf(index).time>time) 
					pq.change(index,new Event(time,a,null));	
			}else pq.insert(index, new Event(time,a,null));
		}else if(a==null&&b!=null) {
			int index = b.getSign();
			if(pq.contains(index)) {
				if(pq.keyOf(index).time>time) 
					pq.change(index,new Event(time,null,b));	
			}else pq.insert(index, new Event(time,null,b));
		}else {
			int indexA = a.getSign();
			int indexB = b.getSign();
			if(pq.contains(indexA)&&pq.contains(indexB)) {
				if(pq.keyOf(indexA).time>time&&pq.keyOf(indexB).time>time) {
					pq.change(indexA, new Event(time,a,b));
					pq.change(indexB, new Event(time,b,a));
				}
			}else if(pq.contains(indexA)&&!pq.contains(indexB)){
				if(pq.keyOf(indexA).time>time) {
					pq.change(indexA, new Event(time,a,b));
					pq.insert(indexB, new Event(time,b,a));
				}
			}else if(pq.contains(indexB)&&!pq.contains(indexA)){
				if(pq.keyOf(indexB).time>time) {
					pq.change(indexB, new Event(time,b,a));
					pq.insert(indexA, new Event(time,a,b));
				}
			}
			else if(!pq.contains(indexA)&&!pq.contains(indexB)) {
				pq.insert(indexA, new Event(time,a,b));
				pq.insert(indexB, new Event(time,b,a));
			}
		}
	}
	
	public void redraw(double limit,double Hz) {
		StdDraw.clear();
		for(int i = 0;i<particles.length;i++) particles[i].draw();
        StdDraw.show();
        StdDraw.pause(20);
		if(t<limit) pq.insert(particles.length,new Event(t+1.0/Hz,null,null));
	}
	
	public void simulate(double limit,double Hz) {
		pq = new IndexMinPQ<Event>(particles.length+1);
		for(int i = 0;i<particles.length;i++)
			predictCollisions(particles[i],limit);
		pq.insert(particles.length,new Event(0,null,null));
		while(!pq.isEmpty()) {
			Event event = pq.keyOf(pq.minIndex());
			pq.delMin();
			for(int i = 0;i<particles.length;i++)
				particles[i].move(event.time - t);
			t = event.time;
			MyParticle a = event.a;
			MyParticle b = event.b;
			if(a!=null&&b!=null) 	  a.bounceOff(b);
			else if(a!=null&&b==null) a.bounceOffVerticalWall();
			else if(a==null&&b!=null) b.bounceOffHorizontalWall();
			else if(a==null&&b==null) redraw(limit,Hz);
			deleteAllIndex(a);
			deleteAllIndex(b);
			predictCollisions(a,limit);
			predictCollisions(b,limit);
		}
	}
	
	private void deleteAllIndex(MyParticle a) {
		if(a==null) return;
		for(int i = 0;i<particles.length;i++)
			if(pq.contains(i)&&(pq.keyOf(i).a==a||pq.keyOf(i).b==a)) 
				pq.delete(i);
	}
	
	public static void main(String[] args) {
        StdDraw.setCanvasSize(600, 600);

        StdDraw.enableDoubleBuffering();

		StdDraw.show();
		int N = Integer.parseInt(args[0]);
		MyParticle[] particles = new MyParticle[N];
		
		for(int i = 0;i<N;i++)
			particles[i] = new MyParticle(i);
		MyCollisionImmediatlyDelete system = new MyCollisionImmediatlyDelete(particles);
		system.simulate(10000, 0.5);
	}
}

