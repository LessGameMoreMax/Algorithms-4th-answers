package myCharpter1_1;

public class TestCharpter1_1_MyMaxtrix_1_1_33 {
	static double dot(double[] x,double[] y) {
		double sum = 0.0;
		for(int i = 0;i<x.length;i++)
			sum += x[i]*y[i];
		return sum;
	}
	
	static double[][] mult(double[][] a,double[][] b){
		double[][] result = new double[a.length][b[0].length];
		for(int i = 0;i < a.length;i++) 
			for(int j = 0;j < b[0].length;j++) {
				double sum = 0.0;
				for(int k = 0; k < b.length;k++) 
					sum += a[i][k]*b[k][j];
				result[i][j] = sum;
			}
		return result;
	}
	
	public static double[][] transpose(double[][] array) {
		double[][] result = new double[array[0].length][array.length];
		for(int i = 0;i<array.length;i++) 
			for(int j=0;j<array[0].length;j++) 
				result[j][i] = array[i][j];
		return result;
	}
	
	public static double[] mult(double[][] a, double[] x) {
		double[] result = new double[a.length];
		for(int i=0;i<a.length;i++) {
			double sum = 0;
			for(int j = 0;j<x.length;j++)
				sum += a[i][j]*x[j];
			result[i] = sum;
		}
		return result;
	}
	
	public static double[] mult(double[] y, double[][] a) {
		double[] result = new double[a[0].length];
		for(int j =0;j<a[0].length;j++) {
			double sum = 0;
			for(int i =0;i<y.length;i++)
				sum += y[i]*a[i][j];
			result[j] = sum;
		}
		return result;
	}
}
