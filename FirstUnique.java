import java.util.LinkedHashMap;
import java.util.Map;

/*
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.

Implement the FirstUnique class:

FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
void add(int value) insert value to the queue.
 

Example 1:

Input: 
["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
[[[2,3,5]],[],[5],[],[2],[],[3],[]]
Output: 
[null,2,null,2,null,3,null,-1]

Explanation: 
FirstUnique firstUnique = new FirstUnique([2,3,5]);
firstUnique.showFirstUnique(); // return 2
firstUnique.add(5);            // the queue is now [2,3,5,5]
firstUnique.showFirstUnique(); // return 2
firstUnique.add(2);            // the queue is now [2,3,5,5,2]
firstUnique.showFirstUnique(); // return 3
firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
firstUnique.showFirstUnique(); // return -1
 * 
 * 
 * */

public class FirstUnique {
	
	private LinkedHashMap<Integer,Integer> map;

	public static void main(String[] args) {

	}

	public FirstUnique(int[] nums) {
		map = new LinkedHashMap<>();
		
		for(int i=0;i<nums.length;i++) {
			
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i])+1);
			}else {
				map.put(nums[i], 1);
			}
			
		}
	}

	public int showFirstUnique() {

		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {			
			if(entry.getValue() == 1) return entry.getKey();
		}
		
		return -1;
	}

	public void add(int value) {
		
		if(map.containsKey(value)) {
			map.put(value, map.get(value)+1);
		}else {
			map.put(value, 1);
		}

	}

}
