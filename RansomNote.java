import java.util.Arrays;

/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, 
write a function that will return true if the ransom note can be constructed from the magazines ; 
otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true*/

public class RansomNote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RansomNote ransomNote = new RansomNote();
		System.out.println(ransomNote.canConstruct("aab", "aab"));
		System.out.println(ransomNote.canConstruct("a", "aab"));
		System.out.println(ransomNote.canConstruct("aaa", "aab"));
		System.out.println(ransomNote.canConstruct("c", "aab"));
		
	}
	
	public boolean canConstruct(String ransomNote, String magazine) {
		
		if(ransomNote.length() == 0) return true;
		
		char [] rChars = ransomNote.toCharArray();
		char [] mChars = magazine.toCharArray();
		
		Arrays.sort(rChars);
		Arrays.sort(mChars);
		
		int rPtr = 0;
		int mPtr = 0;
				
		while (rPtr < rChars.length && mPtr < mChars.length) {
			
			if(rChars[rPtr] == mChars[mPtr]) {
				rPtr++;mPtr++;
			}else {
				mPtr++;
			}
		}
		
		if(rPtr < rChars.length) {
			return false;
		}else {
			return true;
		}
		
        
    }

}
