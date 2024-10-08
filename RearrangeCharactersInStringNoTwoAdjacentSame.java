/**

Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.

 

Example 1:

Input: s = "aab"
Output: "aba"
Example 2:

Input: s = "aaab"
Output: ""
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.

**/

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Rearrange characters in a string such that no two adjacent are same. Input: aaabc. Output: abaca
public class RearrangeCharactersInStringNoTwoAdjacentSame {

	public static void main(String[] args) {
		
		arrangeCharactersInStringNoTwoAdjacentSame("aaabc");

	}
	
	public static String arrangeCharactersInStringNoTwoAdjacentSame(String str){
			
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		for (char c : str.toCharArray()) {			
			map.put(c, map.getOrDefault(c, 0)+1);			
		}
		
		Comparator<Pojo> comparator = new Comparator<Pojo>() {

			@Override
			public int compare(Pojo p1, Pojo p2) {
				return p2.getCount()-p1.getCount();
			}
		};
		
		PriorityQueue<Pojo> pq = new PriorityQueue<>(comparator);
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			pq.add(new Pojo(entry.getKey(), entry.getValue()));
		}
		
		StringBuffer sb = new StringBuffer();
		
		Pojo prev_pojo = null;
		
		while(!pq.isEmpty()) {
			
			Pojo pojo = pq.poll();			
			sb.append(pojo.getC());
			
			if(prev_pojo!=null) {
				pq.add(prev_pojo);
				prev_pojo = null;
			}
			
			pojo.setCount(pojo.getCount()-1);
			
			if(pojo.getCount() > 0) {
				prev_pojo = pojo;
			}
			
			
		}
		
		
		return sb.toString();
		
	}
	
	static class Pojo {
		
		Character c;
		int count;
		
		public Pojo(Character c, int count) {
			super();
			this.c = c;
			this.count = count;
		}
		public Character getC() {
			return c;
		}
		public void setC(Character c) {
			this.c = c;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		
	}
	

}


