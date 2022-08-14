package myCharpter1_3;



import java.io.File;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class TestCharpter1_3 {
	//1.3.9
//	public static void main(String[] args) {
//		MyStack<String> vals = new MyStack<String>();
//		MyStack<String> sign = new MyStack<String>();
//		String in = StdIn.readAll();
//		String[] input = in.split("\\s+");
//		for(int i = 0;i<input.length;i++) {
//			if(input[i].equals("+") || input[i].equals("-") || input[i].equals("*") || input[i].equals("/"))
//				sign.push(input[i]);                        //ע���ַ�������ʹ��==���Ƚϣ���equals()ʵ��������
//			else if(input[i].equals(")"))
//			{
//				String second = vals.pop();
//				String first = vals.pop();
//				String result="("+first+sign.pop()+second+")";
//				vals.push(result);
//			}
//			else {
//				vals.push(input[i]);
//			}
//	    }
//		for(String s:vals)
//		System.out.print(s);
//	}
//***********************************************************************************************************
	//1.3.10
	//ע��Ҫ��ջ�Ƿ�Ϊ�ս��м��
//	class InfixToPostfix {
//		public static void main(String[] args) {
//			MyStack<String> stack = new MyStack<String>();
//			String in = StdIn.readAll();
//			String[] input = in.split("\\s+");
//			for (int i = 0; i < input.length; i++) {
//				switch (input[i]) {
//				case "(":
//					stack.push(input[i]);
//					break;
//				case ")":
//					String strR;
//					if (!stack.isEmpty()) {
//						strR = stack.pop();
//						while (!strR.equals("(")) {
//							System.out.print(strR);
//							if (!stack.isEmpty())
//								strR = stack.pop();
//							else
//								break;
//						}
//					}
//					break;
//				case "*":
//					String str1;
//					if (!stack.isEmpty()) {
//						str1 = stack.pop();
//						while (str1.equals("/") || str1.equals("*")) {
//							System.out.print(str1);
//							if (!stack.isEmpty())
//								str1 = stack.pop();
//							else
//								break;
//						}
//						if (str1.equals("(") || str1.equals("+") || str1.equals("-"))
//							stack.push(str1);
//					}
//					stack.push(input[i]);
//					break;
//				case "/":
//					String str2;
//					if (!stack.isEmpty()) {
//						str2 = stack.pop();
//						while (str2.equals("*") || str2.equals("/")) {
//							System.out.print(str2);
//							if (!stack.isEmpty())
//								str2 = stack.pop();
//							else
//								break;
//						}
//						if (str2.equals("(") || str2.equals("+") || str2.equals("-"))
//							stack.push(str2);
//					}
//					stack.push(input[i]);
//					break;
//				case "+":
//					String str3;
//					if (!stack.isEmpty()) {
//						str3 = stack.pop();
//						while (str3.equals("*") || str3.equals("/") || str3.equals("+") || str3.equals("-")) {
//							System.out.print(str3);
//							if (!stack.isEmpty())
//								str3 = stack.pop();
//							else
//								break;
//						}
//						if (str3.equals("("))
//							stack.push(str3);
//					}
//					stack.push(input[i]);
//					break;
//				case "-":
//					String str4;
//					if (!stack.isEmpty()) {
//						str4 = stack.pop();
//						while (str4.equals("*") || str4.equals("/") || str4.equals("+") || str4.equals("-")) {
//							System.out.print(str4);
//							if (!stack.isEmpty())
//								str4 = stack.pop();
//							else
//								break;
//						}
//						if (str4.equals("("))
//							stack.push(str4);
//					}
//					stack.push(input[i]);
//					break;
//				default:
//					System.out.print(input[i]);
//				}
//			}
//			while (!stack.isEmpty()) {
//				System.out.print(stack.pop());
//			}
//		}
//	}
//**************************************************************************************************************************
	//1.3.11
//	class EvaluatePostfix{
//		public static void main(String[] args) {
//			MyStack<Double> number = new MyStack<Double>();
//			String in = StdIn.readAll();
//			String[] input = in.split("\\s+");
//			for(int i = 0;i < input.length;i++) {
//				if(input[i].equals("+")||input[i].equals("-")||input[i].equals("*")||input[i].equals("/")) {
//						if(input[i].equals("+")) number.push(number.pop()+number.pop());
//						if(input[i].equals("-")) number.push(number.pop()-number.pop());
//						if(input[i].equals("*")) number.push(number.pop()*number.pop());
//						if(input[i].equals("/")) {                                             //ע�����
//							double numFirst = number.pop();
//							double numSecond = number.pop();
//							number.push(numSecond/numFirst);
//						}
//				}
//				else
//					number.push(Double.parseDouble(input[i]));
//			}
//			System.out.println(number.pop());
//		}
//	}
//**************************************************************************************************************************
	//1.3.12
	public static MyStack<String> myStackCopy(MyStack<String> oriStack) {
		MyStack<String> finStack = new MyStack<String>();
		String[] temp = new String[oriStack.size()];
		for(int i =0;i<temp.length;i++) {
			temp[i] = oriStack.pop(); 
		}
		for(int i = temp.length - 1;i>=0;i++) {
			oriStack.push(temp[i]);
			finStack.push(temp[i]);
		}
		return finStack;
}
//**************************************************************************************************************************
	//1.2.15
//	public static void main(String[] args) {
//		MyQueue<String> input = new MyQueue<String>();
//		int k = StdIn.readInt();
//		String[] in =StdIn.readAllLines();
//		for(int i =0;i<in.length;i++) {
//			input.enqueue(in[i]);
//		}
//		while(input.size()>k) {      //���������⣬����������
//			input.dequeue();
//		}
//		System.out.println(input.dequeue());
//	}
//****************************************************************************************************************************
	//1.3.16&1.3.17
	public static String[] readDates() {
		In in = new In();
		MyQueue<String> date = new MyQueue<String>();
		while(!in.isEmpty()) {
			date.enqueue(in.readString());
		}
		String[] result = new String[date.size()];
		for(int i =0;i<result.length;i++)
			result[i] = date.dequeue();
		return result;
	}
	
	public static String[] readTransactions() {
		In in = new In();
		MyQueue<String> transactions = new MyQueue<String>();
		int flag = 0;
		String temp = null;
		while(!in.isEmpty()) {
			String read = in.readString();
			flag++;
			if(flag % 3 == 0) {
				transactions.enqueue(temp.concat(read));
				flag = 0;
			}
			else if(flag % 3 == 1)
				temp = read;
			else 
				temp = temp.concat(read);
		}
		String[] result = new String[transactions.size()];
		for(int i = 0;i<result.length;i++) {
			result[i] = transactions.dequeue();
		}
		return result;
	}
//**************************************************************************************************
	//1.3.19
//	public Item deTailNode() {
//		if(first.next == null) {
//			Item item = first.item;
//			first = null;
//			return item;
//		}
//		Node tempFirst = first;
//		while(tempFirst.next.next!=null) {
//			tempfirst = tempfirst.next;
//		}
//		Item item = tempFirst.next.item;
//		last = tempFirst;
//		tempFirst.next = null;
//		return item;
//	}
//****************************************************************************************************
	//1.3.20
//	public Item deleteNodeK(int k) { //�����Ҫ�󣬼ǵ�size��һ
//		if(StaticStructure.size() < k) throw new RuntimeException("k must be bigger than the size!");
//		if(StaticStructure.size() == 1) {
//			Item item = first.item;
//			first = null;
//			return item;
//		}
//		if(StaticStructure.size() == k) {
//			Node temp = first;
//			while(temp.next.next != null) {
//				temp = temp.next;
//			}
//			Iten item = temp.next.item;
//			last = temp;
//			temp.next = null;
//			return item;
//		}
//		if(k == 1) {
//			Item item = first.item;
//			first = first.next;
//			return item;
//		}
//		Node temp = first;          //ע�⣺��ı����Node��ָ����Ҫһ��ָ���Node��ָ������޸����ݣ�������
//		for(int i = 1;i < k-1; i++)  temp = temp.next;
//		Item item = temp.next.item;
//		temp.next = temp.next.next;
//		return item;
//	}
//**************************************************************************************************************
	//1.3.21
//	public static boolean findNodeKey(Node first,String key) {
//		Node temp = first;          //��ʵû�б�Ҫ��first:��ʵ�Ҿ���������
//		while(temp!=null) {			//��1.3.21���֣�����Ϊɶ�Ǹ���ʵ������������Ǿ�̬�������������ģ�
//			if(temp.item.equals(key)) return true;
//			temp = temp.next;
//		}
//		return false;
//	}
//**************************************************************************************************************
	//1.3.24
//	public static void removeAfterNode(Node node) {
//		if(node == null) return;
//		node.next = null;
//		return;
//	}
//***************************************************************************************************************
	//1.3.25
//	public static void insertAfterNode(Node nodeFirst,Node nodeSecond) {
//		if(nodeFirst == null || nodeSecond == null) return;
//		nodeSecond.next = nodeFirst.next; //t.next = x.next;  //һ�㾲̬������Ҫ��ı�ԭ��������ֵ����������node.next;
//		nodeFirst.next = nodeSecond;      //x.next = t;       
//		return;
//	}
//*************************************************************************************************************
	//1.3.26
//	public void removeNode(String key) { 
//		if(first == null) return;
//		while(key.equals(first.item)&&first.next!=null) {
//			first = first.next;
//		}
//		if(first.next == null) 
//			 if(key.equals(first.item)) {
//				 first = null;
//				 return;
//			 }
//			 else
//				 return;
//		Node temp = first;
//		while(temp.next!=null) {
//			if(key.equals(temp.next.item)) 
//				temp.next = temp.next.next;
//			else
//				temp = temp.next;
//		}
//		return;
//	}
//***************************************************************************************************************
	//1.3.27&1.3.28
//	public static int maxNode(Node firNode) {
//		if(firNode==null) return 0;
//		int temp = firNode.item;
//		firNode = firNode.next;
//		while(firNode!=null) {
//			if(firNode.item>temp) temp = firNode.item;
//			firNode = firNode.next;
//		}
//		return temp;
//	}
//	
//	public static int recursionMaxNode(Node firNode) {
//		if(firNode == null) return 0;
//		int temp = firNode.item;
//		firNode = firNode.next;
//		int number = recursionMaxNode(firNode);
//		return temp > number? temp:number;
//	}
//***************************************************************************************************************
	//1.3.30
//	public static Node reversalNode(Node first) {   //�ṩ˼·��������ת��Ҫ�뵽����ʹ��ջ���ݽṹ���پͿ���ʹ�õݹ鷽������ʵҲ���Խ��														
//		if(first==null) return null;				//ջ��ʵ�ַ�ʽ��ʹ������Ŀɴӱ�ͷ��ӽڵ�
//		Node newFirst = new Node();					//�����ر�ǿ��
//		newFirst.next = null;
//		newFirst.item = first.next;
//		first = first.next;
//		Node temp = newFirst;
//		while(first!=null) {
//			temp.next = new Node();
//			temp.next.item = first.item;
//			first = first.next;
//			temp = temp.next;
//		}
//		return newFirst;
//	}
//****************************************************************************************************************
	//1.3.37 version 1
	public static void josephusQueue() {
		System.out.println("Please input the number of people:");
		int N = StdIn.readInt();
		System.out.println("Please input the number who will be killed:");
		int M = StdIn.readInt();
		MyQueue<Integer> livePeopleF = new MyQueue<Integer>();
		MyQueue<Integer> livePeopleS = new MyQueue<Integer>();
		for(int i = 0;i<N;i++)
			livePeopleF.enqueue(i);
		while(N > 1) {
			int count = 1;
			int deadNumber = M % N;
			if(deadNumber==0) deadNumber = M;
			if(livePeopleS.isEmpty()) {
				for(int i = 1;i <= N;i++) {
					if(count != deadNumber)
						livePeopleS.enqueue(livePeopleF.dequeue());
					else
						System.out.print(livePeopleF.dequeue()+" ");
					count++;
				}
			}else {
				for(int i = 1;i <= N;i++) {
				if(count != deadNumber)
					livePeopleF.enqueue(livePeopleS.dequeue());
				else
					System.out.print(livePeopleS.dequeue()+" ");
				count++;
				}
			}
			N--;
		}
		if(!livePeopleS.isEmpty())  System.out.println(livePeopleS.dequeue());
		else					    System.out.println(livePeopleF.dequeue());
	}
//*************************************************************************************************
	//1.3.37 version2
	public static void josephus() {
		System.out.println("Please input the number of people:");
		int N = StdIn.readInt();
		System.out.println("Please input the number who will be killed:");
		int M = StdIn.readInt();
		int num = N;
		MyQueue<Integer> livePeopleF = new MyQueue<Integer>();
		MyQueue<Integer> livePeopleS = new MyQueue<Integer>();
		for(int i = 0;i<N;i++)
			livePeopleF.enqueue(i);
		int count = 1;
		while(N > 1) {
			int deadNumber = M % N;
			if(deadNumber==0) deadNumber = M;
			if(livePeopleS.isEmpty()) {
				for(int i = 1;i <= num;i++) {
					if(count != deadNumber) {
						livePeopleS.enqueue(livePeopleF.dequeue());
						count++;
					}
					else {
						System.out.print(livePeopleF.dequeue()+" ");
						count = 1;
						N--;
					}
				}
			}else {
				for(int i = 1;i <= num;i++) {
					if(count != deadNumber) {
						livePeopleF.enqueue(livePeopleS.dequeue());
						count++;
					}
					else {
						System.out.print(livePeopleS.dequeue()+" ");
						count = 1;
						N--;
					}
				}
			}
			num = N;
		}
		if(!livePeopleS.isEmpty())  System.out.println(livePeopleS.dequeue());
		else					    System.out.println(livePeopleF.dequeue());
	}
//*************************************************************************************************
	//1.3.43
	public static void printFileName(String fileName,int N) {
		File file = new File(fileName);
		for(int i =0;i<N;i++)			//����ʹ���˲���N�Դ��ݵݹ����
			System.out.print("   ");
		if(!file.isDirectory()) {
			System.out.println(file.getName());
			return;
		}
		String[] str = file.list();
		System.out.println(file.getName());
		N++;
		for(int i = 0;i<str.length;i++) {
			printFileName(fileName+"/"+str[i],N);
		}
	}
//**************************************************************************************************
	//1.3.49
//	��ջ��Ҫ�����أ���ջ��ջ���������������ղأ����鿼������ջ��ʵ�ַ�ʽ
//**************************************************************************************************
}
