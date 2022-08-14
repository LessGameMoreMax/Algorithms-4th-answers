package myCharpter6_2;

import edu.princeton.cs.algs4.BinarySearchST;

public class MyPage <Key extends Comparable<Key>> {
	private BinarySearchST<Key,Object> st;
	private boolean isExternal;
	private int num;
	
	public MyPage(){
		st = new BinarySearchST<Key,Object>();
	}
	
	public MyPage(boolean bottom,int num) {
		this();
		isExternal = bottom;
		this.num = num;
	}
	
	public void close() {
	}
	
	public void put(Key key,Object val) {
		if(!isExternal) throw new RuntimeException("Sorry! this is not external!");
		st.put(key, val);
	}
	
	public void put(MyPage<Key> p) {
		if(isExternal) throw new RuntimeException("Sorry! this is external!");
		st.put(p.st.min(),p);
	}
	
	public boolean isExternal()
	{ return isExternal;}
	
	public boolean contains(Key key)
	{ return st.contains(key);}
	
	public MyPage<Key> next(Key key){
		if(isExternal()) return null;
		return (MyPage<Key>)st.get(st.floor(key));
	}
	
	public boolean isFull() {
		if(st.size()==num) return true;
		return false;
	}
	
	public int size()
	{ return st.size();}
	
	public Object get(Key key) {
		if(!st.contains(key)) return null;
		return st.get(key);
	}
	
	public MyPage<Key> split(){
		MyPage<Key> p = new MyPage<Key>(isExternal,num);
		if(!isExternal)
			for(int i = 0;i<num/2;i++) {
				p.put((MyPage<Key>)st.get(st.max()));
				st.deleteMax();
			}
		else
			for(int i = 0;i<num/2;i++) {
				p.put(st.max(),st.get(st.max()));
				st.deleteMax();
			}
		return p;
	}
	
	public Iterable<Key> keys()
	{return st.keys();}
	
	public Key select(int r){
		if(r==st.size()||r==-1) throw new RuntimeException("Sorry,this select process is wrong!");
		return st.select(r);
	}
	
	public void deleteSelect(int r){
		if(r==st.size()||r==-1) throw new RuntimeException("Sorry,this delete process is wrong!");
		st.delete(st.select(r));
	}
	
	public Key pageMax()
	{ return st.max();}
	
	public Key pageFloor(Key key)
	{return st.floor(key);}
	
	public Key pageCeiling(Key key){
		if(key.compareTo(st.max())>0) return null;
		return st.ceiling(key);
	}
}
