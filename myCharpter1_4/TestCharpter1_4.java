package myCharpter1_4;

import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdRandom;

public class TestCharpter1_4 {
//************************************************************************************
	//1.4.2
	public static int threeSumCount(int[] a) {
		int N = a.length;
		int cut = 0;
		for(int i = 0;i<N-2;i++) {
			for(int j = i+1;j<N-1;j++) {
				for(int k =j+1;k<N;k++) {
					if((long)a[i]+(long)a[j]+(long)a[k]==0)
						cut++;
				}
			}
		}
		return cut;
	}
//************************************************************************************
	//1.4.8
	public static int equalTwo(int[] arr) {
		int sum = 0;
		Arrays.sort(arr);
		int j = 0;
		for(int i = 0;i < arr.length-1;i += j) {
			j = 1;
			while(i+j<arr.length&&arr[i] == arr[i+j]) 
				j++;
			sum += j*(j-1)/2;
		}
		return sum;
	}
//**************************************************************************************
	//1.4.10
	public static int rankMin(int key,int[] array) {
		int lo = 0;
		int hi = array.length-1;
		while(lo <= hi) {
			int mid = lo+(hi-lo)/2;
			if(key>array[mid]) lo = mid + 1;
			else if(key < array[mid]) hi = mid-1;
			else {
				int i =0;
				for(i = 1;mid-i>=0&&array[mid-i]==array[mid];i++);
				return mid-i+1;
			}
		}
		return -1;
	}
//**************************************************************************************
	//1.4.12
	//version 1.0
	public static void searchSame(int[] a,int[] b) {
		for(int i = 0;i<a.length;) {
			if(BinarySearch.rank(a[i], b)!=-1) 
				System.out.printf("%4d",a[i]);
			i++;
			while(i<a.length&&a[i-1]==a[i])
				i++;
		}
	}
	
	//version 2.0
//	public static void searchSame(int[] a,int[] b) {
//		for(int i = 0;i<a.length;i++) {
//			if(BinarySearch.rank(a[i], b)!=-1) 
//				System.out.printf("%4d",a[i]);
//			i = rankMax(a[i],a);
//		}
//	}
//	
//	public static int rankMax(int key,int[] a) {
//		int lo = 0;
//		int hi = a.length-1;
//		while(lo <= hi) {
//			int mid = lo+(hi-lo)/2;
//			if(key>a[mid]) lo = mid + 1;
//			else if(key < a[mid]) hi = mid-1;
//			else {
//				int i =0;
//				for(i = 1;mid+i<a.length&&a[mid+i]==a[mid];i++);
//				return mid+i-1;
//			}
//		}
//		return -2;
//	}
//***************************************************************************************
	//1.4.14
	//各个数不相等，记住要排序
	public static int sumFour(int[] a) {
		int sum =0;
		Arrays.sort(a);
		for(int i = 0;i<a.length-2;i++) {
			for(int j = i+1;j<a.length-1;j++) {
				for(int k = j + 1;k<a.length;k++) 
					if(BinarySearch.rank(-(a[i]+a[j]+a[k]), a)>k)
							sum++;
			}
		}
		return sum;
	}
//****************************************************************************************
	//1.4.15
	public static int threeSumFaster(int[] a) {
//		Arrays.sort(a);
		int lo = 0;
		int hi = a.length-1;
		int sum = 0;
		while(a[lo]<0) {
			int i = hi;
			while(a[i]>0) {
				int index = BinarySearch.rank(-a[lo]-a[i], a);
				if(index<i&&index>lo)
					sum++;
				i--;
			}
			lo++;
		}
		return sum;
	}
	
