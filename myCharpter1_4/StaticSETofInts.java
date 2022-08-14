package myCharpter1_4;

import java.util.Arrays;

public class StaticSETofInts {
	private int[] a;
	public StaticSETofInts(int[] keys) {
		a = new int[keys.length];
		for(int i=0;i<keys.length;i++)
			a[i] = keys[i];
		Arrays.sort(a);
	}
	public boolean contains(int key)
	{ return rank(key)!=-1;}
	private int rank(int key) {
		int lo = 0;
		int hi = a.length-1;
		while(lo<=hi) {
			int mid = lo+(hi-lo)/2;
			if(key<a[mid]) hi=mid-1;
			else if(key>a[mid]) lo=mid-1;
			else return mid;
		}
		return -1;
	}
	
	public int rankMin(int key) {
		int lo = 0;
		int hi = a.length-1;
		while(lo <= hi) {
			int mid = lo+(hi-lo)/2;
			if(key>a[mid]) lo = mid + 1;
			else if(key < a[mid]) hi = mid-1;
			else {
				int i =0;
				for(i = 1;mid-i>=0&&a[mid-i]==a[mid];i++);
				return mid-i+1;
			}
		}
		return -1;
	}
	
	public int rankMax(int key) {
		int lo = 0;
		int hi = a.length-1;
		while(lo <= hi) {
			int mid = lo+(hi-lo)/2;
			if(key>a[mid]) lo = mid + 1;
			else if(key < a[mid]) hi = mid-1;
			else {
				int i =0;
				for(i = 1;mid+i<a.length&&a[mid+i]==a[mid];i++);
				return mid+i-1;
			}
		}
		return -2;
	}
	
	public int howMany(int key) {
		return rankMax(key)-rankMin(key)+1; 
	}
	
	
}
