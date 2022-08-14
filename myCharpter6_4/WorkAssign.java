package myCharpter6_4;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WorkAssign {
	public static void main(String[] args) {
		Queue<String> q = new Queue<String>();
		System.out.println("How many students would you like to input?");
		int s = StdIn.readInt();
		System.out.println("How many company do they follow?");
		int N = StdIn.readInt();
		MyFlowNetwork G = new MyFlowNetwork(s*N+2+s);
		System.out.println("Now please input:");
		ST<String,Integer> st = new ST<String,Integer>();
		for(int i = 0;i < s;i++) {
			String student = StdIn.readString();
			st.put(student, st.size()+1);
			q.enqueue(student);
			G.addEdge(new MyFlowEdge(0,st.get(student),1));
			for(int j = 0;j < N;j++) {
				String company = StdIn.readString();
				if(!st.contains(company)) st.put(company, st.size()+1);
				G.addEdge(new MyFlowEdge(st.get(student),st.get(company),1));
				G.addEdge(new MyFlowEdge(st.get(company),s*N+1+s,1));
			}
		}
		ST<Integer,String> stUnverse = new ST<Integer,String>();
		for(String student : st) stUnverse.put(st.get(student), student);
		int begin = 0;
		int end = G.V()-1;
		MyFordFulkerson maxflow = new MyFordFulkerson(G,begin,end);
		for(String student : q) {
			System.out.println(student + ":");
			for(MyFlowEdge e : G.adj(st.get(student)))
				if((st.get(student) == e.from())&&e.flow()>0)
					StdOut.println("   "+ stUnverse.get(e.to()));
		}
	}
}
