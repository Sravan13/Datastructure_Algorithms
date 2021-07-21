import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;


/*
 
	Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
	
	However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
	
	Return the least number of units of times that the CPU will take to finish all the given tasks.
	
	 
	
	Example 1:
	
	Input: tasks = ['A','A','A','B','B','B'], n = 2
	Output: 8
	Explanation: 
	A -> B -> idle -> A -> B -> idle -> A -> B
	There is at least 2 units of time between any two same tasks.
	Example 2:
	
	Input: tasks = ['A','A','A','B','B','B'], n = 0
	Output: 6
	Explanation: On this case any permutation of size 6 would work since n = 0.
	['A','A','A','B','B','B']
	['A','B','A','B','A','B']
	['B','B','B','A','A','A']
	...
	And so on.
	Example 3:
	
	Input: tasks = ['A','A','A','A','A','A','B','C','D','E','F','G'], n = 2
	Output: 16
	Explanation: 
	One possible solution is
	A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
	 
	
	Constraints:
	
	1 <= task.length <= 104
	tasks[i] is upper-case English letter.
	The integer n is in the range [0, 100].
 
 */

public class TaskSchedulerOptimization {

	public static void main(String[] args) {
		
		//char [] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
		char [] tasks = {'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E'};
		//char [] tasks = {'A','A','A','B','B','B'};
		
		
		TaskSchedulerOptimization scheduler = new TaskSchedulerOptimization();
		System.out.println(scheduler.leastInterval(tasks,2));
		
	}
	
    public int leastInterval(char[] tasks, int n) {
    	
    	Map<Character, Integer> map = new HashMap<>();
    	
    	for(Character task : tasks) {
    		map.put(task, map.getOrDefault(task, 0)+1);
    	}
    	
    	PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->(b-a));
    	priorityQueue.addAll(map.values());
    	    	
    	int cycles = 0;
    	
    	while(!priorityQueue.isEmpty()) {
    		
    		List<Integer> tempList  = new ArrayList<>();
    		for(int i=0; i<n+1; i++) {
    			
    			if(priorityQueue.isEmpty()) break;
    			
    			tempList.add(priorityQueue.remove());
    		}   
    		
    		for(Integer i : tempList) {    			
    			if(--i > 0) {
    				priorityQueue.add(i);
    			}
    		}
    		    		
    		cycles+= priorityQueue.isEmpty() ? tempList.size() : n+1;
    		
    	}
    	
    	return cycles;        
    }
    

}
 