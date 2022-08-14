package myCharpter3_4;

public class BadSelect {
	public static void main(String[] args) {
		String[] s = {
				"ABCDEF",
				"FECDAB",
				"DABCFE",
				"FABCDE"
		};
		for(int i = 0;i<s.length;i++) {
			int hash = 0;
			for(int j = 0;j<s[i].length();j++)
				hash = (256 * hash + s[i].charAt(j)) % 255;
			System.out.println(hash);
		}
		
	}
}
