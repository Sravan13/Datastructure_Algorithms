
public class ValidParenthesisString {

	public static void main(String[] args) {
		
		String str = "(*()";
		
		System.out.println(checkValidString(str));
	}
	
	public static boolean checkValidString(String s) {
        
		String emptyString = s.replaceAll("\\*", "");
		
		if(checkForBalance(emptyString)) {
			return true;
		}else{
			String leftString = s.replaceAll("\\*", "(");
			
			if(checkForBalance(leftString)) {
				return true;
			}else {
				String rightString = s.replaceAll("\\*", ")");
				
				if(checkForBalance(rightString)) {
					return true;
				}
				
				return false;
			}
		}
		
    }
	
	public static boolean checkForBalance(String str){
		
		char [] chars = str.toCharArray();
		
		int count = 0;
		for(char c : chars) {
			if(c == '(') {
				count++;
			}else if(c == ')') {
				count--;
			}
			
			if(count<0) return false;
		}
		
		return (count == 0);
	}

}
