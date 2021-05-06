
public class IndexOfImplementation {

	public static void main(String[] args) {
		System.out.println(strStr("", ""));
	}
	
	public static int strStr(String haystack, String needle) {
		
		if(needle== null) return -1;
		
		if(needle.isEmpty()) return 0;
		
		int mainStrLength = haystack.length();
		int subStrLength = needle.length();
		
		for(int i=0;i<haystack.length();i++) {
			
			if((mainStrLength-i) < subStrLength) return -1;
			
			int x = i;
			boolean asIdx = false;
			
			for(int j=0;j<needle.length();j++) {
				
				if(needle.charAt(j) == haystack.charAt(x)) {
					x++;
					asIdx = true;
				}else {
					asIdx = false;
					break;
				}
				
			}
			
			if(asIdx) return i;
		}
		
		return -1;
        
    }

}
