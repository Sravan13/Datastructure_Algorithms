/*
	Given an array, rotate the array to the right by k steps, where k is non-negative.
	
	Example 1:
	
	Input: nums = [1,2,3,4,5,6,7], k = 3
	Output: [5,6,7,1,2,3,4]
	Explanation:
	rotate 1 steps to the right: [7,1,2,3,4,5,6]
	rotate 2 steps to the right: [6,7,1,2,3,4,5]
	rotate 3 steps to the right: [5,6,7,1,2,3,4]
	Example 2:
	
	Input: nums = [-1,-100,3,99], k = 2
	Output: [3,99,-1,-100]
	Explanation: 
	rotate 1 steps to the right: [99,-1,-100,3]
	rotate 2 steps to the right: [3,99,-1,-100]
		
*/

public class RotateArray {

	public static void main(String[] args) {
		
		RotateArray rotateArray = new RotateArray();
		
		int [] nums = {12, 13, 14, 15, 16, 17};
		rotateArray.rotate(nums, 9);
		
	}
	
	public void rotate(int[] nums, int k) {
			int len = nums.length;

			if(len-k < 0) {
				k = (k%len);
			}
				
			int secondHalfStartIndex = len - k;
			int firstHalfEndIndex = secondHalfStartIndex - 1;

			reverse (nums,secondHalfStartIndex,len-1);
			reverse (nums,0,firstHalfEndIndex);
			reverse (nums,0,len-1);
	}

	private void reverse (int[] nums,int startIdx,int endIdx) {
			
			for(int i = startIdx, j = endIdx ; i<j ;i++,j--){
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			} 
	}

}
