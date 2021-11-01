import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Letter Combinations of a Phone Number

Solution
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].

 */

public class LetterCombinationsOfPhoneNumber {

	public static void main(String[] args) {
		
		String digits = "";
		letterCombinations(digits);
		
		System.out.println(digits);

	}
	
	public static List<String> letterCombinations(String digits) {
		
		if(digits.isEmpty()) return Collections.EMPTY_LIST;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("2", "abc");
		map.put("3", "def");
		map.put("4", "ghi");
		map.put("5", "jkl");
		map.put("6", "mno");
		map.put("7", "pqrs");
		map.put("8", "tuv");
		map.put("9", "wxyz");
		
		String [] strArray = new String[digits.length()];
		
		for(int i=0;i<digits.length();i++) {
			strArray[i] = map.get(digits.charAt(i)+"");
		}
		
		List<String> outputList  = new ArrayList<>();
		
		traverse( 0, strArray,"",outputList);
		
		return outputList;
        
    }
	
	private static void traverse(int i, String [] strArray, String outputStr, List<String> outputList){
		
		if( i<strArray.length ) {
			
			for(int k=0; k<strArray[i].length(); k++) {				
				traverse(i+1, strArray, outputStr+strArray[i].charAt(k), outputList);
			}
			
		}else {
			outputList.add(outputStr);
		}
			
	}
	

}
