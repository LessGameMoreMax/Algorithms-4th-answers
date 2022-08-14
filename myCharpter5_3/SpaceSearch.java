package myCharpter5_3;

public class SpaceSearch {
	public static int search(String txt,int M) {
		for(int i = 0;i<txt.length();i++) {
			if(txt.charAt(i)==' ') {
				int j;
				for(j = 0;j<M;j++)
					if(txt.charAt(i+j)!=' ') break;
				if(j==M) return i;
				else i += j;
			}
		}
		return txt.length();
	}
	
	public static void main(String[] args) {
		System.out.println(search("ad  a   de   ",3));
	}
}
