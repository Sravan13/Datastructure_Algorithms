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
