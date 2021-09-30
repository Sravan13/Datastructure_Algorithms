


/*
You are given an integer num. You can swap two digits at most once to get the maximum valued number.

Return the maximum valued number you can get.

 

Example 1:

Input: num = 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:

Input: num = 9973
Output: 9973
Explanation: No swap.
 

Constraints:

0 <= num <= 108

*/

public class MaximumNumberUsingAtMostOneSwapOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(smallestNumber(756776));

	}
	
	public static Integer smallestNumber(int num){

		String x= num+"";
		char [] chars = x.toCharArray();
		int n = chars.length;
        
       
        
		int [] rightMin = new int[n];
		rightMin[n-1]=-1;
		
		int right = n-1;
		for(int i=n-2; i>=0; i--){		

			if(chars[i] < chars[right]){
				rightMin[i] = right;
			}else{
				rightMin[i] = -1;
                
                if(chars[i] > chars[right])
                right = i;
			}

		}

		int max = -1;
		
		for(int i=1;i<n;i++){
			
			if(chars[0]!='9'){
				
				if(max == -1){
					if(chars[i] >= chars[0]){
						max = i;
					}
				}else{
					if(chars[i] >= chars[max]){
						max = i;
					}
				}
			}
			
		}

		if(max!=-1 && chars[0]!=chars[max]){
			char c  = chars[0];
			chars[0] = chars[max];
			chars[max] = c;
		}else{
			for(int i=1;i<n;i++){
				if(rightMin[i]!=-1){
					char c  = chars[i];
					chars[i] = chars[rightMin[i]];
					chars[rightMin[i]] = c;	
					break;	
				}			
			}
		}

		return Integer.parseInt(new String(chars));	

	}

}
