package myCharpter2_5;

import java.io.File;
import java.util.Comparator;

import algs4_test.TestProcess;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import myCharpter2_3.QuickSortComparator;

public class TestCharpter2_5 {
//2.5.2
//	public static class StringLength implements Comparator<String>
//	{
//		public int compare(String v,String w)
//		{ return v.length()-w.length();}
//	}
//	
//	public static class LengthComparable implements Comparator<Integer>
//	{
//		public int compare(Integer v,Integer w)
//		{ return (int)v-(int)w;}
//	}
//	
//	private static boolean equal(Comparator c,Comparable v,Comparable w) {
//		return c.compare(v, w)==0;
//	}
//	
//	private static boolean less(Comparator c,Comparable v,Comparable w) {
//		return c.compare(v, w)<0;
//	}
//	
//	public static void main(String[] args) {
//		System.out.println("How many words would you like to input?");
//		int number = StdIn.readInt();
//		String[] words = new String[number];
//		System.out.println("please input:");
//		for(int i = 0;i <number;i++)
//			words[i] = StdIn.readString();
//		QuickSortComparator.sort(words, new TestProcess.StringLength());
//		if(words.length<=2) throw new RuntimeException("Sorry,it is illegal!");
//		
//		int i = 2;
//		while(words[i].length()<words[0].length()*2) {
//			i++;
//			if(i>=words.length) throw new RuntimeException("Sorry,it do not exist!");
//		}
//		
//		while(i<words.length)
//		{
//			for(int j = 0;j<(i-1);j++)
//			{
//				int len = words[i].length()-words[j].length();
//				int lo = j+1;
//				int hi = i-1;
//				while(lo<hi)
//				{
//					int mid = lo + (hi-lo)/2;
//					if(less(new LengthComparable(),words[mid].length(),len)) lo = mid+1;
//					else if(less(new LengthComparable(),len,words[mid].length())) hi = mid-1;
//					else if(equal(new LengthComparable(),len,words[mid].length())) break;
//				}
//				if(lo>hi) continue;
//				int mid = lo + (hi-lo)/2;
//				for(int temp = mid-1;temp>j&&equal(new LengthComparable(),words[temp].length(),len);temp--)
//				{
//					if(words[i].equals(words[j].concat(words[temp]))||words[i].equals(words[temp].concat(words[j])))
//						System.out.println(words[i]);
//				}
//				while(mid<i&&equal(new LengthComparable(),words[mid].length(),len))
//				{
//					if(words[i].equals(words[mid].concat(words[j]))||words[i].equals(words[j].concat(words[mid])))
//						System.out.println(words[i]);
//					mid++;
//				}
//			}
//			i++;
//		}
//	}
//	
//**********************************************************************************************************************
	//2.5.4
	public static String[] dedup(String[] a)
	{
		MinPQ<String> pq = new MinPQ<String>(a.length);
		Queue<String> temp = new Queue<String>();
		for(int i = 0;i<a.length;i++)
			pq.insert(a[i]);
		String prev = pq.delMin();
		temp.enqueue(prev);
		while(!pq.isEmpty()) {
			String str = pq.delMin();
			if(!str.equals(prev)) temp.enqueue(str);
			prev = str; 
		}
		String[] aNew = new String[temp.size()];
		for(int i = 0;i<aNew.length;i++)
			aNew[i] = temp.dequeue();
		return aNew;
	}
//***********************************************************************************************************************
	//2.5.6
//	public static Comparable select(Comparable[] a,int k)
//	{
//		StdRandom.shuffle(a);
//		select(a,--k,0,a.length-1,false);
//		return a[k];
//	}
//	
//	public static boolean select(Comparable[] a,int k,int lo,int hi,boolean flag){
//		if(hi<=lo) return false;
//		int j = partition(a,lo,hi);
//		if(j==k)   return true;
//		flag = select(a,k,lo,j-1,flag);
//		if(flag)   return true;
//		flag = select(a,k,j+1,hi,flag);
//		if(flag)   return true;
//		else       return false;
//	}
//	
//	
//	private static int partition(Comparable[] a,int lo,int hi)
//	{
//		int i = lo;
//		int j = hi+1;
//		Comparable v = a[lo];
//		while(true)
//		{
//			while(less(a[++i],v)) if(i==hi) break;
//			while(less(v,a[--j]));
//			if(i>=j) break;
//			exch(a,i,j);
//		}
//		exch(a,lo,j);
//		return j;
//	}
//	
//	private static boolean less(Comparable v,Comparable w)
//	{ return v.compareTo(w)<0;}
//	
//	private static void exch(Comparable[] a,int i,int j)
//	{
//		Comparable temp = a[i];
//		a[i] = a[j];
//		a[j] = temp;
//	}
//***********************************************************************************************************************
	//2.5.12
//	public static void main(String[] args)
//	{
//		System.out.println("How many projects would you like to input?");
//		int N = StdIn.readInt();
//		System.out.println("Now it is time for you to show:");
//		SPT[] spt = new SPT[N];
//		for(int i = 0;i<N;i++) 
//			spt[i] = new SPT(StdIn.readString(),StdIn.readDouble());
//		Quick.sort(spt);
//		for(SPT s:spt) System.out.println(s);
//	}
//************************************************************************************************************************
	//2.5.17
//	public static void main(String[] args) {
//		System.out.println("Please input the way to sort:");
//		String sort = StdIn.readString();
//		System.out.println("Loading.....");
//		Integer[] a = {6,4,5,8,2,3,5,4,8,7,2,6,3,4,3,4,6};
//		if(check(a,sort)) System.out.println(sort+" is stable!");
//		else 			  System.out.println(sort+" is not stable!");
//	}
	
