
/*Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

 

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

*/


public class ConstructBinarySearchTreefromPreorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	
	public TreeNode bstFromPreorder(int[] preorder) {
		
		if(preorder.length == 0) return null;
		
		TreeNode root = new TreeNode(preorder[0]) ;
		
		for(int i=1;i<preorder.length;i++) {
			insertNode(root,preorder[i]);
		}
		
		return root;
        
    }
	
	public static void insertNode(TreeNode node,int num) {
		
		if(node.left==null && num < node.val) {
			node.left = new TreeNode(num);
		}else if( num < node.val) {
			insertNode(node.left,num);
		}else if(node.right==null && num > node.val) {
			node.right = new TreeNode(num);
		}else if( num > node.val) {
			insertNode(node.right,num);
		}
		
	}
	
	

}

 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
