import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


/*
 
	Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
	
	However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
	
	Return the least number of units of times that the CPU will take to finish all the given tasks.
	
	 
	
	Example 1:
	
	Input: tasks = ["A","A","A","B","B","B"], n = 2
	Output: 8
	Explanation: 
	A -> B -> idle -> A -> B -> idle -> A -> B
	There is at least 2 units of time between any two same tasks.
	Example 2:
	
	Input: tasks = ["A","A","A","B","B","B"], n = 0
	Output: 6
	Explanation: On this case any permutation of size 6 would work since n = 0.
	["A","A","A","B","B","B"]
	["A","B","A","B","A","B"]
	["B","B","B","A","A","A"]
	...
	And so on.
	Example 3:
	
	Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
	Output: 16
	Explanation: 
	One possible solution is
	A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
	 
	
	Constraints:
	
	1 <= task.length <= 104
	tasks[i] is upper-case English letter.
	The integer n is in the range [0, 100].
 
 */

public class TaskScheduler {

	public static void main(String[] args) {
		
		//char [] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
		char [] tasks = {'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E'};
		//char [] tasks = {'A','A','A','B','B','B'};
		
		TaskScheduler scheduler = new TaskScheduler();
		System.out.println(scheduler.leastInterval(tasks,2));
		
	}
	
    public int leastInterval(char[] tasks, int n) {
    	
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	
    	for(char c : tasks) {
    		
    		if(map.containsKey(c)) {
    			map.put(c, map.get(c)+1);
    		}else {
    			map.put(c, 1);
    		}
    	}
    	
    	Map<Character, Integer> sortedMap = sortMapByKey(map);
    	
    	StringBuilder resultStr = new StringBuilder("");
    	
    	while(true) {
    		
    		boolean isAllTaskDone = true;
    		boolean noInsert = true;
    		for(Map.Entry<Character, Integer> entry : sortedMap.entrySet()) {
    			
    			Character c 	= entry.getKey();
    			int count 		= entry.getValue();
    			int strLength 	= resultStr.length();
    			
    			if(count == 0) {
    				continue;
    			}
    			else {
    				isAllTaskDone = false;
    			}
    			
    			if( strLength == 0 ) {
    				resultStr.append(c);
    				count--;
    				if(count == 0) {
    					sortedMap.remove(c);
    				}else {
        				sortedMap.put(c, count);    					
    				}

    				noInsert = false;
    				break;
    			}
    			else {
    				
    				boolean isCharacterExist = false;
    				for(int i=1;i<=n;i++) {
    					if( (strLength-i) >= 0 && resultStr.charAt(strLength-i) == c) {
    						isCharacterExist = true;
    						break;
    					}
    				}
    				
    				if(!isCharacterExist) {
    					resultStr.append(c);
    					noInsert = false;
        				count--;
        				if(count == 0) {
        					sortedMap.remove(c);
        				}else {
            				sortedMap.put(c, count);    					
        				}
        				break; 
    				}
    				 				
    			}
    			
    		}
    		
    		if(isAllTaskDone) {
    			break;
    		}
    		
    		if(noInsert) {
    			resultStr.append("-");
    		}
    		
    	}
    	
    	return resultStr.length();
        
    }
    
  private  Map<Character, Integer> sortMapByKey(Map<Character, Integer> map){
	  
	  Set<Map.Entry<Character, Integer>> entriesSet = map.entrySet();
	  
	  List<Map.Entry<Character, Integer>> entriesList = new ArrayList<>();
	  entriesList.addAll(entriesSet);
	  
	  Comparator<Map.Entry<Character, Integer>> comparator = new Comparator<Map.Entry<Character,Integer>>() {
			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
	  };
	  
	  Collections.sort(entriesList, comparator);
	  
	  Map<Character, Integer> tempMap = new LinkedHashMap<Character, Integer>();
	  
	  for(Map.Entry<Character, Integer> entry : entriesList) {
		  tempMap.put(entry.getKey(), entry.getValue());
	  }
	  
	  return tempMap;
  }

}
