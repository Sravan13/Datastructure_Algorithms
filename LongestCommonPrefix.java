/*

	Write a function to find the longest common prefix string amongst an array of strings.
	
	If there is no common prefix, return an empty string "".
	
	Example 1:
	
	Input: strs = ["flower","flow","flight"]
	Output: "fl"
	Example 2:
	
	Input: strs = ["dog","racecar","car"]
	Output: ""
	Explanation: There is no common prefix among the input strings.

*/

public class LongestCommonPrefix {

	public static void main(String[] args) {
		
		//String [] strs = {"flower","flow","flight"};
		
		String [] strs = {"dog","racecar","car"};

		System.out.println(longestCommonPrefix(strs));
	}
	
	public static String longestCommonPrefix(String[] strs) {
		
		StringBuffer buffer = new StringBuffer("");
		
		if(strs.length == 0) return buffer.toString();
		
		char [] chars = strs[0].toCharArray();
		
		for(int i=0;i< chars.length;i++) {
			
			for(int j=1;j<strs.length;j++) {
				
				if(!( i < strs[j].length() && chars[i] == strs[j].charAt(i) )) {
					return buffer.toString();
				}
				
			}
			
			buffer.append(chars[i]);
		}
		
		return buffer.toString();
		
	        
	}

}
