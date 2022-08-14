package tipa;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import myCharpter4_4.AcyclicSPMoreDis;
import myCharpter4_4.EdgeWeightedTopological;
import myCharpter4_4.MyDijkstraSP;
import myCharpter4_4.MyDirectedEdge;
import myCharpter4_4.MyEdgeWeightedDigraph;

public class Notice {
//	double i = 0;
//	for(int count = 0;i!=1.1 && count <1000;i += 0.1,count++);
//	System.out.println(i);
//********************************************************************************************
	//��������ʱҪ����,�������Ƚ�ʱ��ò��ô˷��� �����Ʋ�ľ���ֵ����Χ�ڼ��ɣ�abs��.
//	double i = 0;
//	for(int count = 0;Math.abs(i - 1.1) > 1e-13 && count <1000;i += 0.1,count++);
//	System.out.println(i);
    private static final double FLOATING_POINT_EPSILON = 1E-12;
//********************************************************************************************
//	double i = 1.1;
//	float j = (float)1.1;
//	if(i == j) System.out.println("equal");
//	else System.out.println("not equal");
//*********************************************************************************************
//	float i = (float)1.1;
//	float j = (float)1.1;
//	if(i == j) System.out.println("equal");
//	else System.out.println("not equal");
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//�ݹ������
	public class StringhashAttack {
		public static void main(String[] args) {
			addChar(3);
		}
		public static void addChar(int length) 
		{ addChar("",length);}
		
