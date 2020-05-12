
/*
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor,
 "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same 
color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), 
and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
Note:

The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 */

public class FloodFillApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] image = {{0,0,0},{0,1,1}};
		
		FloodFillApp fillApp = new FloodFillApp();
		fillApp.floodFill(image, 1, 1, 1);
		
		System.out.println(image);
	}
	
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		
		boolean [][] visitArr = new boolean[image.length][image[0].length];
		
		return traverseFloodFill(image, sr, sc, newColor, visitArr);
    }
	
	public int[][] traverseFloodFill(int[][] image, int sr, int sc, int newColor,boolean [][] visitArr){
		
		int oldColor  = image[sr][sc];
		image[sr][sc] = newColor;		
		visitArr[sr][sc] = true;
		
		if( sr-1 > -1 && !visitArr[sr-1][sc] && image[sr-1][sc] == oldColor) {
			traverseFloodFill(image, sr-1, sc, newColor,visitArr);
		}
		
		if(sc+1 < image[0].length && !visitArr[sr][sc+1] && image[sr][sc+1] == oldColor) {
			traverseFloodFill(image, sr, sc+1, newColor,visitArr);
		}
		
		if(sr+1 < image.length && !visitArr[sr+1][sc] &&  image[sr+1][sc] == oldColor) {
			traverseFloodFill(image, sr+1, sc, newColor,visitArr);
		}
		
		if(sc-1 > -1 && !visitArr[sr][sc-1] && image[sr][sc-1] == oldColor) {
			traverseFloodFill(image, sr, sc-1, newColor,visitArr);
		}
        
		return image;
		
	}

}
