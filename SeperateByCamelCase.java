
public class SeperateByCamelCase {

	public static void main(String[] args) {
		
		System.out.println(camelCaseSplit("Jnuskdjfksdf"));
	}
	
	public static String [] camelCaseSplit(String input){

		if(input.length() == 1) return new String[]{input};
		for(int i=1;i<input.length();i++){
			int firstAscii  = (int)input.charAt(i-1);
			int secondAscii = (int)input.charAt(i);
			if((secondAscii  >= 65 && secondAscii  <= 90) && (firstAscii >= 97 && firstAscii <= 122)){
				return new String[]{input.substring(0,i),input.substring(i)};
			}
		}

		return new String[]{input};
	}

}
