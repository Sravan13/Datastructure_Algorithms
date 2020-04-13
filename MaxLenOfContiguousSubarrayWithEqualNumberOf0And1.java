
/*
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
*/


public class MaxLenOfContiguousSubarrayWithEqualNumberOf0And1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1};
		System.out.println(findMaxLength(nums));

	}
	
	public static int findMaxLength(int[] nums) {
		
		int numLen = nums.length;
		
		if(numLen == 0 || numLen == 1) return 0;
		
		int [] tempNums = new int[nums.length];
		
		int zeroCount =0;
		int oneCount = 0;
		
		for(int i=numLen-1;i>=0;i--) {
			
			if(nums[i]==0) zeroCount++;
			else oneCount++;
			
			tempNums[numLen-1-i] = nums[i];
		}
		
		if(zeroCount == oneCount ) return zeroCount+oneCount;
		
		MaxSubPojo firstPojo = new MaxSubPojo();
		
		objectbackTrackMaxLength(0, nums.length-1,nums,firstPojo );
		
		
		MaxSubPojo secondPojo = new MaxSubPojo();
		objectbackTrackMaxLength(0, numLen-1,tempNums,secondPojo );
	        
		int max = firstPojo.getMax() > secondPojo.getMax() ? firstPojo.getMax()  : secondPojo.getMax();
		
		return styrenicArray (nums , zeroCount, oneCount, max);
	}
	
	public static int styrenicArray (int [] nums , int zeroCount, int oneCount, int max){
		
		for(int i=0,j=nums.length-1;i<j;i++,j--) {
			
			
			if(nums[i] == 0 ) 
				zeroCount--; 
			else oneCount--;
			
			if(zeroCount == oneCount && (zeroCount + oneCount) > max) {
				 max = (zeroCount + oneCount);
			}
			
			if(nums[j] == 0 ) 
				zeroCount--; 
			else oneCount--;
			
			if(zeroCount == oneCount && (zeroCount + oneCount) > max) {
				 max = (zeroCount + oneCount);
			}
			
		}
		
		
		
		return max;
		
	}
	
	public static MaxSubPojo objectbackTrackMaxLength(int low,int high,int [] nums,MaxSubPojo pojo){
		
		if((high -low) > 1) {
			
			objectbackTrackMaxLength(low+1,high,nums,pojo);
			
			if(nums[low] == 0) {
				pojo.setZeroCount(pojo.getZeroCount()+1);
			}else {
				pojo.setOneCount(pojo.getOneCount()+1);
			}
			
			if(pojo.zeroCount == pojo.oneCount && (pojo.zeroCount + pojo.oneCount) > pojo.getMax()) {
				 pojo.setMax(pojo.zeroCount + pojo.oneCount);
			}
			
			return pojo;
			
		}else {
			
			if(nums[low] == 0) {
				pojo.setZeroCount(pojo.getZeroCount()+1);
			}else {
				pojo.setOneCount(pojo.getOneCount()+1);
			}
			
			if(nums[high] == 0) {
				pojo.setZeroCount(pojo.getZeroCount()+1);
			}else {
				pojo.setOneCount(pojo.getOneCount()+1);
			}
			
			if(pojo.zeroCount == pojo.oneCount && (pojo.zeroCount + pojo.oneCount) > pojo.getMax()) {
				 pojo.setMax(pojo.zeroCount + pojo.oneCount);
			}
			
			return pojo;
			
		}
	}
	
	
}

class MaxSubPojo {
	int zeroCount;
	int oneCount;
	int max;
	
	public MaxSubPojo() {
		super();
		this.zeroCount = 0;
		this.oneCount = 0;
		this.max = 0;
	}

	public int getZeroCount() {
		return zeroCount;
	}

	public void setZeroCount(int zeroCount) {
		this.zeroCount = zeroCount;
	}

	public int getOneCount() {
		return oneCount;
	}

	public void setOneCount(int oneCount) {
		this.oneCount = oneCount;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
	
	
	
	
}
