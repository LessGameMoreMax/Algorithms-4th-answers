package myCharpter5_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

public class Brute {
	String pat;
	public Brute(String pat) {
		this.pat = pat;
	}
	
	public int search(String txt) {
		for(int i = 0;i<=txt.length()-pat.length();i++) {
			int j;
			for(j = 0;j<pat.length();j++)
				if(txt.charAt(i+j)!=pat.charAt(j)) break;
			if(j==pat.length()) return i;
		}
		return txt.length();
	}
	
	public int search(In in) {
		String txt = "";
		int count = 0;
		while(in.hasNextLine()) {
			if(txt.length()==0) txt = in.readString();
			for(int i = 0;i<=txt.length()-pat.length();i++) {
				int j;
				for(j = 0;j<pat.length();j++)
					if(txt.charAt(i+j)!=pat.charAt(j)) break;
				if(j==pat.length()) return i + count;
			}
			txt = txt.substring(txt.length()-pat.length(), txt.length()-1);
			count += txt.length()-pat.length();
		}
		return count;
	}
	
	public int count(String txt) {
		int count = 0;
		for(int i = 0;i<=txt.length()-pat.length();i++) {
			int j;
			for(j = 0;j<pat.length();j++)
				if(txt.charAt(i+j)!=pat.charAt(j)) break;
			if(j==pat.length()) count++;
		}
		return count;
	}
	
	public Iterable<Integer> searchAll(String txt){
		Queue<Integer> q = new Queue<Integer>();
		for(int i = 0;i<=txt.length()-pat.length();i++) {
			int j;
			for(j = 0;j<pat.length();j++)
				if(txt.charAt(i+j)!=pat.charAt(j)) break;
			if(j==pat.length()) q.enqueue(i);
		}
		return q;
	}
	
	public static void main(String[] args) {
		Brute B = new Brute("a");
		for(Integer i : B.searchAll("ababbabaabab"))
		System.out.println(i);
	}
}
