/*
 * Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted 
without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). 
A common subsequence of two strings is a subsequence that is common to both strings.

If there is no common subsequence, return 0.
 */
public class LongestCommonSubsequenceUsingDP {

	public static void main(String[] args) {
		LongestCommonSubsequenceUsingDP longestCommonSubsequence = new LongestCommonSubsequenceUsingDP();
		System.out.println(longestCommonSubsequence.longestCommonSubsequence("abcde", "ace"));
	}
	
    public int longestCommonSubsequence(String text1, String text2) {
    	
    	char [] chars1 = text1.toCharArray();
    	char [] chars2 = text2.toCharArray();
    	
    	int txt1Len = chars1.length;
    	int txt2Len = chars2.length;
    	
    	int [][] lcs = new int[txt1Len+1][txt2Len+1];
    	
    	for(int i=0;i<=txt1Len;i++) {
    		for(int j=0;j<=txt2Len;j++) {  			
    			if(i == 0 || j == 0) {
    				lcs[i][j] = 0;
    			}else if( chars1[i-1] == chars2[j-1] ) {
    				lcs[i][j] = 1 + lcs[i-1][j-1];
    			}else {
    				lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
    			}
    		}
    	}
    	
    	return lcs[txt1Len][txt2Len];
        
   }
    
  

}
