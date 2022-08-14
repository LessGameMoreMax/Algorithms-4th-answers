package myCharpter5_3;

public class Palindrome {
	public static boolean isPalindrome(String txt) {
		int begin = 0;
		int end = txt.length()-1;
		while(begin<=txt.length()/2-1)
			if(txt.charAt(begin++)!=txt.charAt(end--))
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("aa"));
	}
}
