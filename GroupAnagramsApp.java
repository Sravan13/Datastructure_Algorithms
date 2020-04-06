import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]*/

public class GroupAnagramsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		String [] strs = {"tea","","eat","","tea",""};
		System.out.println(groupAnagrams(strs));
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		
		if(strs.length == 0) new ArrayList<>(map.values());
		
		/*
		 * List<String> list = new ArrayList<String>(); list.add(strs[0]);
		 * map.put(strs[0],list );
		 */
		
		for( int i=0 ; i<strs.length; i++ ) {
			
			boolean isAnagram = false;
			
			if(map.containsKey(strs[i])) {
			map.get(strs[i]).add(strs[i]);
			
			}else {
			
			for(String key : map.keySet()) {
				
				if((key.length() == strs[i].length()) && isAnagram(key,strs[i])) {
					map.get(key).add(strs[i]);
					isAnagram = true;
					break;
				}
			}
			
			if(!isAnagram) {
					List<String> tempList = new ArrayList<String>();
					tempList.add(strs[i]);		
					map.put(strs[i],tempList );
			}
			}
		}
		
		return new ArrayList<>(map.values());
		
	    
    }
	
	public static boolean isAnagram(String src,String target) {
		
		char[] arr1 = src.toCharArray();
		char[] arr2 = target.toCharArray();
		
        int n1 = arr1.length; 
        int n2 = arr2.length; 
  
        if (n1 != n2) 
            return false; 
  
        if (arr1.length != arr2.length)
			return false;
        
		int[] value = new int[26];
		for (int i = 0; i < arr1.length; i++)
		{
			// Increment the value at index i by 1
			value[arr1[i] - 97]++;
			// Decrement the value at index i by 1
			value[arr2[i] - 97]--;
		}
		
		// Value array will have only zeros, if strings are anagram
		for (int i = 0; i < 26; i++)
			if (value[i] != 0)
				return false;
		
		
		return true;
				
	}

}
