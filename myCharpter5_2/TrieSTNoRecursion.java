package myCharpter5_2;

public class TrieSTNoRecursion<Value> {
	private static int R = 256;
	private Node root;
	private static class Node{
		private Object val;
		private Node[] next = new Node[R];
	}
	
	public Value get(String key) {
		if(root == null) return null;
		Node temp = root;
		for(int i = 0;i<key.length();i++) {
			temp = temp.next[key.charAt(i)];
			if(temp==null) return null;
		}
		return (Value)temp.val;
	}
	
	public void put(String key,Value val) {
		if(root == null)  root = new Node();
		Node temp = root;
		for(int i = 0;i<key.length();i++) {
			 if(temp.next[key.charAt(i)]==null)  temp.next[key.charAt(i)] = new Node();
			 temp = temp.next[key.charAt(i)];
		}
		temp.val = val;
	}
	
	public static void main(String[] args) {
		TrieSTNoRecursion<Integer> T = new TrieSTNoRecursion<Integer>();
		T.put("by", 4);
		T.put("sea", 2);
		T.put("sells", 1);
		T.put("she", 0);
		T.put("shells", 3);
		T.put("the", 5);
		T.put("sea", 5);
		System.out.println(T.get("by"));
	}
}
