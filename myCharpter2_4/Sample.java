package myCharpter2_4;

import edu.princeton.cs.algs4.StdRandom;

public class Sample <Key extends Comparable<Key>>{
	double[] p;
	double[] sumP;
	double T;
	
	public Sample(double[] input)
	{
		p = new double[input.length+1];
		for(int i = 0;i<input.length;i++) {
			p[i+1] = input[i];
			T += input[i];
		}
        sumP = new double[input.length + 1];
        for (int i = input.length; i / 2 > 0; i--)
            sumP[i / 2] += p[i];
	}
	
	public int random()
	{
		double ran = StdRandom.random() * T;
		int index = 1;
		while(index*2<=p.length)
		{
			if(ran<p[index]) break;
			
            ran -= p[index];
            index *= 2;

            if (ran <= sumP[index] + p[index])
                continue;

            ran -= sumP[index] + p[index];
            index++;
		}
		return index-1;
	}
	
	public void change(int index,double v)
	{
            index++;
            p[index] = v;
            while (index > 0)
            {
                index /= 2;
                sumP[index] = p[index * 2] + sumP[index * 2];
                if (index * 2 + 1 < p.length)
                    sumP[index] += p[index * 2 + 1] + sumP[index * 2 + 1];
            }
            for(int i = 1;i<p.length;i++)
            	T += p[i];
	}
	
	
}
