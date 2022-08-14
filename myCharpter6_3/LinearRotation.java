package myCharpter6_3;

public class LinearRotation {
//一般凡是和回环变位有关的操作都可以使用两字符串拼接大法
	public static String[] process(String s) {
		String t = s + s;
		int N = s.length();
		String[] rotation = new String[N];
		for(int i = 0;i<N;i++)
			rotation[i] = t.substring(i,i+N);
		return rotation;
	}
	
	public static void main(String[] args) {
		String a = "abc";
		String[] s = process(a);
		for(String str : s)
			System.out.println(str);
 	}
}