	public static boolean check(Comparable[] a,String sort)
	{
		CheckIndex[] check = new CheckIndex[a.length];
		for(int i = 0;i<a.length;i++)
			check[i] = new CheckIndex(i,a[i]);
//		if(sort.equals("Quick"))     Quick.sort(check);
//		if(sort.equals("Insertion")) Insertion.sort(check);
		Comparable prevKey = check[0].checkKey();
		int prevIndex = check[0].checkIndex();
		for(int i = 1;i<check.length;i++) {
			Comparable key = check[i].checkKey();
			int index = check[i].checkIndex();
			if(key.compareTo(prevKey)==0&&prevIndex>index) return false;
			prevKey = key;
			prevIndex = index;
		}
		return true;
	}
//*******************************************************************************************************************
	//2.5.18
//	public static void main(String[] args)
//	{
//		Integer[] a = { 5,6,2,3,4,6,7,2,3,5,4,6,7,2,3,5};
//		if(check(a)) System.out.println("TRUE");
//		else		 System.out.println("FALSE");
//		for(Integer s : a)
//			System.out.print(s+" ");
//	}
//	
//	public static void stableSort(Comparable[] a)
//	{
//		CheckIndex[] check = new CheckIndex[a.length];
//		for(int i = 0;i<a.length;i++)
//			check[i] = new CheckIndex(i,a[i]);
//		indexSort(check,0,check.length-1,new CheckIndex.KeyOrder());
//
//		Comparable prevKey = check[0].checkKey();
//		int prevIndex = check[0].checkIndex();
//		int lo = 0;
//		int hi = 0;
//		for(int i = 1;i<check.length;i++) {
//			Comparable key = check[i].checkKey();
//			int index = check[i].checkIndex();
//			if(key.compareTo(prevKey)==0) {
//				hi++;
//			}else {
//				if(lo<hi)
//				indexSort(check,lo,hi,new CheckIndex.IndexOrder());
//				lo = i;
//				hi = i;
//			}
//			prevKey = key;
//			prevIndex = index;
//		}
//		indexSort(check,lo,hi-1,new CheckIndex.IndexOrder());
//		for(int i = 0;i<check.length;i++)
//			a[i] = check[i].checkKey();
//	}
//	
//	private static void indexSort(Object[] a,int lo,int hi,Comparator c)
//	{
//		if(hi<=lo) return;
//		int lt = lo;
//		int i = lo + 1;
//		int gt = hi;
//		Object v = a[lo];
//		while(i<=gt)
//		{
//			int cmp = c.compare(a[i], v);
//			if(cmp<0) checkExch(a,lt++,i++);
//			else if(cmp>0) checkExch(a,i,gt--);
//			else i++;
//		}
//		indexSort(a,lo,lt-1,c);
//		indexSort(a,gt+1,hi,c);
//	}
//	
//	private static void checkExch(Object[] a,int i,int j)
//	{
//		Object temp = a[i];
//		a[i] = a[j];
//		a[j] = temp;
//	}
//	
//	private static boolean check(Comparable[] a)
//	{
//		CheckIndex[] check = new CheckIndex[a.length];
//		for(int i = 0;i<a.length;i++)
//			check[i] = new CheckIndex(i,a[i]);
//		stableSort(a);
//		Comparable prevKey = check[0].checkKey();
//		int prevIndex = check[0].checkIndex();
//		for(int i = 1;i<check.length;i++) {
//			Comparable key = check[i].checkKey();
//			int index = check[i].checkIndex();
//			if(key.compareTo(prevKey)==0&&prevIndex>index) return false;
//			prevKey = key;
//			prevIndex = index;
//		}
//		return true;
//	}
//*********************************************************************************************************************
	//2.5.26
//	public static void main(String[] args) {
//		System.out.println("How many point do you want to input?");
//		int N = StdIn.readInt();
//		MyPointed2D[] points = new MyPointed2D[N]; 
//		System.out.println("Now please input:");
//		for(int i = 0;i<N;i++)
//			points[i] = new MyPointed2D(StdIn.readDouble(),StdIn.readDouble());
//		polygonShow(points);
//	}
	
