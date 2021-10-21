
public class FindLatestVersion {

	public static void main(String[] args) {
		
		System.out.println(getLatestVersion("10.5.13.1","10.5.15.0"));
		System.out.println(getLatestVersionViaChar("10.5.15.1","10.5.15.0"));
	}

	
	private static String getLatestVersion(String s1, String s2){


		String[] v1 = s1.split("\\.");
		String[] v2 = s2.split("\\.");

		for(int i=0;i<v1.length;i++){
			int x = Integer.parseInt(v1[i]);
			int y = Integer.parseInt(v2[i]);
			if(x == y) continue;
			else{
			   return x > y ? s1 : s2;
			}
		}
		
		return s1;

	}
	
	
	private static String getLatestVersionViaChar(String s1, String s2){


		char[] v1 = s1.toCharArray();
		char[] v2 = s2.toCharArray();
		
		StringBuffer sbV1 = new StringBuffer();
		StringBuffer sbV2 = new StringBuffer();

		for(int i=0;i<v1.length;i++){
			
			if( v1[i] == '.' && v2[i] == '.') {
				
				int x = Integer.parseInt(sbV1.toString());
				int y = Integer.parseInt(sbV2.toString());
			
				if(x == y) {
					sbV1.setLength(0);					
					sbV2.setLength(0); continue;
				}
				
				return x > y ? s1 : s2;
				
			}else {
				sbV1.append(v1[i]);
				sbV2.append(v2[i]);
			}
						
		}
		
		return s1;

	}
}
