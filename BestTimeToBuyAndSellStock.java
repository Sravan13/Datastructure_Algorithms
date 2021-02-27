
/**
 * 
 * @author Sravan Chithari
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
 *
 */

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] prices = {7,1,5,3,6,4};
		//int[] prices = {7,6,4,3,1};
		
		maxProfit(prices);
	}
	
	 public static int maxProfit(int[] prices) {
		 
		 int max = 0;
		 int min = 0;
		 for(int i=0;i<prices.length-1;i++) {
			 
			 if(i==0) {
				 min = prices[i];
			 }else if(prices[i] >= min) {
				 continue;
			 }else {
				 min = prices[i];
			 }
			 
			 
			 for(int j=i+1;j<prices.length;j++) {
				 
				 if(prices[j] > prices[i]) {
					 max = (prices[j] - prices[i]) > max ? (prices[j] - prices[i]) : max;
				 }
				 
			 }
		 }
		 
		 return max;
	        
	 }

}
