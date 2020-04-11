
/*

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.

Hint : My hint is adding  the depth of left subtree and right subtree at each node which ever node have highest 
that is the diameter


*/



public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      
	      TreeNode t1 = new TreeNode(1);
		  TreeNode t2 = new TreeNode(2);
		  TreeNode t3 = new TreeNode(3);
		  TreeNode t4 = new TreeNode(4);
		  TreeNode t5 = new TreeNode(5);
		  
		  t1.left = t2;
		  t1.right = t3;
		  t2.left = t4;
		  t2.right = t5;
		  
		  System.out.println(diameterOfBinaryTree(t1));

	}
	
	public static int diameterOfBinaryTree(TreeNode root) {
		
		if(root == null) return 0;
		
		Max max = new Max(0);
        
		int depthSum =  depthOfTree(root.left,0,max) + depthOfTree(root.right,0,max);
		return max.getMax() > depthSum ? max.getMax() : depthSum;
				
    }
	
	public static int depthOfTree(TreeNode node,int count,Max max){
		
		if(node==null) return count;
		
		int leftlength  = 0;
		int rightlength = 0;
		
		leftlength  = node.left != null ? depthOfTree(node.left,count+1,max)  : 0;
		rightlength = node.right!= null ? depthOfTree(node.right,count+1,max)  : 0;
				
		int depth = leftlength > rightlength ? leftlength+1 : rightlength+1;
		
		if((leftlength+rightlength) > max.getMax()) {
			max.setMax(leftlength+rightlength);
		}
		
		return depth;
				
	}

}

class Max {
	int max;
	
	public Max(int x) {
		this.max = x;
	}
	
	public int getMax() {
		return max;
	}
	
	public void setMax(int max) {
		this.max = max;
	}	
	
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
