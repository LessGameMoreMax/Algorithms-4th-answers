package myCharpter2_2;


import edu.princeton.cs.algs4.StdOut;

public class MergeNatureNode {
	class Node{
		Integer number;
		Node next;
	}
	
	public static Node sort(Node node) {
		Node first = node;
		while(node!=null) {
			while(node.next!=null&&less(node,node.next))
				node = node.next;
			if(node.next==null) return first;
			Node breakPoint = node;
			Node second = node.next;
			node = node.next;
			while(node.next!=null&&less(node,node.next))
				node = node.next;
			Node end = node.next;
			breakPoint.next = end;
			if(breakPoint.number>node.number) node = breakPoint;
			first = merge(first,second,end);
		}
		return first;
	}
	
	private static Node merge(Node first,Node second,Node end) {
		MergeNatureNode temp = new MergeNatureNode();
//		Node answer = temp.new Node();
		Node nodeAux = temp.new Node();
		Node nodeAuxTemp = nodeAux;
		while(first!=end||second!=end) {
			if(first==end||(second!=end&&less(second,first))) {
//				if(nodeAux.equals(null)) {
//					nodeAux = second;
//					answer = second;
//				}else {
					nodeAux.next = second;
					nodeAux = nodeAux.next;
//				}
				if(second!=end) second = second.next;
			}else{
//				if(nodeAux.equals(null)) {
//					nodeAux = first;
//					answer = first;
//				}else {
					nodeAux.next = first;
					nodeAux = nodeAux.next;
//				}
				if(first!=end) first = first.next;
			}
			nodeAux.next = null;
		}
		nodeAux.next = end;
//		return answer;
		return nodeAuxTemp.next;
	}
	
	private static boolean less(Node v,Node w) {
		return v.number<w.number;
	}
	
	private static void show(Node a) {
		while(a!=null) {
			StdOut.print(a.number + " ");
			a = a.next;
		}
		StdOut.println();
	}
	
	public static void main(String[] args) {
		MergeNatureNode temp = new MergeNatureNode();
		Node test0 = temp.new Node();
		Node test1 = temp.new Node();
		Node test2 = temp.new Node();
		Node test3 = temp.new Node();
		Node test4 = temp.new Node();
		Node test5 = temp.new Node();
		Node test6 = temp.new Node();
		Node test7 = temp.new Node();
		Node test8 = temp.new Node();
		Node test9 = temp.new Node();
		
		test0.number = 1; 
		test1.number = 9; 
		test2.number = 0; 
		test3.number = 4;
		
		test4.number = 3; 
		test5.number = 8; 
		test6.number = 9; 
		test7.number = 6;
		
		test8.number = 4;
		test9.number = 5;
		
		test0.next = test1;
		test1.next = test2;
		test2.next = test3;
		test3.next = test4;

		test4.next = test5;
		test5.next = test6;
		test6.next = test7;
		test7.next = test8;

		test8.next = test9;
		
		test0 = sort(test0);
		show(test0);
		
	}
}

