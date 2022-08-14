package myCharpter3_3;

import edu.princeton.cs.algs4.RedBlackBST;

public class TestRB {
	public static void main(String[] args) {
		RedBlackBST<String,Integer> test = new RedBlackBST<String,Integer>();
		test.put("S", 0);
		test.put("E", 1);
		test.put("A", 2);
		test.put("R", 3);
		test.put("C", 4);
		test.put("H", 5);
		test.put("E", 6);
		test.put("X", 7);
		test.put("M", 8);
		System.out.println(test.min());						//"A"
		System.out.println(test.max());						//"X"
		System.out.println(test.floor("G"));				//"E"
		System.out.println(test.ceiling("G"));				//"H"
		System.out.println(test.select(4));					//"M"
		System.out.println(test.rank("H"));					// 3
		test.delete("E");				
		test.deleteMax();									
		test.deleteMin();
		Iterable<String> t = test.keys();					//"C H M R S"
		for(String ts : t)
			System.out.print(ts+" ");
	}
}

