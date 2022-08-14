package myCharpter2_5;

import java.util.Comparator;

public class CheckIndex{
	private int index;
	private Comparable key;
	public CheckIndex(int index,Comparable key) 
	{this.index = index; this.key = key;}
	public int checkIndex()
	{return index;}
	public Comparable checkKey()
	{return key;}
	public void checkChange(int index,Comparable key)
	{this.index = index; this.key = key;}
	public static class KeyOrder implements Comparator<CheckIndex>{
		public int compare(CheckIndex v,CheckIndex w)
		{
			return v.checkKey().compareTo(w.checkKey());
		}	
	}
	public static class IndexOrder implements Comparator<CheckIndex>{
		public int compare(CheckIndex v,CheckIndex w)
		{
			if(v.checkIndex()<w.checkIndex()) return -1;
			if(v.checkIndex()>w.checkIndex()) return +1;
			return 0;
		}	
	}
	
}
