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
