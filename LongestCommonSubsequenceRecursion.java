/*
 * Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted 
without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). 
A common subsequence of two strings is a subsequence that is common to both strings.

If there is no common subsequence, return 0.
 */
public class LongestCommonSubsequenceRecursion {

	public static void main(String[] args) {
		LongestCommonSubsequenceRecursion longestCommonSubsequence = new LongestCommonSubsequenceRecursion();
		System.out.println(longestCommonSubsequence.longestCommonSubsequence("abcde", "ace"));
	}
	
    public int longestCommonSubsequence(String text1, String text2) {
    	
    	char [] chars1 = text1.toCharArray();
    	char [] chars2 = text2.toCharArray();
    	
    	return LCS(chars1,chars2,chars1.length-1,chars2.length-1);
        
   }
    
   public int LCS(char [] chars1,char [] chars2,int strLen1, int strLen2){
	   
	   if (strLen1 < 0 || strLen2 < 0) return 0;
	   
	   if(chars1[strLen1] == chars2[strLen2])	{
		   return 1 + LCS(chars1, chars2, strLen1-1, strLen2-1);
	   }else {
		  return Math.max(LCS(chars1, chars2,strLen1-1, strLen2), LCS(chars1, chars2,strLen1, strLen2-1));
	   }
   }

}
