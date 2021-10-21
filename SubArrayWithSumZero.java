import java.util.HashSet;
import java.util.Set;

public class SubArrayWithSumZero {

	public static void main(String[] args) {
		int [] arr = {4, 2, -3, 1, 6};
		findSubArrayWithSumZero(arr);
	}
	
	
	private static boolean findSubArrayWithSumZero(int [] arr){
		
		int sum = 0;		
		Set<Integer> set =  new HashSet<>();
		
		for(int i : arr) {		
			sum+=i;
			
			if( i == 0 || sum == 0 || set.contains(sum)) return true;
						
			set.add(sum);
		}
		
		return false;
		
	}
	
}


