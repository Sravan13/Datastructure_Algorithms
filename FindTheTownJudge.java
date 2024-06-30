/**

In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

 

Example 1:

Input: n = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: n = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: n = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
 

Constraints:

1 <= n <= 1000
0 <= trust.length <= 104
trust[i].length == 2
All the pairs of trust are unique.
ai != bi
1 <= ai, bi <= n


*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheTownJudge {

	public static void main(String[] args) {
		
		int [][] trust = {{1,3},{2,3},{3,1}};//{{1,3},{1,4},{2,3},{2,4},{4,3},{3,1}};//{{1,2}};// 
		
		FindTheTownJudge judge = new FindTheTownJudge();
		System.out.println(judge.findJudge(3, trust));

	}
	
	public int findJudge(int N, int[][] trust) {
		
		if(N==1 && trust.length == 0) return 1;
		
		Map<Integer, StatusObj> map  =  new HashMap<Integer, StatusObj>();
		int max = Integer.MIN_VALUE;
		int value = -1;
		
		for(int i=0; i < trust.length; i++) {
			
			StatusObj  statusObj = null;
			
			if(map.containsKey(trust[i][1])) {
				statusObj = map.get(trust[i][1]);
				statusObj.getSet().add(trust[i][0]);
			}else {
				statusObj = new StatusObj(new HashSet<>(), false);
				statusObj.getSet().add(trust[i][0]);
				map.put(trust[i][1], statusObj);
			}
			
			if(statusObj.getSet().size() > max) {
				max   = statusObj.getSet().size();
				value = trust[i][1];
			}
			
			if(!map.containsKey(trust[i][0])){
				map.put(trust[i][0], new StatusObj(new HashSet<>(), true));
			}
			
			map.get(trust[i][0]).setTrustAnyOne(true);
			
		}
        
		return max == N-1 && !map.get(value).isTrustAnyOne()? value : -1;
    }
	
	class StatusObj {
		
		Set<Integer> set;
		boolean trustAnyOne;
		
		public StatusObj(Set<Integer> set, boolean trustAnyOne) {
			this.set = set;
			this.trustAnyOne = trustAnyOne;
		}
		
		public Set<Integer> getSet() {
			return set;
		}
		
		public void setSet(Set<Integer> set) {
			this.set = set;
		}
		
		public boolean isTrustAnyOne() {
			return trustAnyOne;
		}
		
		public void setTrustAnyOne(boolean trustAnyOne) {
			this.trustAnyOne = trustAnyOne;
		}
				
	}

}
