import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei. Notice that you can only attend one event at any time d.

Return the maximum number of events you can attend.

 

Example 1:


Input: events = [[1,2],[2,3],[3,4]]
Output: 3
Explanation: You can attend all the three events.
One way to attend them all is as shown.
Attend the first event on day 1.
Attend the second event on day 2.
Attend the third event on day 3.
Example 2:

Input: events= [[1,2],[2,3],[3,4],[1,2]]
Output: 4
Example 3:

Input: events = [[1,4],[4,4],[2,2],[3,4],[1,1]]
Output: 4
Example 4:

Input: events = [[1,100000]]
Output: 1
Example 5:

Input: events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
Output: 7
 

Constraints:

1 <= events.length <= 105
events[i].length == 2
1 <= startDayi <= endDayi <= 105
 */

public class MaximumNumberOfEventsThatCanBeAttended {

	public static void main(String[] args) {
		
		//int [][] events = {{1,4},{4,4},{2,2},{3,4},{1,1}};
		//int [][] events = {{1,2},{2,3},{3,4},{1,2}};
		//int [][] events = {{1,100000}};
		//int [][] events = {{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7}};
		//int [][] events = {{1,10},{2,2},{2,2},{2,2},{2,2}};
		int [][] events = {{1,5},{1,5},{1,5},{2,3},{2,3}};
		
		
		System.out.println(maxEvents(events));
		
	}
	
	 public static int maxEvents(int[][] events) {
	        int totalDays = 0;
	        for(int[] event: events) totalDays = Math.max(totalDays, event[1]); //n
	        
	        Comparator<int[]> comparator = new Comparator<int[]>(){
	            public int compare(int[] event1, int[] event2){
	                if(event1[0] != event2[0]){
	                    return event1[0] - event2[0]; //by start date
	                }else{
	                    return event1[1] - event2[1]; //by end date
	                }
	            }
	        };
	        Arrays.sort(events, comparator); //nlogn
	        
	        //a queue to maintain events in ascending order of their end date
	        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
	            public int compare(int[] event, int[] event2){
	                return event[1] - event2[1];
	            }
	        }); //nlogn: since each event is added only once as you'll see below
	        int ans = 0;
	        int day = 1;
	        int index = 0;
	        
	        while(day <= totalDays){
	            //browse ongoing meetings and add to pq
	            while(index < events.length && events[index][0] <= day && day <= events[index][1]) {
	                pq.add(events[index]);
	                index++;
	            }
	            
	            //pop the closest ending meeting
	            if(!pq.isEmpty()){
	                int[] eventWithClosestEndingDate = pq.poll();
	                ans++; //attend it
	            }
	            
	            //go to next day
	            day++;
	            
	            //delete any remaining events in the queue, that ended yesterday
	            while(!pq.isEmpty()){
	                int[] event = pq.peek();
	                if(event[1] < day){
	                    pq.poll();
	                }else{
	                    break;
	                }
	            }
	        }
	        
	        
	        return ans;
	    }
    


}
