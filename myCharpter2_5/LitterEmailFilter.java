package myCharpter2_5;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class LitterEmailFilter {
	public static String[] filter(String[] list)
	{
		MinPQ<String> pq = new MinPQ<String>();
		for(int i = 0;i<list.length;i++)
		{
			String[] str = list[i].split("@");
			pq.insert(str[1]);
		}
		Queue<String> q = new Queue<String>();
		String prev = pq.delMin();
		q.enqueue(prev);
		while(!pq.isEmpty()) {
			String str = pq.delMin();
			if(!prev.equals(str)) q.enqueue(str);
			prev = str;
		}
		String[] str = new String[q.size()];
		for(int i = 0;i<str.length;i++)
			str[i] = q.dequeue();
		return str;
	}

}

