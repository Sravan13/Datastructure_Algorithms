/* Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).*/
public class SymmetricTree {

	public static void main(String[] args) {
		

	}
	
	public static boolean isSymmetric(TreeNode root) {
	        if(root == null) return true;
	        
	        return checksymetric(root.left, root.right);
	 }
	
	private static boolean checksymetric(TreeNode node1,TreeNode node2) {
		
		if(node1 !=null && node2!=null) {
			
			if(node1.val == node2.val) {
				return checksymetric(node1.left, node2.right) &&
				checksymetric(node1.right, node2.left);
			}else {
				return false;
			}
		}else if(node1 !=null || node2!=null) {
			return false;
		}else {
			return true;
		}
		
		
	}

}
