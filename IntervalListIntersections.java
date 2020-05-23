import java.util.LinkedList;
import java.util.List;

/*
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

	Return the intersection of these two interval lists.
	
	(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of 
	two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  
	For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
	
	 
	
	Example 1:
	
	
	
	Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
	Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
	Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
	 
	
	Note:
	
	0 <= A.length < 1000
	0 <= B.length < 1000
	0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 */

public class IntervalListIntersections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] A = {{0,2},{5,10},{13,23},{24,25}};
		int [][] B = {{1,5},{8,12},{15,24},{25,26}};
		
		IntervalListIntersections intersections = new IntervalListIntersections();
		
		intersections.intervalIntersection(A, B);
	}
	
	public int[][] intervalIntersection(int[][] A, int[][] B) {
		
		List<Interval> points = new LinkedList<Interval>();
        
        int aLen = A.length;
        int bLen = B.length;
        
        int i=0,j=0;
        while(i < aLen && j < bLen) {
        	
        	int xPoint = Math.max(A[i][0], B[j][0]);
        	int yPoint = Math.min(A[i][1], B[j][1]);
        	
        	if(xPoint <= yPoint) {
        		points.add(new Interval(xPoint, yPoint));
        	}
        	
        	if(A[i][1] < B[j][1]) {
        		i++;
        	}else {
        		j++;
        	}
        }
        
        int [][] result= new int[points.size()][2];
        
        for(int k=0;k<points.size();k++) {
        	result[k][0] = points.get(k).getX();
        	result[k][1] = points.get(k).getY();
        }
        
        return result;
        
        
    }
	
	class Interval {
		
		int x;
		int y;
		
		public Interval(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}	
				
	}

}
