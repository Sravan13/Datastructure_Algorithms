import java.util.Stack;

/*
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed 
 * by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */

public class NumberofIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] grid = {{'1','1','0','0','0'},
						 {'1','1','0','0','0'},
						 {'0','0','1','0','0'},
						 {'0','0','0','1','1'}};
		
		System.out.println(numIslands(grid));

	}
	
	 public static int numIslands(char[][] grid) {
		 
		 
		 int count = 0;
		 int rows = grid.length;
		 
		 if(rows == 0) return count;
		 
		 int cols = grid[0].length;
		 
		 for(int i=0;i<rows;i++) {
			 for(int j=0;j<cols;j++) {
			
				 if( grid[i][j] == '1') {					 
					 grid[i][j] = 'x';
					 count++;
					 traceViaDFS(i,j,grid);
				 }
			 }
		 }
		 
		 return count;
	        
	 }
	 
	 public static void traceViaDFS(int i,int j,char [][] grid) {
		 
		 Stack<Cell> stack = new Stack<>();
		 
		 stack.push( new Cell(i, j));
		 
		 while(!stack.isEmpty()) {
			 Cell topCell =  stack.peek();
			 
			Cell adjCell = findAdjacentCell(topCell,grid);
			
			if(adjCell == null) {
				stack.pop();continue;
			}else {
				stack.push(adjCell);
				grid[adjCell.i][adjCell.j] = 'x';
			}
		 }
		 
	 }

	private static Cell findAdjacentCell(Cell topCell,char [][] grid) {
		
		int rows = grid.length;
		int cols = grid[0].length;
		
		int i =  topCell.i;
		int j =	 topCell.j;
		
		if( (i-1)>=0 && grid[i-1][j] == '1' ) {			
			return new Cell(i-1,j);
		}
		else if( (i+1) < rows && grid[i+1][j] == '1' ) {
			return new Cell(i+1,j);
		}
		else if( (j+1)< cols && grid[i][j+1] == '1' ) {
			return new Cell(i,j+1);
			
		}else if( (j-1)>=0 && grid[i][j-1] == '1' ) {
			return new Cell(i,j-1);
		}
		
		return null;
	}

}


class Cell {
	int i,j;

	public Cell(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		Cell objCell = (Cell)obj;
		return ( this.i == objCell.i && this.j == objCell.j );
	}
	
}
