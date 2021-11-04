import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8

 */
public class GenerateParentheses {

	public static void main(String[] args) {	
		GenerateParentheses generateParentheses = new GenerateParentheses();
		generateParentheses.generateParenthesis(3);
	}
	
	public List<String> generateParenthesis(int n){
		
		if(n<1) return Collections.EMPTY_LIST;
		
		char [] strArr = new char[2*n];
		
		List<String> list = new ArrayList<String>();
		
		printParantheses(strArr, n, 0, 0, 0,list);
		
		return list;
		
		
	}
	
	private static void printParantheses(char [] strArr,int n,int pos, int open, int close, List<String> list) {
		
		if(close == n) {	
			list.add(new String(strArr));
		}
		
		
		if(open > close) {
			strArr[pos]='}';
			printParantheses(strArr, n,pos+1, open, close+1,list);
		}
		
		if(open < n) {
			strArr[pos]='{';
			printParantheses(strArr, n,pos+1, open+1, close,list);
		}
		
	}
	
	

}