		private static void addChar(String a,int length) {
			if(a.length()>=length) {
				System.out.println(a);
				return;
			}
			for(int i = 65;i<123;i++) {
				if(i==91) i = 97;
				addChar(a+(char)i,length);
			}
		}
	}
//***************************************************************************************************************
//	�����и�Ȩ�ߵ��޸�Ȩ��·��ͼ��
//	1������Ǳ�׼��O(V^2)��Dijkstra�������㲻���ģ�����������ԣ���
//	2����������ȶ����Ż�������˵���Ż����İ汾��Ҳ���У�����������ԣ���
//	3����������ȶ����Ż�+��������ӣ���ϸ���ͼ����ģ�����ô���ԣ�����Ŀ��Լ���������������ɣ���
//	����ʵ�����Ѿ���priority queue-based Bellman-Ford�ˣ���Bellman-Ford�㷨�ı��֡�
//	���� ACMer Ҳ������㷨����ʹ�����ȶ��е� SPFA �㷨�������ƺ�ϰ�߰�����㷨�Ծɽ������Ż���Dijkstra������ generalized Dijkstra������Dijkstra�ı��֣�������ϰ�߲�һ���ɡ�
//	������ʱ�Ѿ�˵�����⵽����Dijkstra����Bellman-Ford�㷨�ˡ���������Ҫע����ǣ����㷨������ʱ�����Ϊָ������
	
//	Q. Does Dijkstra's algorithm work with negative weights?

//	A. Yes and no. There are two shortest paths algorithms known as Dijkstra's algorithm, 
//	depending on whether a vertex can be enqueued on the priority queue more than once. 
//	When the weights are nonnegative, the two versions coincide (as no vertex will be enqueued more than once). 
//	The version implemented in DijkstraSP.java (which allows a vertex to be enqueued more than once) is correct 
//	in the presence of negative edge weights (but no negative cycles) but its running time is exponential in the worst case. 
//	(We note that DijkstraSP.java throws an exception if the edge-weighted digraph has an edge with a negative weight, so that a programmer 
//	is not surprised by this exponential behavior.) If we modify DijkstraSP.java so that a vertex cannot be enqueued more than once 
//	(e.g., using a marked[] array to mark those vertices that have been relaxed), then the algorithm is guaranteed to run in E log V time 
//	but it may yield incorrect results when there are edges with negative weights.

//	���и�����Dijkstra�㷨Ӧ�þ�����������ӵķ�������˿���ʹ��������Ȩֵ�ߵ����ܴ��ڸ�Ȩ���ļ�Ȩ����ͼ�У�
	
//	public static void main(String[] args) {
////		EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));
////		BellmanFordSP B = new BellmanFordSP(G,0);
////		for(DirectedEdge e : B.pathTo(1))
////			System.out.println(e);
//		
//		MyEdgeWeightedDigraph G = new MyEdgeWeightedDigraph(new In(args[0]));
//		MyDijkstraSP D = new MyDijkstraSP(G,1);
//		for(MyDirectedEdge e : D.pathTo(7))
//			System.out.println(e);
//	}
//*****************************************************************************************************************
	//С����Ҫע��
//	public class AcyclicSPMoreDis {
//	    private static final double FLOATING_POINT_EPSILON = 1E-12;
//		private Queue<MyDirectedEdge>[] edgeTo; 
//		private double[] distTo;
//		
//		public AcyclicSPMoreDis(MyEdgeWeightedDigraph G,int s) {
//			edgeTo = (Queue<MyDirectedEdge>[])new Queue[G.V()];
//			distTo = new double[G.V()];
//			for(int i = 0;i<G.V();i++) {
//				if(i!=s) edgeTo[i] = new Queue<MyDirectedEdge>();
//				distTo[i] = Double.POSITIVE_INFINITY;
//			}
//			distTo[s] = 0.0;
//			EdgeWeightedTopological top = new EdgeWeightedTopological(G);
//			for(int v : top.order()) relax(G,v);
//		}
//		
//		private void relax(MyEdgeWeightedDigraph G,int v) {
//			for(MyDirectedEdge e : G.adj(v)) {
//				int w = e.to();
//				if(distTo[w]>distTo[v]+e.weight()&&Math.abs(distTo[w]-distTo[v]-e.weight())>FLOATING_POINT_EPSILON) {
//					distTo[w] = distTo[v] + e.weight();						//ע��˴�С��
//					while(!edgeTo[w].isEmpty()) edgeTo[w].dequeue();
//					edgeTo[w].enqueue(e);
//				}else if(Math.abs(distTo[w]-distTo[v]-e.weight())<FLOATING_POINT_EPSILON) {
//					edgeTo[w].enqueue(e);
//				}
//			}
//		}
//		
//		public double distTo(int v) {
//			return distTo[v];
//		}
//		
//		public boolean hasPathTo(int v) {
//			return distTo[v]<Double.POSITIVE_INFINITY;
//		}
//		
//		public Queue<Stack<MyDirectedEdge>> pathTo(int v){
//			if(!hasPathTo(v)) return null;
//			Queue<Stack<MyDirectedEdge>> queue = (Queue<Stack<MyDirectedEdge>>) new Queue();
//			for(MyDirectedEdge e : edgeTo[v]) {
//				Stack<MyDirectedEdge> stack = new Stack<MyDirectedEdge>();
//				stack.push(e);
//				pathTo(queue,stack,edgeTo[e.from()]);
//			}
//			return queue;
//		}
//		
//		private void pathTo(Queue<Stack<MyDirectedEdge>> queue,Stack<MyDirectedEdge> stack,Queue<MyDirectedEdge> edges) {
//			if(edges==null) { queue.enqueue(stack); return;}
//			for(MyDirectedEdge e : edges) {
//				Stack<MyDirectedEdge> s = new Stack<MyDirectedEdge>();
//				Stack<MyDirectedEdge> q = new Stack<MyDirectedEdge>();
//				for(MyDirectedEdge edge : stack) q.push(edge);
//				for(MyDirectedEdge edge : q) s.push(edge);
//				s.push(e);
//				pathTo(queue,s,edgeTo[e.from()]);
//			}
//		}
//		
//		public static void main(String[] args) {
//			MyEdgeWeightedDigraph G = new MyEdgeWeightedDigraph(new In(args[0]));
//			AcyclicSPMoreDis D = new AcyclicSPMoreDis(G,5);
//			Queue<Stack<MyDirectedEdge>> q = D.pathTo(2);
//			for(Stack<MyDirectedEdge> s : q) {
//				for(MyDirectedEdge e : s) 
//					System.out.println(e);
//				System.out.println("***************");
//			}
//			
////			MyEdgeWeightedDigraph G = new MyEdgeWeightedDigraph(4);
////			G.addByVertex(0, 1, 0.1);
////			G.addByVertex(0, 2, 0.2);
////			G.addByVertex(1, 3, 0.2);
////			G.addByVertex(2, 3, 0.1);
////			AcyclicSPMoreDis D = new AcyclicSPMoreDis(G,0);
////			Queue<Stack<MyDirectedEdge>> q = D.pathTo(3);
////			for(Stack<MyDirectedEdge> s : q) {
////				for(MyDirectedEdge e : s) 
////					System.out.println(e);
////				System.out.println("***************");
////			}
//		}
//	}
//**********************************************************************************************************************
	//2.5.32
//	��ǰ��֪ʶ����ǰ�˽� Dijkstra �㷨�ܹ�������� A* �㷨���Ѷȡ���
//
//	A* �㷨�� Dijkstra �㷨����������㷨��һ�ֽ�ϡ�
//
//	Dijkstra �㷨��Ҫ�������н�����ҵ����·����Ψһ���Ż���������·�����ȡ�
//	�������� queue �������еĽ����� queue �У��������� d��d[v] ������㵽�� v �ľ��롣
//	��ʼʱֻ����㵽���ľ���Ϊ 0��������Ϊ�����Ȼ���ظ����²��裺
//	�Ӷ�����ȡ����֪������̵Ľ�� u�����ý������бߡ�
//	���ͨ��������ܹ��Ը����ľ��뵽�� v��������㵽 v �ľ��� d[v] = d[u] + distance(u, v)��
//	�ȵ�����Ϊ��֮������ d �оʹ������㵽�������н�����̾��롣
//
//	Dijkstra �㷨�������㵽���е�����·������˻���ȵı������н�㣬Ч�ʽϵ͡�
//	�ܶ�ʱ������ֻ��Ҫ�ҵ���㵽ĳһ�յ�����·�����ɣ�Ϊ�˱�������ͼ��Ȼ�ǲ���Ҫ�ġ�
//	ͨ���޸��㷨��ʹ�ñȽϽӽ��յ�Ľ�����ȵõ����������ǾͿ����ڱ�����ȫ�����֮ǰ��ý����
//
//	�� Dijkstra �㷨�У����������ĵ�ᱻ�����������ǽ�������ľ���Ϊ g[n] ��
//	���������µ����������ڹ��ƽ����յ�Ľӽ��̶ȣ��ǽ�����յ�Ĺ��ƾ���Ϊ h[n] ��
//	�� f[n] = g[n] + h[n]�����ǰ��� f[n] �Եȴ������Ľ���������
//	ͬʱ�� h[n] ʼ��С�� g[n] ����֤�����ľ��� g[n] Ȩ�ش������յ�Ĺ��ƾ��� h[n] ��
//	��h[n]Ҳ����֮Ϊ������ƣ�
//	��������������ӽ��������£����յ�ȽϽ��ĵ�ᱻ��������������������Χ��
//
//	�����������㷨�ľ������ݣ��� Dijkstra �㷨��ͬ��A* �㷨��һ����Ҫ�������н�㣬
//	��� A* �㷨��Ҫά���������ϣ�openSet ����ȴ������Ľ�㣬closeSet �����Ѿ��������Ľ�㡣
//	�� Dijkstra �㷨���ƣ�һ��ʼ openSet ��ֻ����㣬closeSet ���ǿյġ�
//	Ȼ���ظ�ִ�����²��裬ֱ�� openSet Ϊ�գ�
//	�� openSet ��ȡ�� f[n] ��С�Ľ�� u ������ closeSet�������Ϊ�ѷ��ʣ�
//	��� u �����յ㣬�㷨������
//	������ u ֱ�ӿɴ����Χ��㣬���뼯�� neighbors��
//	���� neighbors �е����н�� v���������жϣ�
//	��� v �Ѿ������� closeSet ������֮������ֹ�߻�ͷ·��
//	������� u ����������㵽 v ��·������ g[v]������֮������ Dijkstra �㷨һ����������
//	���� v ���� openSet������ g[v] = g[u] + distance(u, v) ������ f[v] = g[v] + h[v]�������½�㣩
//	������ A* �㷨�ĺ����߼���
//	Ϊ�˽�Ͼ������⣬������Ҫ�Զ������ g[n] �� h[n] �ķ������Լ����ĳ�������Χ���ķ�����
//
//	�����и����⣬openSet �� closeSet Ӧ����ʲô���ݽṹ��
//	closeSet �Ƚϼ򵥣�ֻ��Ҫ��ӺͲ��Ҽ��ɣ���ϣ�� HashSet �ǲ���ѡ��
//	openSet ��Ҫ��ȡ��ɾ����СԪ�أ��Լ���ӺͲ���Ԫ�أ�����С�� MinPQ ���ǱȽϷ���ķ�����
//	���и�������С�� MinPQ û��ʵ�� Contains ��������Ҫ�Լ�ʵ��һ������˳����Ҿ͹����ˡ�
//	ͬʱ MinPQ �� Greater �ȽϷ���Ҳ��Ҫ����ʵ�֣���Ҫʹ�û��� f[n] ���бȽϵıȽ�����
	//����8������Ľ����������ղ�
}
