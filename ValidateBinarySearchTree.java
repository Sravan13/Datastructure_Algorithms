/* check  given BST is valid  or not */
public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		
		TreeNode t1 =  new TreeNode(2);
		TreeNode t2 =  new TreeNode(1);
		TreeNode t3 =  new TreeNode(4);
		TreeNode t4 =  new TreeNode(0);
		TreeNode t5 =  new TreeNode(5);
		TreeNode t6 =  new TreeNode(3);
		TreeNode t7 =  new TreeNode(5);
		
		t1.left  = t2;
		t1.right = t3;
		t2.left  = t4;
		t2.right = t5;
		t3.left  = t6;
		t3.right = t7;
		
		System.out.println(isValidBST(t1));
	}
	
    public static boolean isValidBST(TreeNode root) {
        
    	TreeNode left =  getMaxElementInBT(root.left, Integer.MIN_VALUE);
    	TreeNode right = getMinElementInBT(root.right, Integer.MAX_VALUE);
    	
    	if((left !=null && left.val  > root.val) || (right!=null && right.val < root.val)) return false;
    	
    	boolean isleft = true;
    	boolean isright = true;
    	
    	if(left !=null ) {
    		isleft = isValidBST(root.left);
    	}
    	
    	if(right != null) {
    		isright = isValidBST(root.right);
    	}
    	
    	return isleft && isright;
    	
    }
    
    private static TreeNode getMaxElementInBT(TreeNode root, int max) {
    	
    	if(root == null) return null;
    	
    	if(max < root.val) max = root.val;
    	
    	TreeNode left =  getMaxElementInBT(root.left, max);
    	TreeNode right =  getMaxElementInBT(root.right, max);
    	
    	if(left !=null && max < left.val) {
    		max = left.val;
    	}
    	
    	if(right!=null && max < right.val) {
    		max = right.val;    		
    	}
    	
    	return new TreeNode(max);
    	
    }
    
    private static TreeNode getMinElementInBT(TreeNode root,int min) {
    	
    	if(root == null) return null;
    	
    	if(min > root.val) min = root.val;
    	
    	TreeNode left =  getMinElementInBT(root.left, min);
    	TreeNode right =  getMinElementInBT(root.right, min);
    	
    	if(left !=null && min > left.val) {
    		min = left.val;
    	}
    	
    	if(right!=null && min > right.val) {
    		min = right.val;    		
    	}
    	
    	return  new TreeNode(min);
    }

}
