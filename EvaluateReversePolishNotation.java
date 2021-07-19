import java.util.Stack;

/**
 * 
 * Evaluate Reverse Polish Notation ::

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

Note that division between two integers should truncate toward zero.

It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.

 

Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 

Constraints:

1 <= tokens.length <= 104
tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].

*/



public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String [] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		String [] tokens = {"4","13","5","/","+"};
		EvaluateReversePolishNotation polishNotation = new EvaluateReversePolishNotation();
		System.out.println(polishNotation.evalRPN(tokens));
	}
	
    public int evalRPN(String[] tokens) {

		Stack<Integer> stack = new Stack<Integer>();
	
		for(String item : tokens){
			boolean isNumber = isNumeric(item);
			
			if(!isNumber){
				Integer secondOperand = stack.pop();
				Integer firstOperand  = stack.pop();
				
				Integer result = evaluteExpression(firstOperand,secondOperand,item);
				
				stack.push(result); 
			}else{
				stack.push(Integer.parseInt(item));
			}
		}
	
		return stack.pop();
        
    }
    
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    public static Integer evaluteExpression(int firstOperand,int secondOperand, String operator) {
    	
    	switch (operator) {    	
			case "+":	
				return firstOperand+secondOperand;				
			case "-":			
				return firstOperand-secondOperand;
			case "*":			
				return firstOperand*secondOperand;
			case "/":			
				return firstOperand/secondOperand;
		}
    	
    	return null;
    	
    }

}
