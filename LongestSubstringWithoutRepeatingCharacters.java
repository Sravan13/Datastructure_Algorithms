
/*
    Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {

        int len = s.length();

        if(len == 0 || len == 1) return len;

        int idx=1;
        int count = 1;
        int max = 1;
        StringBuffer sb = new StringBuffer(s.charAt(0)+"");

        while(idx < len){

            int matchIdx = isSubStringContainsCharacter(sb,s.charAt(idx),idx);
            if(-1 == matchIdx){
                sb.append(s.charAt(idx));
                count++;
            }else{
                max = count > max ? count : max;

                count = 1;
                String subString = s.substring(matchIdx,idx+1);
                count = subString.length();
                sb = new StringBuffer(subString);
            }

            idx++;
        }

        return count > max ? count : max;
    }

    private int isSubStringContainsCharacter(StringBuffer sb, char charAt,int idx) {
        int len = sb.length();
        int l=0;
        for (int i = len-1; i >= 0  ; i--) {
            if(sb.charAt(i) == charAt) {
                return idx-l;
            }else{
                l++;
            }
        }

        return -1;
    }
}
