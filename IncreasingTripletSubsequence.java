/*
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:

Return true if there exists i, j, k
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

Example 1:

Input: [1,2,3,4,5]
Output: true
Example 2:

Input: [5,4,3,2,1]
Output: false
 */


public class IncreasingTripletSubsequence {

	public static void main(String[] args) {
		int [] nums = {1,2,3,4,5};
		//int [] nums = {2,4,-2,-3};
		IncreasingTripletSubsequence tripletSubsequence = new IncreasingTripletSubsequence();
		System.out.println(tripletSubsequence.increasingTriplet(nums));
	}
	
	public boolean increasingTriplet(int[] nums) {
		
		int [] storage = new int[3];
		
		for(int i=0;i<3;i++) {
			storage[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<nums.length;i++) {
			
			int x=0;
			
			if(nums[i] <= storage[0]) {
				x=1;
				storage[0] = nums[i];
			}else if(nums[i] <= storage[1]) {
				x=2;
				storage[1] = nums[i];
			}else if(nums[i] <= storage[2]) {
				x=3;
				storage[2] = nums[i];
			}
			
			if(x==3) return true;
		}
		
		return  false;
        
    }
	
	

}
