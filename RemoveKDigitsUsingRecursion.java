
public class RemoveKDigitsUsingRecursion {

	public static void main(String[] args) {
				
		RemoveKDigitsUsingRecursion removeKDigits = new RemoveKDigitsUsingRecursion();
		System.out.println(removeKDigits.removeKdigits("1432219", 3));
	}
	
	public String removeKdigits(String num, int k) {
       
		MinInt minInt  = new MinInt();
		
		if((num.length()-k) < 1) return "0";
		
		permutation(num, num.length()-k, minInt);
		
		return minInt.getMin() == null ? "0" :  String.valueOf(minInt.getMin());
    }
	
	public void permutation(String num , int targetLen, MinInt min) {
				
		int tempInt = Integer.valueOf(num);
		if((targetLen == num.length()) && ( min.getMin() == null || tempInt < min.getMin() )) {
				min.setMin(tempInt);
		}else {
				
			for(int i = 0;i< num.length();i++) {			
				String tempStr = num.substring(0, i)+num.substring(i+1, num.length());
				
				if(tempStr.length()>0)
				permutation(tempStr , targetLen, min);
			}
		}
	}
	
	class MinInt {
		
		Integer min;
		
		public MinInt() {
		}

		public MinInt(Integer min) {
			super();
			this.min = min;
		}

		public Integer getMin() {
			return min;
		}

		public void setMin(Integer min) {
			this.min = min;
		}
		
	}
	
	 

}
