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
	//处理浮点数时要慎重,浮点数比较时最好采用此方法 ：控制差的绝对值在误差范围内即可（abs）.
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
	//递归的魅力
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
//	对于有负权边但无负权回路的图：
//	1、如果是标准的O(V^2)的Dijkstra，那是算不出的（除非碰巧算对）。
//	2、如果是优先队列优化（或者说堆优化）的版本，也不行（除非碰巧算对）。
//	3、如果是优先队列优化+允许重入队（详细解释见下文），那么可以（是真的可以计算出来，不是碰巧）。
//	但这实际上已经是priority queue-based Bellman-Ford了，是Bellman-Ford算法的变种。
//	国内 ACMer 也把这个算法叫做使用优先队列的 SPFA 算法，国外似乎习惯把这个算法仍旧叫做堆优化的Dijkstra，或者 generalized Dijkstra，看作Dijkstra的变种，可能是习惯不一样吧。
//	不过此时已经说不清这到底是Dijkstra还是Bellman-Ford算法了……但是需要注意的是，该算法的运行时间可能为指数！！
	
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

//	书中给出的Dijkstra算法应该就是允许重入队的方法，因此可以使用在允许负权值边但不能存在负权环的加权有向图中！
	
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
	//小数需要注意
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
//					distTo[w] = distTo[v] + e.weight();						//注意此处小数
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
//	（前置知识：提前了解 Dijkstra 算法能够降低理解 A* 算法的难度。）
//
//	A* 算法是 Dijkstra 算法和最佳优先算法的一种结合。
//
//	Dijkstra 算法需要遍历所有结点来找到最短路径，唯一的优化条件就是路径长度。
//	建立队列 queue ，把所有的结点加入 queue 中；建立数组 d，d[v] 代表起点到点 v 的距离。
//	开始时只有起点到起点的距离为 0，其他都为无穷大，然后重复如下步骤：
//	从队列中取出已知距离最短的结点 u，检查该结点的所有边。
//	如果通过这个点能够以更近的距离到达 v，更新起点到 v 的距离 d[v] = d[u] + distance(u, v)。
//	等到队列为空之后数组 d 中就存放着起点到其他所有结点的最短距离。
//
//	Dijkstra 算法会计算起点到所有点的最短路径，因此会均匀的遍历所有结点，效率较低。
//	很多时候，我们只需要找到起点到某一终点的最短路径即可，为此遍历整个图显然是不必要的。
//	通过修改算法，使得比较接近终点的结点优先得到搜索，我们就可能在遍历完全部结点之前获得结果。
//
//	在 Dijkstra 算法中，离起点最近的点会被优先搜索，记结点离起点的距离为 g[n] 。
//	现在引入新的条件，用于估计结点和终点的接近程度，记结点离终点的估计距离为 h[n] 。
//	令 f[n] = g[n] + h[n]，我们按照 f[n] 对等待搜索的结点进行排序。
//	同时令 h[n] 始终小于 g[n] ，保证离起点的距离 g[n] 权重大于离终点的估计距离 h[n] 。
//	（h[n]也被称之为容许估计）
//	于是在离起点距离接近的条件下，离终点比较近的点会被优先搜索，减少搜索范围。
//
//	接下来就是算法的具体内容，与 Dijkstra 算法不同，A* 算法不一定需要访问所有结点，
//	因此 A* 算法需要维护两个集合，openSet 保存等待搜索的结点，closeSet 保存已经搜索过的结点。
//	和 Dijkstra 算法类似，一开始 openSet 中只有起点，closeSet 则是空的。
//	然后重复执行如下步骤，直到 openSet 为空：
//	从 openSet 中取出 f[n] 最小的结点 u ，放入 closeSet。（标记为已访问）
//	如果 u 就是终点，算法结束。
//	计算结点 u 直接可达的周围结点，放入集合 neighbors。
//	遍历 neighbors 中的所有结点 v，做如下判断：
//	如果 v 已经存在于 closeSet ，忽略之。（防止走回头路）
//	如果经过 u 不能缩短起点到 v 的路径长度 g[v]，忽略之。（和 Dijkstra 算法一样的做法）
//	否则将 v 放入 openSet，更新 g[v] = g[u] + distance(u, v) ，计算 f[v] = g[v] + h[v]。（更新结点）
//	以上是 A* 算法的核心逻辑，
//	为了结合具体问题，我们需要自定义计算 g[n] 和 h[n] 的方法，以及获得某个结点周围结点的方法。
//
//	这里有个问题，openSet 和 closeSet 应该用什么数据结构？
//	closeSet 比较简单，只需要添加和查找即可，哈希表 HashSet 是不二选择。
//	openSet 需要读取并删除最小元素，以及添加和查找元素，用最小堆 MinPQ 会是比较方便的方法。
//	书中给出的最小堆 MinPQ 没有实现 Contains 方法，需要自己实现一个，简单顺序查找就够用了。
//	同时 MinPQ 的 Greater 比较方法也需要重新实现，需要使用基于 f[n] 进行比较的比较器。
	//关于8字谜题的解答详见遨游收藏
}
