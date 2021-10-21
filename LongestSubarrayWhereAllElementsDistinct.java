import java.util.Iterator;
import java.util.LinkedHashSet;

/*
 * Given an array of elements, return the length of the longest subarray where all its elements are distinct. For example, given the array [5, 1, 3, 5, 2, 3, 4, 1], 
 * return 5 as the longest subarray of distinct elements is [5, 2, 3, 4, 1].
 */

public class LongestSubarrayWhereAllElementsDistinct {

	public static void main(String[] args) {
		
		//int [] arr = {5, 1, 3, 5, 2, 3, 4, 1};
		int [] arr = {1,1,1, 1};
		
		LongestUniqueSubString(arr);

	}
	
	private static int LongestUniqueSubString(int [] arr){

		int maxLength = 0;
		
		LinkedHashSet<Integer> set = new LinkedHashSet<>();
		
		for(int i : arr){
		   
			if(set.contains(i)){
			
				if(maxLength<set.size()){
					maxLength = set.size();
				}

				Iterator<Integer> itr = set.iterator();
				while(itr.hasNext()){					
					int x = itr.next();
					itr.remove();
					
					if(i == x) {
						break;
					}					
				}
				
				set.add(i);
				
			}else{
				set.add(i);
			}	
					
		}
		
		if(maxLength<set.size()){
			maxLength = set.size();
		}
		
		return maxLength;

	}

}
