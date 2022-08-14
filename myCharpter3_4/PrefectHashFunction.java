package myCharpter3_4;

import edu.princeton.cs.algs4.BST;

public class PrefectHashFunction {
	public static void main(String[] args) {
		String s = "SEARCHXMPL";
		for(int M = 10;M<=100;M++) {
			boolean flagM = false;
			for(int a = 1;a<1000;a++) {
				BST<Integer,Integer> bst = new BST<Integer,Integer>();
				boolean flagA = true; 
				int hash = 0;
				for(int i = 0;i<s.length();i++) {
					hash = (a * s.charAt(i)) % M;
					if(bst.contains(hash)) { flagA = false; break;}
					else				   bst.put(hash, hash);
				}
				if(flagA) {
					System.out.println("a :"+a+"  M:"+M);
					flagM = true;
					break;
				}
			}
			if(flagM) break;
		}
	}
}
