package myCharpter6_2;

public class MyBTree<Key extends Comparable<Key>,Value> {
	private int num = 6;
	private MyPage<Key> root = new MyPage<Key>(true,num);
	
	public MyBTree(Key sentinel,Value val)
	{ put(sentinel,val);}
	public boolean contains(Key key)
	{ return contains(root,key);}
	
	private boolean contains(MyPage<Key> h,Key key) {
		if(h.isExternal()) return h.contains(key);
		return contains(h.next(key),key);
	}
	
	public Value get(Key key)
	{ return get(root,key);}
	
	private Value get(MyPage<Key> h,Key key) {
		if(h.isExternal()) return (Value) h.get(key);
		return get(h.next(key),key);
	}
	
	public int size()
	{ return size(root)-1;}
	
	private int size(MyPage<Key> h) {
		int N = 0;
		if(h.isExternal()) return h.size();
		for(Key key : h.keys())
			N += size((MyPage<Key>)h.get(key));
		return N;
	}
	
	public void put(Key key,Value val) {
		put(root,key,val);
		if(root.isFull()) {
			MyPage<Key> lefthalf = root;
			MyPage<Key> righthalf = root.split();
			root = new MyPage<Key>(false,num);
			root.put(lefthalf);
			root.put(righthalf);
		}
	}
	
	public void put(MyPage<Key> h,Key key,Value val) {
		if(h.isExternal()) {h.put(key,val); return;}
		
		MyPage<Key> next = h.next(key);
		put(next,key,val);
		if(next.isFull())
			h.put(next.split());
		next.close();
	}
	
	public Key min()
	{ return min(root);}
	
	private Key min(MyPage<Key> h) {
		if(h.isExternal()) return h.select(1);
		return min((MyPage<Key>)h.get(h.select(0)));
	}
	
	public Key max()
	{ return max(root);}
	
	private Key max(MyPage<Key> h) {
		if(h.isExternal()) return h.select(h.size()-1);
		return max((MyPage<Key>)h.get(h.select(h.size()-1)));
	}
	
	public void deleteMin() 
	{ deleteMin(root);}
		
	private void deleteMin(MyPage<Key> h) {
		if(h.isExternal()) {h.deleteSelect(1); return;}
		deleteMin((MyPage<Key>)h.get(h.select(0)));
	}
	
	public void deleteMax() 
	{ deleteMax(root);}
		
	private void deleteMax(MyPage<Key> h) {
		if(h.isExternal()) {h.deleteSelect(h.size()-1); return;}
		deleteMax((MyPage<Key>)h.get(h.select(h.size()-1)));
	}
	
	public Key floor(Key key) {
		if(contains(key)) return key;
		return floor(root,key);
	}
	
	private Key floor(MyPage<Key> h,Key key) {
		if(h.isExternal()) 	return h.pageFloor(key);
		return 				floor(h.next(key),key);
	}
	
	public Key ceiling(Key key) {
		if(contains(key)) return key;
		return ceiling(root,key);
	}
	
	private Key ceiling(MyPage<Key> h,Key key) {
		if(h.isExternal()) 	return h.pageCeiling(key);
		Key answer = ceiling(h.next(key),key);
		if(answer==null) return h.pageCeiling(key);
		return answer;
	}
	
	public static void main(String[] args) {
		MyBTree<String,Integer> B = new MyBTree<String,Integer>("",0);
		B.put("U", 1);
		B.put("Z", 2);
		B.put("F", 3);
		B.put("J", 4);
		B.put("D", 5);
		B.put("G", 6);
		B.put("J", 7);
		B.put("L", 8);
		B.put("T", 9);
		B.put("A", 9);
		B.put("P", 9);
		System.out.println(B.ceiling("K"));
	}
}
