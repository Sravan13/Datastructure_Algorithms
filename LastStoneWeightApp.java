import java.util.Arrays;
import java.util.LinkedList;

/*
We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)

 

Example 1:

Input: [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 

Note:

1 <= stones.length <= 30
1 <= stones[i] <= 1000

*/

public class LastStoneWeightApp {

	public static void main(String[] args) {
		//int arr []= {2,7,4,1,8,1};
		int arr [] = {10,10,7,2};
		lastStoneWeight(arr);
	}
	
	public static int lastStoneWeight(int[] stones) {
		
		if(stones.length == 1) return stones[0];
		
		Arrays.sort(stones);
		
		LinkedList<Integer> stoneList = new LinkedList<Integer>();
		for(int i=0;i<stones.length;i++) {
			stoneList.add(stones[i]);
		}
		
		while(stoneList.size() > 1) {
			
			int listSize = stoneList.size();
			int diff = stoneList.getLast() - stoneList.get(listSize-2);
			
			stoneList.remove(listSize-1);		
			
			if(listSize > 0)
			stoneList.remove(stoneList.size()-1);
			
			listSize = stoneList.size();
			
			if( listSize > 0 && diff > 0) {
				int index = findIndexPosition(0, listSize-1, stoneList, diff);				
				stoneList.add(index, diff);
				
			}else if(listSize==0){
				stoneList.add(diff);
				break;
			}
		}
		
		return stoneList.get(0);
        
    }
	
	public static int findIndexPosition(int low, int high, LinkedList<Integer> stoneList,int item){
		
		int stonesLen = high - low + 1;
		
		if(stonesLen <= 2) {
			
			if(stoneList.get(low) == item) 
			{	return low;
			}else if(item < stoneList.get(low)) {
				return low;
			}else if(item > stoneList.get(high)) {
				return high+1;
			}
			else {
				return high;
			}
			
		}else {
			
			int mid = low+ (high-low)/2;
			
			if(item < stoneList.get(mid)) {
				return findIndexPosition(low, mid-1,stoneList,item);
			}else if(item > stoneList.get(mid)) {
				return findIndexPosition(mid+1, high,stoneList,item);
			}else {
				return mid;
			}
			
		}
		
		
		
	}

}
