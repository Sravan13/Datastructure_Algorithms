
/*
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

 */

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums  = {4,5,6,7,0,1,2};//{4,5,6,7,8,1,2,3};
		System.out.println(search(nums, 0));
	}
	
    public static int search(int[] nums, int target) {
    	return binaryAdvanceSearch(0, nums.length-1, nums , target);
    }
    
   public static int  binaryAdvanceSearch(int low, int high, int [] nums , int target){
	   
	   if(low > high) return -1;
	   
	   int mid = low + (high-low)/2;
	   
	  
	   if(nums[mid] < target && nums[high] < target && nums[low] > nums[mid]) {
		   return binaryAdvanceSearch(low,mid-1,nums,target);
	   }
	   else if(nums[mid] <  target ) {
		   return binaryAdvanceSearch(mid+1,high, nums, target);
	   }
	   else if(nums[mid] > target && nums[low] > target && nums[mid] > nums[high]) {
		   return binaryAdvanceSearch(mid+1,high, nums, target);
	   }
	   else if(nums[mid] > target ) {
		   return binaryAdvanceSearch(low,mid-1, nums, target);
	   }else {
		   //if(nums[mid] == target) {
			   return mid;
		  // }
	   }
    	
    }

}
