/*
 * A binary tree's maximum depth is the number of nodes along the longest path from the
 * root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {

	public static void main(String[] args) {
		
		// [3,9,20,null,null,15,7]
		TreeNode t1 =  new TreeNode(3);
		TreeNode t2 =  new TreeNode(9);
		TreeNode t3 =  new TreeNode(20);
		TreeNode t4 =  new TreeNode(15);
		TreeNode t5 =  new TreeNode(7);
		
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;

		System.out.println(maxDepth(t1));
	}
	
    public static int maxDepth(TreeNode root) {
        
    	if(root == null) {
    		return 0;
    	}else {
    		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    		
    	}
    }

}




