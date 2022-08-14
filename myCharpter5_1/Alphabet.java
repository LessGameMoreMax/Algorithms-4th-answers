package myCharpter5_1;

import edu.princeton.cs.algs4.ST;

public class Alphabet {
	private ST<Character,Integer> character;
	private ST<Integer,Character> index;
	public Alphabet(String s) {
		character = new ST();
		index = new ST();
		for(int i = 0;i<s.length();i++) {
			character.put(s.charAt(i), i);
			index.put(i,s.charAt(i));
		}
	}
	public char toChar(int index) 
	{ return this.index.get(index);}
	public int toIndex(char c)
	{ return this.character.get(c);}
	public boolean contains(char c)
	{ return this.character.contains(c);}
	public int R()
	{ return this.character.size();}
	public int lgR()
	{ return (int) Math.ceil(Math.log10(this.R())/Math.log10(2));}
	public int[] toIndices(String s) {
		int[] index = new int[s.length()];
		for(int i = 0;i<s.length();i++)
			index[i] = this.toIndex(s.charAt(i));
		return index;
	}
	public String toChars(int[] indices) {
		String s = "";
		for(int i = 0;i<indices.length;i++)
			s += this.toChar(indices[i]);
		return s;
	}
	
	public static void main(String[] args) {
		Alphabet alphabet = new Alphabet("01234567");
		int[] num = {6,1,5,4,3,3,4};
		System.out.println(alphabet.toChars(num));
		System.out.println(alphabet.R());
	}
}
