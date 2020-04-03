
public class MaxSubArrayApp {

	public static void main(String[] args) {
		
		int [] arr = {-2,1,-3,4,-1,2,1,-5,4};
		
		System.out.println(maxSubArray(arr));

	}
		
	public static int maxSubArray(int[] nums) {
		
		int max = Integer.MIN_VALUE;	
		
		
		return getMaxSubArray(0,nums,max);	        
	}
		
	public static int getMaxSubArray(int idx , int [] nums,int max){
		
		if(idx == nums.length) return max;
		
		int x = nums[idx];
		if(x > max) {
			max = x;
		}
				
		for(int i=idx+1;i < nums.length; i++) {
			x+=nums[i];
			
			if(x > max) {
				max = x;
			}
		}
		
		return getMaxSubArray(idx+1 , nums, max);
			
	}
	
	

}