	public static int twoSumFaster(int[] a) {
		//Arrays.sort(a);
		int lo = 0;
		int hi = a.length-1;
		int sum = 0;
		while(a[lo]<0&&a[hi]>0) {
			if(-a[lo]>a[hi])
				lo++;
			else if(-a[lo]<a[hi])
				hi--;
			else {
				sum++;
				lo++;
				hi--;
			}	
		}
		return sum;
	}
//****************************************************************************************
	//1.4.16
	public static double nearPare(double[] a) {
		Arrays.sort(a);
		double result = a[1]-a[0];
		for(int i = 1;i<a.length-1;i++) {
			double re = a[i+1]-a[i];
			if(re<result)
				result = re;
		}
		return result;
	}
//****************************************************************************************
	//1.4.17
	public static double farPare(double a[]) {
		Arrays.sort(a);
		return a[a.length-1]-a[0];
	}
//******************************************************************************************
	//1.4.18
	public static int smallPart(int[] a,int lo,int hi) {
		if(hi-lo<2) return -1;
		int mid = lo + (hi-lo)/2;
		if(a[mid]<a[mid+1]&&a[mid]<a[mid-1]) return mid;
		int left = smallPart(a,lo,mid);
		if(left==-1) {
			int right = smallPart(a,mid,hi);
			return right;
		}
		return left;
	}
//********************************************************************************************
	//1.4.19
	//分治法
	public static boolean matrixSmall(int[][] a,int sky,int ground,int left,int right) {
		if(ground-sky<2||right-left<2) return false;
		int midWidth = left + (right-left)/2;
		int midVector = sky + (ground-sky)/2;
		if(a[midWidth][midVector]<a[midWidth+1][midVector]&&a[midWidth][midVector]<a[midWidth-1][midVector]
			&&a[midWidth][midVector]<a[midWidth][midVector+1]&&a[midWidth][midVector]<a[midWidth][midVector-1]) {
			System.out.printf("%4d  %4d\n",midWidth,midVector);
			return true;
		}
		boolean leftWidth = matrixSmall(a,sky,ground,left,midWidth);
		if(leftWidth)  return true;;
		boolean rightWidth = matrixSmall(a,sky,ground,midWidth,right);
		if(rightWidth) return true;
		boolean skyVector = matrixSmall(a,sky,midVector,left,right);
		if(skyVector) return true;
		boolean groundVector = matrixSmall(a,midVector,ground,left,right);
		if(groundVector) return true;
		return false;
	}
//**********************************************************************************************
	//1.4.20
	public static boolean biontalSearch(int key,int[] a) {
		int lo = 0;
		int hi = a.length-1;
		int MAX = 0;
		while(true) {
			int mid = lo + (hi-lo)/2;
			if(a[mid]>a[mid+1]&&a[mid]>a[mid-1]) {
				MAX = mid;
				break;
			}
			else if(a[mid]>a[mid+1]&&a[mid]<a[mid-1]) hi = mid -1;
			else if(a[mid]<a[mid+1]&&a[mid]>a[mid-1]) lo = mid +1;
		}
		
		int loLeft = 0;
		int hiLeft = MAX;
		while(loLeft<=hiLeft) {				//注意条件
			int midLeft = loLeft + (hiLeft-loLeft)/2;
			if(a[midLeft]>key)         hiLeft = midLeft -1;
			else if(a[midLeft]<key)    loLeft = midLeft +1;
			else return true;
		}
		
		int loRight = MAX;
		int hiRight = a.length-1;
		while(loRight<=hiRight) {
			int midRight = loRight + (hiRight-loRight)/2;
			if(a[midRight]>key)         loRight = midRight +1;
			else if(a[midRight]<key)    hiRight = midRight -1;
			else return true;
		}
		return false;
	}
//****************************************************************************************************
	//1.4.22
	public static int rankMihaiPatrascu(int key,int[] a) {
		int fT = 0;
		int fS = 0;
		int fF = 0;
		for(int i = 2;Fobnacci(i)<=a.length-1;i++) {
			fT = Fobnacci(i);
			fS = Fobnacci(i-1);
		}
		if(a[fT]==key)  return fT;
		if(a[fT]<key) return fT+1+rankMihaiPatrascu(key,Arrays.copyOfRange(a, fT+1,a.length));//注意此方法的使用
		int lo = 0;
		int hi = fT;
		while(lo<=hi) {
			fF = fT - fS;
			int seek = fF + lo;
			if(a[seek]>key)      hi = seek;
			else if(a[seek]<key) lo = seek;
			else return seek;
			fT = fS;
			fS = fF;
		}
		return -1;
	}
	public static int Fobnacci(int N) {
		if(N==1||N==2) return 1;
		return Fobnacci(N-1)+Fobnacci(N-2);
	}
//******************************************************************************************************************
	//1.4.23
	public static int rankDouble(double key,double[] a) {
		Arrays.sort(a);
		int lo = 0;
		int hi = a.length-1;
		while(lo<=hi) {
			int mid = lo+(hi-lo)/2;
			if(key<a[mid]) hi = mid - 1;
			else if(key>a[mid]) lo = mid+1;
			else return mid;
		}
		return -1;
	}
//***************************************************************************************************************
	//1.4.24&1.4.25
	//动态规划DP
	//扔鸡蛋策略
//***************************************************************************************************************
	//1.4.34
	public static boolean hotOrCold(int key,int lo,int hi,int disPre,int num) {
		int mid = lo+(hi-lo)/2;
		System.out.println(num);
		if(key==mid||lo==key||hi==key) return true;
		if(Math.abs(mid-key)==Math.abs(disPre-key)) return true;
		if(Math.abs(mid-key)>Math.abs(disPre-key)) return hotOrCold(key,disPre+(disPre-mid)/2,hi-1,mid,num+1);
		else return hotOrCold(key,lo+1,disPre+(disPre-mid)/2,mid,num+1);
	}
//*****************************************************************************************************************
	//1.4.45
//	public static void main(String[] args) {
//		int N = 10000;
//		int num = 0;
//		int count = 0;
//		for(int k = 0;k<10000;k++) {
//			boolean[] arr = new boolean[N];
//			int c = 0;
//			for(int i = 0;true;i++) {
//				count++;
//				num = StdRandom.uniform(0,N);
//				if(!arr[num]) {
//					arr[num] = true;
//					c++;
//				}
//				if(c==N) break;
//			}	
//		}
//		System.out.println(count/10000);
//	}
//****************************************************************************************************************
}
