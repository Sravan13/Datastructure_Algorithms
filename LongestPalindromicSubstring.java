/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        System.out.println(l.longestPalindrome("abxba"));
    }

    public String longestPalindrome(String s) {

        if(s == null || s.length() <= 1) return s;
        int size = s.length();

        int start = 0;
        int end   = 0;

        for(int i=0;i<size;i++){

            int len1 = tracePalindromFromPositions(i-1,i+1,s);
            int len2 = tracePalindromFromPositions( i ,i+1, s );

            int len = len1 > len2 ? len1 : len2;

            if( (end-start+1) < len ){
                start = i - (len-1)/2;
                end = i + len/2;
            }


        }

        return s.substring(start,end+1);
    }

    private int tracePalindromFromPositions(int startIdx,int endIdx,String s){

        while(startIdx >= 0 && endIdx < s.length() && s.charAt(startIdx) == s.charAt(endIdx)){
            startIdx--;
            endIdx++;
        }

        return endIdx-startIdx-1;
    }
}
