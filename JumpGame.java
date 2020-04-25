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

 */

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [3,2,1,0,4]
		int [] nums = {2,0};
		
		JumpGame game = new JumpGame();
		System.out.println(game.canJump(nums));
	}
	
	public boolean canJump(int[] nums) {
		
        int len = nums.length; 
        if(len == 1) return true;
        
        int jumps = nums[0];
        
        for(int i=jumps;i>=1 ;i--) {
        	 if( i < len && jumps(nums,i,len-1)) return true;
        }
        
        return false;
        
    }
	
	public boolean jumps(int[] nums,int lowIdx,int len) {
		
		if(lowIdx == len) {
			return true;
		}else {
			int jumps = nums[lowIdx];
			
			for(int i=jumps; i>=1; i--) {
				if(((lowIdx+i) <= len) && jumps(nums,lowIdx+i,len)) {
					return true;
				}
	        }
			
			return false;
			
		}
		
	}

}
