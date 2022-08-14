package myCharpter4_1;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdOut;
/*
代码逻辑：先进行深度优先搜索，检查环，将桥先走过的顶点称为桥头堡，后走过的顶点称为桥腚堡，当从一个顶点(记为该顶点)
，即该顶点，搜索时遇到了已标记的非父母顶点，则进行判断是不是桥腚堡（称为桥腚堡嫌疑堡）：由递归的返回路径进行桥腚堡嫌疑堡low值的
统一，完成之后环上的所有low值均为桥腚堡嫌疑堡的值，此时递归再一返回，坏了，这个环它有来路，说明找到桥头堡了，并且桥头堡的low
值不会被桥腚堡嫌疑堡的值改变（桥头堡比它早，low值小），接着桥头堡再一检查，发现了pre值和low值相等的桥腚堡。
哼，想逃？果然此桥腚堡嫌疑堡就是桥腚堡，于是打印输出，结束。
关键就在于桥腚堡统一它那片大陆之后，在桥头堡处一检查就会发现桥腚堡大陆的值均由桥腚堡提供，与桥头堡
大陆毫无关系（如果有关系的话一定会在一次检查中被替换成不大于桥头堡的值，最后统一桥腚堡大陆的还是桥头堡那
边的亲王），即桥腚堡的值low值仍与pre值相等（pre与low相等者加冕为王，所以桥腚堡大陆独立为邦），桥因此出现。
重点：pre与low相等者加冕为王。存在可以望向桥腚堡的桥头堡即存在桥：我能看见那片大陆的王。
*/
public class Bridge {
    private int bridges;      // number of bridges		//桥的数量
    private int cnt;          // counter				//计数器
    private int[] pre;        // pre[v] = order in which dfs examines v		//记录dfs检查v的顺序
    private int[] low;        // low[v] = lowest preorder of any vertex connected to v	
    
    public Bridge(Graph G) {
        low = new int[G.V()];
        pre = new int[G.V()];
        for (int v = 0; v < G.V(); v++)	//赋值
            low[v] = -1;
        for (int v = 0; v < G.V(); v++)
            pre[v] = -1;
        
        for (int v = 0; v < G.V(); v++)
            if (pre[v] == -1)	//如果v没有被检查过，进行bfs
                dfs(G, v, v);
    }

    public int components() { return bridges + 1; }

    private void dfs(Graph G, int u, int v) {
        pre[v] = cnt++;		//pre数组保存检查顺序
        low[v] = pre[v];	//low进行检查顺序数的统一
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
            //更新low数组内容-忽略指向v的边交换
            else if (w != u)
                low[v] = Math.min(low[v], pre[w]); 	//这里采用的是pre保存的原有数据吧
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

