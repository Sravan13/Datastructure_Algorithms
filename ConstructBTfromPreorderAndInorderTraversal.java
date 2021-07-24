
/*
 * 
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.

 */

public class ConstructBTfromPreorderAndInorderTraversal {

	public static void main(String[] args) {
		
		/*
		 * int [] preorder = {3,9,20,15,7}; int [] inorder = {9,3,15,20,7};
		 */
		
		int [] preorder = {1,2,3};
		int [] inorder = {3,2,1};
		
		ConstructBTfromPreorderAndInorderTraversal traversal = new ConstructBTfromPreorderAndInorderTraversal();
		TreeNode  treeNode = traversal.buildTree(preorder, inorder);
		
		System.out.println(treeNode);
		
	}
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    		
    		int rootIdx = findIndex(preorder[0], inorder,0,inorder.length);
    		
    		TreeNode node = new TreeNode(preorder[0]);
    		
    		int leftLen  = rootIdx; 
    		int rightLen = (inorder.length-1-rootIdx);
    		
    		if(leftLen > 0)
    		node.left = buildSubTree(preorder,1,rootIdx,inorder,0,rootIdx-1);
    		
    		if(rightLen > 0)
    		node.right = buildSubTree(preorder, rootIdx+1, preorder.length-1, inorder, rootIdx+1, inorder.length-1);
    	
    		return node;
    }
    
    public TreeNode buildSubTree(int [] preorder, int preOrderStartIdx, int preOrderEndIdx, int [] inorder, int inOrderStartIdx, int inOrderEndIdx){
    	
    	Integer rootIdx = findIndex( preorder[preOrderStartIdx] , inorder, inOrderStartIdx, inOrderEndIdx );
    	
    	if(rootIdx == null) return null;
    	
		int leftLen  = rootIdx - inOrderStartIdx; 
		int rightLen = (inOrderEndIdx-rootIdx);
		
		TreeNode node = new TreeNode(preorder[preOrderStartIdx]);
		
		if(leftLen > 0)
		node.left = buildSubTree(preorder, preOrderStartIdx+1, preOrderStartIdx + leftLen , inorder, inOrderStartIdx , rootIdx-1);
		
		if(rightLen > 0)
			node.right = buildSubTree(preorder, preOrderStartIdx + leftLen + 1, preOrderEndIdx, inorder, rootIdx + 1,inOrderEndIdx);
    	
    	return node;
    	
    }
    
    
    
    private Integer findIndex(int key,int [] inorder, int inOrderStartIdx, int inOrderEndIdx ) {
    	
    	for(int i=inOrderStartIdx; i <= inOrderEndIdx; i++) {
    		if(key == inorder[i]) return i;
    	}
    	
    	return null;
    }

}
