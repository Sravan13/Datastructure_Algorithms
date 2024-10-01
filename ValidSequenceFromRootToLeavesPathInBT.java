

/*
 * Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a 
given string is a valid sequence in such binary tree. 

We get the given string from the concatenation of an array of integers arr and the concatenation of all values 
of the nodes along a path results in a sequence in the given binary tree.

 

Example 1:



Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
Output: true
Explanation: 
The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure). 
Other valid sequences are: 
0 -> 1 -> 1 -> 0 
0 -> 0 -> 0
Example 2:



Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
Output: false 
Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
Example 3:



Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
Output: false
Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
 */
public class ValidSequenceFromRootToLeavesPathInBT {

	public static void main(String[] args) {

	}
	
	public boolean isValidSequence(TreeNode root, int[] arr) {
		return traverse(root,arr,0,arr.length);
	}
	
	public boolean traverse(TreeNode node, int[] arr,int idx, int len){
		
		if(idx >= len || node == null) return false;
		
		if(node.val == arr[idx]) {
			
			if(len -1 == idx && (node.left == null && node.right == null)) {
				return true;
			}else if(len - 1 == idx) {
				return false;
			}else {
				return traverse(node.left, arr,idx+1, len) || traverse(node.right, arr,idx+1, len);
			}
			
		}else {
			return false;
		}
	}

}

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	      
}
