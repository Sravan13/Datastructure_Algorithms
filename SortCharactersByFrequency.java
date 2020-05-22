import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

/*
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/

public class SortCharactersByFrequency {

	public static void main(String[] args) {
		SortCharactersByFrequency frequency = new SortCharactersByFrequency();
		frequency.frequencySort("tree");
	}
	
	public String frequencySort(String s) {
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(char c : s.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
		}
		
		Comparator<Map.Entry<Character, Integer>> comparator = new Comparator<Map.Entry<Character, Integer>>() {

			@Override
			public int compare(Entry<Character, Integer> entry1, Entry<Character, Integer> entry2) {
				if(entry1.equals(entry2)) {
					return 0;
				}else {
					return entry2.getValue().compareTo(entry1.getValue());
				}
			}
			
		};
		
		Map<Character, Integer> newMap = sortMapByValue(map,comparator);
		
		StringBuffer sb = new StringBuffer();
		for(Map.Entry<Character, Integer> entry : newMap.entrySet()) {
			for(int i=0;i<entry.getValue();i++) {
				sb.append(entry.getKey());
			}
		}
		
		return sb.toString();
		
    }
	
	public static <K extends Comparable,V extends Comparable> Map<K,V> sortMapByValue( Map<K,V> map , Comparator<Map.Entry<K, V>> comparator){
		
		LinkedList<Map.Entry<K,V>> entries = new LinkedList<Map.Entry<K,V>>(map.entrySet());
		
		
		/*
		 * Comparator<Map.Entry<K, V>> comparator = new Comparator<Map.Entry<K,V>>() {
		 * 
		 * @Override public int compare(Entry<K, V> entry1, Entry<K, V> entry2) {
		 * 
		 * if(entry1.equals(entry2)) { return 0; }else { return
		 * entry2.getValue().compareTo(entry1.getValue()); } }
		 * 
		 * };
		 */
		
		Collections.sort(entries, comparator);
		
		Map<K,V> sortedMap = new LinkedHashMap<K,V>();
	     
        for(Map.Entry<K,V> entry: entries){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
     
        return sortedMap;
		
		
	}
	
	

}
