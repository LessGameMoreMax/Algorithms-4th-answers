package myCharpter4_3;

public class SeekWeightToMST {
	// С����һ�����㵽��һ����·���ϵ����Ȩ�ؼ���
	public static void main(String[] args) {
		MyEdgeWeightedGraph G = new MyEdgeWeightedGraph(6);
		G.addVertex(0, 1, 0.2);
		G.addVertex(1, 2, 0.1);
		G.addVertex(2, 3, 0.3);
		G.addVertex(3, 4, 0.5);
		G.addVertex(2, 5, 0.6);
		WeightedBFSWithMST W = new WeightedBFSWithMST(G,0);
		W.printWeighted(4);
	}
}
