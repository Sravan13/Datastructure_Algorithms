/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".

*/

public class BackspaceStringCompare {
	
	public static void main(String[] args) {
		
		
		System.out.println(backspaceCompare("a#c", "b"));
	}
	
	 public static  boolean backspaceCompare(String S, String T) {
		 
		
		String src =  getFinalString(S.toCharArray());
		String target =  getFinalString(T.toCharArray());
		
		return src.equals(target);
		 	        
	 }
	 
	 public static String getFinalString(char [] srcArr){
		 
		 StringBuffer resultantStr = new StringBuffer();
		 for(int i =0;i < srcArr.length;i++) {
			 if( srcArr[i] == '#') {
				 int len = resultantStr.length(); 
				 if(len > 0) {
					 resultantStr.deleteCharAt(len-1);
				 }
			 }else {
				 resultantStr.append(srcArr[i]);
			 }
		 }
		 
		 return resultantStr.toString();
		 
	 }

}
