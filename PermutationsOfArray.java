import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.

 */

public class PermutationsOfArray {

	public static void main(String[] args) {
		
		//int [] input = {1,2,3};
		int [] input = {1,2};
		PermutationsOfArray permutationsOfArray = new PermutationsOfArray();
		permutationsOfArray. permute(input);

	}
	
	public List<List<Integer>> permute(int[] nums) {
				
		List<Integer> integers = Arrays.stream(nums).boxed().collect(Collectors.toList());
		int [] target = new int[nums.length];
		
		List<List<Integer>> result =  new ArrayList<>();		
		permutations(integers, target, 0, result);
		
		System.out.println(result);
				
		return result;
		        
	}
	
	private void permutations(List<Integer> integers,int [] target,int pos,List<List<Integer>> result) {
		
		if(integers.isEmpty()) {
			result.add(Arrays.stream(target).boxed().collect(Collectors.toList()));
		}else {
		
			for(int i=0;i<integers.size();i++) {
				
				target[pos] = integers.get(i);
				
				List<Integer> list =  new ArrayList<>();			
				list.addAll(integers.subList(0, i));
				list.addAll(integers.subList(i+1,integers.size()));
								
				permutations(list, target, pos+1, result);	
				
			}
		
		}
	}

}
