package myCharpter5_3;

public class BruteTotalRight {
	public static int search(String txt,String pat) {
		for(int i = txt.length()-pat.length();i>=0;i--) {
			int j;
			for(j = pat.length()-1;j>=0;j--) 
				if(txt.charAt(i+j)!=pat.charAt(j)) break;
			if(j==-1) return i;
		}
		return txt.length();
	}
	
	public static void main(String[] args) {
		System.out.println(search("aafgahanfaujjeifh","han"));
	}
}