	public static void polygonShow(MyPointed2D[] points)
	{
		StdDraw.setXscale(0,10);
		StdDraw.setYscale(0,10);
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.setPenRadius(.02);
		for(int i = 0;i<points.length;i++)
			StdDraw.point(points[i].getX(),points[i].getY());
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setPenRadius(.01);
		Quick.sort(points);
		MyPointed2D p = points[0];
		MyPointed2D[] newPoint = new MyPointed2D[points.length-1];
		MyPointed2D[] oriPoint = new MyPointed2D[points.length-1];
		for(int i = 1;i<points.length;i++)
		{
			newPoint[i-1] = new MyPointed2D(points[i].getX()-p.getX(),points[i].getY()-p.getY());
			oriPoint[i-1] = new MyPointed2D(points[i].getX(),points[i].getY());
		}
		for(int i = 0;i<oriPoint.length;i++) {
			newPoint[i].setIndex(i);
			oriPoint[i].setIndex(i);
		}
		QuickSortComparator.sort(newPoint, new MyPointed2D.AngleOrder());	
		StdDraw.line(p.getX(), p.getY(), oriPoint[newPoint[0].getIndex()].getX(),oriPoint[newPoint[0].getIndex()].getY());
		for(int i = 1;i<oriPoint.length;i++)
			StdDraw.line(oriPoint[newPoint[i-1].getIndex()].getX(), oriPoint[newPoint[i-1].getIndex()].getY(), oriPoint[newPoint[i].getIndex()].getX(),oriPoint[newPoint[i].getIndex()].getY());
		StdDraw.line(p.getX(), p.getY(), oriPoint[newPoint[newPoint.length-1].getIndex()].getX(),oriPoint[newPoint[newPoint.length-1].getIndex()].getY());
	}
//********************************************************************************************************************************************************
	//2.5.28
//	public static void main(String[] args)
//	{
//		System.out.println("Please input the file name:");
//		MinPQ<String> list = new MinPQ<String>();
//		openFile(list,StdIn.readString());
//		for(String s:list) System.out.println(s);
//	}
	//使用递归
	public static void openFile(MinPQ<String> list,String fileName) {
		File file = new File(fileName);
		if(!file.isDirectory()) {
			list.insert(file.getName());
			return;
		}
		String[] str = file.list();
		for(int i = 0;i<str.length;i++)
			openFile(list,fileName+"/"+str[i]);    //注意此处
	}
//******************************************************************************************************************************************************
}
