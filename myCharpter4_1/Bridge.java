package myCharpter4_1;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdOut;
/*
�����߼����Ƚ������������������黷���������߹��Ķ����Ϊ��ͷ�������߹��Ķ����Ϊ���뱤������һ������(��Ϊ�ö���)
�����ö��㣬����ʱ�������ѱ�ǵķǸ�ĸ���㣬������ж��ǲ������뱤����Ϊ���뱤���ɱ������ɵݹ�ķ���·���������뱤���ɱ�lowֵ��
ͳһ�����֮���ϵ�����lowֵ��Ϊ���뱤���ɱ���ֵ����ʱ�ݹ���һ���أ����ˣ������������·��˵���ҵ���ͷ���ˣ�������ͷ����low
ֵ���ᱻ���뱤���ɱ���ֵ�ı䣨��ͷ�������磬lowֵС����������ͷ����һ��飬������preֵ��lowֵ��ȵ����뱤��
�ߣ����ӣ���Ȼ�����뱤���ɱ��������뱤�����Ǵ�ӡ�����������
�ؼ����������뱤ͳһ����Ƭ��½֮������ͷ����һ���ͻᷢ�����뱤��½��ֵ�������뱤�ṩ������ͷ��
��½���޹�ϵ������й�ϵ�Ļ�һ������һ�μ���б��滻�ɲ�������ͷ����ֵ�����ͳһ���뱤��½�Ļ�����ͷ����
�ߵ��������������뱤��ֵlowֵ����preֵ��ȣ�pre��low����߼���Ϊ�����������뱤��½����Ϊ�������˳��֡�
�ص㣺pre��low����߼���Ϊ�������ڿ����������뱤����ͷ���������ţ����ܿ�����Ƭ��½������
*/
public class Bridge {
    private int bridges;      // number of bridges		//�ŵ�����
    private int cnt;          // counter				//������
    private int[] pre;        // pre[v] = order in which dfs examines v		//��¼dfs���v��˳��
    private int[] low;        // low[v] = lowest preorder of any vertex connected to v	
    
    public Bridge(Graph G) {
        low = new int[G.V()];
        pre = new int[G.V()];
        for (int v = 0; v < G.V(); v++)	//��ֵ
            low[v] = -1;
        for (int v = 0; v < G.V(); v++)
            pre[v] = -1;
        
        for (int v = 0; v < G.V(); v++)
            if (pre[v] == -1)	//���vû�б�����������bfs
                dfs(G, v, v);
    }

    public int components() { return bridges + 1; }

    private void dfs(Graph G, int u, int v) {
        pre[v] = cnt++;		//pre���鱣����˳��
        low[v] = pre[v];	//low���м��˳������ͳһ
        for (int w : G.adj(v)) {
            if (pre[w] == -1) {
                dfs(G, v, w);
                low[v] = Math.min(low[v], low[w]);
                if (low[w] == pre[w]) {
                    StdOut.println(v + "-" + w + " is a bridge");
                    bridges++;
                }
            }

            // update low number - ignore reverse of edge leading to v
            //����low��������-����ָ��v�ı߽���
            else if (w != u)
                low[v] = Math.min(low[v], pre[w]); 	//������õ���pre�����ԭ�����ݰ�
        }
    }
    
    public static void main(String[] args) {
    	Graph G = new Graph(4);
    	G.addEdge(2, 0);
    	G.addEdge(2, 1);
    	G.addEdge(2, 3);
    	G.addEdge(1, 3);
    	G.addEdge(0, 1);
    	Bridge b = new Bridge(G);
    	System.out.println(b.components());
    }
}

