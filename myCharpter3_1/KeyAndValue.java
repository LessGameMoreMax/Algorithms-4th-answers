package myCharpter3_1;

public class KeyAndValue <Key extends Comparable<Key>,Value>{
	private Key key;
	private Value val;
	
	public KeyAndValue(Key key,Value val) {
		this.key = key;
		this.val = val;
	}
	
	public Key getKey()
	{ return key;}
	
	public Value getValue()
	{ return val;}
	
	public void changeKey(Key key)
	{ this.key = key;}
	
	public void changeValue(Value val)
	{ this.val = val;}
	
}
