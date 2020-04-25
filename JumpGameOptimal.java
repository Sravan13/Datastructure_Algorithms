/*
 * 
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
jump length is 0, which makes it impossible to reach the last index.

HINT :  we can see that the basic idea is to iterate the array elements, 
note down the maximum steps we can reach for each index. Then determine if the maximum length is greater or equals to  the index of last element.

 */

public class JumpGameOptimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [3,2,1,0,4]
		int [] nums = {3,2,1,0,4};
		
		JumpGameOptimal game = new JumpGameOptimal();
		System.out.println(game.canJump(nums));
	}
	
	public boolean canJump(int[] nums) {
		
        int len = nums.length; 
        if(len == 1) return true;
        
        if(nums[0] == 0 && len > 1) return false;
        
        int max = 0;
        for(int i=0; i<len; i++) {
        	
        	if(i<=max && i+nums[i]> max) {
        		max = i+nums[i];
        	}else if(i > max) {
        		return false;
        	}
        	
        }
        
        return max >= len-1;
        
       
        
    }
	


}
