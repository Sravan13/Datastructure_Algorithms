import java.util.Scanner;

/*# Datastructure_Algorithms

You are given a 2D matrix, a, of dimension MxN and a positive integer R. You have to rotate the matrix R times and print the
 resultant matrix. Rotation should be in anti-clockwise direction.

Sample Input #00

4 4 1
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
Sample Output #00

2 3 4 8
1 7 11 12
5 6 10 16
9 13 14 15*/

public class MatrixRotation {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String firstLine = scanner.nextLine();
		String[] inputs = firstLine.split("\\s+");
		
		int rows = Integer.parseInt(inputs[0]);
		int cols = Integer.parseInt(inputs[1]);
		int rotations = Integer.parseInt(inputs[2]);
		
		int [][] arr = new int[rows][cols];
		
		int rowIdx = 0;
		String row;
		while(!(row = scanner.nextLine()).isEmpty()) {
	
			String[] cells = row.split("\\s+");
			
			for(int i=0;i<cells.length;i++) {
				arr[rowIdx][i] = Integer.parseInt(cells[i]);
			}
			
			rowIdx++;
			
		}
		
		scanner.close();
						
		for(int i=0;i<rotations;i++) {
			matrixRotationAntiClockwise(arr);
		}
		  		  		
		print2DArray(arr);		 
		
	}
	
	
	
	private static int[][] matrixRotationAntiClockwise(int [][] arr) {
		
		int rowsLength = arr.length;
		int colsLength = arr[0].length;
		
		
		int rowLowLimit = 0,rowHighLimit = rowsLength - 1;
		int colLowLimit = 0,colHighLimit = colsLength - 1;
		
		for(int row = rowHighLimit,col = colHighLimit; row >= 0 && col >= 0; row=row-2,col=col-2) {
			
			
			
			// left col
			int leftBottom = arr[rowHighLimit][colLowLimit];
			for(int i=rowHighLimit; i>rowLowLimit; i--) {				
				arr[i][colLowLimit] = arr[i-1][colLowLimit];				
			}
			
			
			// bottom row
			int rightBottom = arr[rowHighLimit][colHighLimit];
			for(int i=colHighLimit; i>colLowLimit+1; i--) {
				arr[rowHighLimit][i] =  arr[rowHighLimit][i-1];
			}
			arr[rowHighLimit][colLowLimit+1] = leftBottom;
			
							
			// right top
			int rightTop = arr[rowLowLimit][colHighLimit];
			for(int i=rowLowLimit+1; i< rowHighLimit; i++) {
				arr[i-1][colHighLimit] = arr[i][colHighLimit];
			}
			arr[rowHighLimit-1][colHighLimit] = rightBottom;
			
			//top left
			for(int i=colLowLimit; i<colHighLimit; i++) {
				arr[rowLowLimit][i] = arr[rowLowLimit][i+1];
			}
			arr[rowLowLimit][colHighLimit-1]=rightTop;
			
			rowLowLimit = rowLowLimit+1;rowHighLimit = rowHighLimit - 1;
			colLowLimit = colLowLimit+1;colHighLimit = colHighLimit - 1;
			
		}
		
		return arr;
		
	}
	
	private static void print2DArray(int [][] arr) {
		
		int rowsLength = arr.length;
		int colsLength = arr[0].length;
		
		for(int i=0;i<rowsLength;i++) {
			for(int j=0;j<colsLength;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
	static void swap (int i, int j, int arrIdx , int [] tempArr , int [][] arr){
		int temp =  arr[i][j];
		arr[i][j] = tempArr[arrIdx];
		tempArr[arrIdx] = temp;
	}

}
