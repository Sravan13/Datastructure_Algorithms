


/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

*/
public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr [] = {0,1,0,3,12};
		moveZeroes(arr);
	}
	
	 public static void moveZeroes(int[] nums) {
		 
		 int nonZeroIdx = 0;
		 
		 
		 for (int i=0;i<nums.length;i++) {
			 
			 if(nums[i]!=0) {				 
				 swap(nonZeroIdx,i,nums);
				 nonZeroIdx++;				 
			 }
		 }
		 
		 for(int i=0;i<nums.length;i++) {
			 System.out.print(nums[i]);
		 }
	        
	 }
	 
	public static void swap(int i,int j ,int[] nums){
		  int temp = nums[i];
		  nums[i] = nums[j];
		  nums[j] = temp;
	 }

}
