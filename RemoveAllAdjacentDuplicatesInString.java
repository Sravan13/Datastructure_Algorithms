/**

You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

 

Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
Example 2:

Input: s = "azxxzy"
Output: "ay"

**/

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

	public static void main(String[] args) {
		
		String	s = "abbaca";
		removeDuplicates(s);
	}
	
	 public static String removeDuplicates(String s) {
	        
	        
	        if(s.length() == 0 || s.length() == 1 ) return s;
	        
	        char [] chars = s.toCharArray();
	        
	        Stack<Character> stack = new Stack<>();
	        stack.push(chars[0]);
	        
	         int i=1;
	         boolean isPreviousMatched = false;
	         
	         while(i<chars.length) {
	        	 
	        	 if(stack.isEmpty()) {
	        		 stack.push(chars[i]);
        			 i++;
	        	 }
	        	 
	        	 char c = stack.peek();
	        	 
	        	 if(c == chars[i]) {
	        		 if(!isPreviousMatched) {
	        			 isPreviousMatched = true;
	        		 }
	        		 i++;
	        	 }else {
	        		 
	        		 if(isPreviousMatched) {
	        			 stack.pop();
	        			 isPreviousMatched = false;
	        		 }else {
	        			 stack.push(chars[i]);
	        			 i++;
	        		 }
	        	 }
	        	 
	        	
	        	 
	         }
	         
	         if(isPreviousMatched) {
    			 stack.pop();
    		 }
	         
	         String x = "";
	         
	        while (!stack.isEmpty()) {
				x=stack.pop()+x;		
			}
	        
	        return x;
	    }

}
