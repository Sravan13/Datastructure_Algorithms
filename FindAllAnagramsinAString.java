import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsinAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		FindAllAnagramsinAString allAnagramsinAString = new FindAllAnagramsinAString();
		System.out.println(allAnagramsinAString.findAnagrams("cbaebabacd","abc"));
	}
	
	public List<Integer> findAnagrams(String s, String p) {
		
		int [] countArr = new int[26];
		
		for(int i=0;i<p.length();i++) {			
			int idx = (int)p.charAt(i) - 97;
			countArr[idx]+=1;
		}
		
		List<Integer> idxList = new ArrayList<Integer>();
		
		for(int i = 0;i <= s.length() - p.length();i++) {
			
			if(isAnagram(s.substring(i, i+p.length()).toCharArray(), countArr)) {
				idxList.add(i);
			}
		}
        
		return idxList;
		
    }
	
	public boolean isAnagram(char [] s, int [] target) {
		
		int [] tempTargetArr = Arrays.copyOf(target, target.length);
		for(int i=0;i<s.length;i++) {			
			int idx = (int)s[i] - 97;
			if(tempTargetArr[idx] <= 0) {
				return false;
			}else {
				tempTargetArr[idx]-=1;
			}
		}
		
		return true;
	}

}
