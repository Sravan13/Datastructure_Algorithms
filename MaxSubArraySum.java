
public class MaxSubArraySum {

	public static void main(String[] args) {
		
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int n = a.length;
        maxSubArraySum(a);
	}
	
	static void maxSubArraySum(int arr[])
    {
		
		int start = 0;
		int end = 0;
		
		int max_end_here = 0;
		int max_so_far = Integer.MIN_VALUE;
		
		int s= 0;
		
		int i=0;
		while(i< arr.length) {
			
			max_end_here += arr[i];
			
			if(max_end_here > max_so_far) {
				max_so_far = max_end_here;
				start = s;
				end = i;
			}
			
			if(max_end_here < 0) {
				max_end_here = 0;
				s = i+1;
			}
			
			i++;
			
		}
		
		System.out.println(max_so_far);
		System.out.println(start+" "+end);
		
		
    }

}
