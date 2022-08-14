package myCharpter5_3;

public class BruteChar {
	char[] pat;
	public BruteChar(String pat) {
		this.pat = new char[pat.length()];
		for(int i = 0;i<pat.length();i++)
			this.pat[i] = pat.charAt(i);
	}
	
	public int search(String txt) {
		char[] txtChar = new char[txt.length()];
		for(int i = 0;i<txt.length();i++)
			txtChar[i] = txt.charAt(i);
		for(int i = 0;i<=txtChar.length-this.pat.length;i++) {
			int j;
			for(j = 0;j<pat.length;j++)
				if(txtChar[i+j]!=pat[j]) break;
			if(j==pat.length) return i;
		}
		return txt.length();
	}
}
