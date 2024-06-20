/*
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents 
 the coordinate of a point. Check if these points make a straight line in the XY plane.

 

 

Example 1:



Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:



Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 

Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.

Note : if all the corridenates are on straight line then it's slope between any two coordinates equal

formula for slope is y1-y1 / x2-x1
 */
public class CheckIfItIsAStraightLine {

	public static void main(String[] args) {

	}
	
	public boolean checkStraightLine(int[][] coordinates) {
        
		
		int rows = coordinates.length;
		
		if(rows == 2) return true;
		
		int x0 = coordinates[0][0];
		int y0 = coordinates[0][1];
		
		int x1 = coordinates[1][0];
		int y1 = coordinates[1][1];
		
		
		for(int i=2;i<rows;i++) {
			
			int x3 = coordinates[i][0];
			int y3 = coordinates[i][1];
			
			if((y1-y0)*(x3-x0) != (y3-y0)*(x1-x0)) {
				return false;
			}
		}
		
		return true;
		
    }

}
