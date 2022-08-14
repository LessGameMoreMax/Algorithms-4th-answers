package myCharpter6_3;

import edu.princeton.cs.algs4.Quick3way;

public class LinearCycle {
	public static String process(String s) {
		String[] str = LinearRotation.process(s);
		Quick3way.sort(str);
		return str[0];
	}
}
