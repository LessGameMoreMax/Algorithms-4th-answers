package myCharpter3_4;

public class StringhashAttack {
	public static void main(String[] args) {
		addChar(3);
	}
	
	public static void addChar(int length) 
	{ addChar("",length);}
	
	private static void addChar(String a,int length) {
		if(a.length()>=length) {
			System.out.println(a);
			return;
		}
		for(int i = 65;i<123;i++) {
			if(i==91) i = 97;
			addChar(a+(char)i,length);
		}
	}
}
