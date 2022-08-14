package myCharpter3_2;

public class BSTByArray <Key extends Comparable<Key>,Value>{
	private Key keys[];
	private Value vals[];
	private Integer lefts[];
	private Integer rights[];
	private int N;
	
	public BSTByArray(int num) {
		keys = (Key[])new Comparable[num];
		vals = (Value[])new Object[num];
		lefts = new Integer[num];
		rights = new Integer[num];
	}
	
	public int size()
	{ return N;}
	
	public Value get(Key key)
	{ return get(0,key);}
	
	public Value get(int index,Key key) {
		if(keys[index]==null) return null;
		int cmp = key.compareTo(keys[index]);
		if(cmp < 0) return get(lefts[index],key);
		else if(cmp>0) return get(rights[index],key);
		else 	return vals[index];
	}
	
	public void put(Key key,Value val)
	{ put(0,key,val);}
	
	private int put(Integer index,Key key,Value val) {
		if(index==null||keys[index]==null) {
			keys[N] = key;
			vals[N] = val;
			return N++;
		}
		int cmp = key.compareTo(keys[index]);
		if(cmp<0) lefts[index] = put(lefts[index],key,val);
		else if(cmp>0) rights[index] = put(rights[index],key,val);
		else	vals[index] = val;
		return index;
	}
	
	public static void main(String[] args) {
		BSTByArray<String,Integer> test = new BSTByArray<String,Integer>(10);
		test.put("S", 0);
		test.put("E", 1);
		test.put("A", 2);
		test.put("R", 3);
		test.put("C", 4);
		test.put("H", 5);
		test.put("E", 6);
		test.put("X", 7);
		test.put("A", 8);
		test.put("M", 9);
		System.out.println(test.get("C"));
		System.out.println(test.get("A"));
		System.out.println(test.get("H"));
		System.out.println(test.get("E"));
		System.out.println(test.get("M"));
		System.out.println(test.get("S"));
		System.out.println(test.get("X"));
	}
}
