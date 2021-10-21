// Input : arr[] = {5, 5, 10, 100, 10, 5}. Output : 110
public class MaximumSumNoTwoElementsAdjacent {

	public static void main(String[] args) {
		
		int [] arr = {5, 5, 10, 100, 10, 5};
		
		System.out.println(getMaximumSumNoTwoElementsAdjacent(arr));
		
	}
	
	private static int getMaximumSumNoTwoElementsAdjacent(int [] arr) {
		
		int exclude_prev = 0;
		int include_prev = arr[0];
		
		for(int i=1;i<arr.length;i++) {
			
			int exlcude_new = exclude_prev > include_prev ? exclude_prev : include_prev;
			
			include_prev = exclude_prev + arr[i];
			exclude_prev = exlcude_new;
			
		}
		
		
		return  exclude_prev > include_prev ? exclude_prev :  include_prev;		
	}

}
