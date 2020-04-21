import java.util.List;

/*
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.

You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:

BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.

For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.

 

Example 1:



Input: mat = [[0,0],[1,1]]
Output: 0
Example 2:



Input: mat = [[0,0],[0,1]]
Output: 1
Example 3:



Input: mat = [[0,0],[0,0]]
Output: -1
Example 4:



Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
Output: 1
 */

public class LeftmostColumnWithAtLeastAOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int [][] nums = {{1,1,1,1,1},{0,0,0,1,1},{0,0,1,1,1},{0,0,0,0,1},{0,0,0,0,0}};
		
		int [][]nums = {{0,0},{0,1}};
		System.out.println(leftMostColumnWithOneMatrix(nums));
	}
	
	
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
    	int row = binaryMatrix.dimensions().get(0);
    	int col = binaryMatrix.dimensions().get(1);
    	
    	int index =  Integer.MAX_VALUE;;
    	
    	for(int j = 0;j < row;j++) {
    		
    		int currentIdx= searchColumn(j ,0 ,col-1 , binaryMatrix, -1) ;
    		
    		if( currentIdx != -1 && currentIdx < index ) {
    			index = currentIdx;
    		}
    	}
    	
    	return index == Integer.MAX_VALUE ? -1 : index;
    }
    
    public int searchColumn(int row,int low,int col, BinaryMatrix binaryMatrix, int index){
    	
    	if(low < col) {
    	
    		if(low < col) {
    	    	
    	    	int mid = low+(col-low)/2;
    	    	
    	    	if(binaryMatrix.get(row,mid) == 1) {
    	    		index = mid;
    	    		return	searchColumn(row ,low ,mid-1 , binaryMatrix, index);
    	    	} else {
    	    		return	searchColumn(row ,mid+1 ,col , binaryMatrix, index);
    	    	}
        	
        	}else {
        		return index;
        	}
    	
    	}else {
    		return index;
    	}
    	
    }
    
    
    
    public static int leftMostColumnWithOneMatrix(int [][] binaryMatrix) {
    	int row = binaryMatrix.length;
    	int col = binaryMatrix[0].length;
    	
    	int index = Integer.MAX_VALUE;
    	
    	for(int j = 0;j < row;j++) {
    		
    		int currentIdx = searchColumnMatrix(j ,0 ,col-1 , binaryMatrix, -1);
    		if( currentIdx != -1 ) {
    			
    			if(currentIdx < index ) {
        			index = currentIdx;
        		}
    			
    		}
    	}
    	
    	return index == Integer.MAX_VALUE ? -1 : index;
    }
    
    public static int searchColumnMatrix(int row,int low,int col, int [][] binaryMatrix, int index){
    	
    	if(low <= col) {
    	
	    	int mid = low+(col-low)/2;
	    	
	    	if(binaryMatrix[row][mid] == 1) {
	    		index = mid;
	    		return	searchColumnMatrix(row ,low ,mid-1 , binaryMatrix, index);
	    	} else {
	    		return	searchColumnMatrix(row ,mid+1 ,col , binaryMatrix, index);
	    	}
    	
    	}else {
    		return index;
    	}
    	
    }

    

}



  interface BinaryMatrix { 
	  public int get(int x, int y);
	  public List<Integer> dimensions();// {}
	  
  }
 
