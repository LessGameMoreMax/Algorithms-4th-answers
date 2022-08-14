package myCharpter5_2;

public class TSTNoRecursion<Value> {
	private Node root;
	private class Node{
		char c;
		Node left;
		Node mid;
		Node right;
		Value val;
	}
	
	public Value get(String key) {
		if(key==null) return null;
		int d = 0;
		Node temp = root;
		while(d<key.length()) {
			if(temp == null) return null;
			char c = key.charAt(d);
			if(c<temp.c) temp = temp.left;
			else if(c>temp.c) temp = temp.right;
			else {
				if(d==key.length()-1) return temp.val;
				temp = temp.mid;
				d++;
			}
		}
		return null;
	}
	
	public void put(String key,Value val) {
		int d = 0;
		if(root==null) {
			root = new Node();
			root.c = key.charAt(d);
		}
		Node temp = root;
		while(d<key.length()) {
			char c = key.charAt(d);
			if(temp.c==c) {
				if(d==key.length()-1) {
					temp.val = val;
					return;
				}
				if(temp.mid==null) {
					temp.mid = new Node();
					temp.mid.c = c;
				}
				temp = temp.mid;
				d++;
			}else if(temp.c>c) {
				if(temp.left==null) {
					temp.left = new Node();
					temp.left.c = c;
				}
				temp = temp.left;
			}else {
				if(temp.right==null) {
					temp.right = new Node();
					temp.right.c = c;
				}
				temp = temp.right;
			}
		}
	}
	
	public static void main(String[] args) {
		TSTNoRecursion<Integer> T = new TSTNoRecursion<Integer>();
		T.put("by", 4);
		T.put("sea", 2);
		T.put("sells", 1);
		T.put("she", 0);
		T.put("shells", 3);
		T.put("the", 5);
		T.put("sea", 5);
		System.out.println(T.get("shell"));
	}
}
