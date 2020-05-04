
/*
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its 
 * binary representation.

 

Example 1:

Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to 
output 2.
 

Example 2:

Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0
 */
public class NumberComplement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NumberComplement numberComplement = new NumberComplement();
		System.out.println(numberComplement.findComplement(0));

	}
	
	 public int findComplement(int num) {
		 
		 int n = num;
		 
		 int pow = 0;
		 int complement = 0;
		 while(n > 1) {
			 
			 int rem  = ( n%2 == 0 ) ? 1 : 0;
			 n=n/2;
			 
			 complement+=( rem * Math.pow(2,pow));
			 pow++;
		 }
		 complement+=( (n==1 ? 0 : 1) * Math.pow(2,pow));
		 
		 return complement;
	        
	 }

}
