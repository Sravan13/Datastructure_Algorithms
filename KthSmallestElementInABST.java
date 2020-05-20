
/*Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
*/
public class KthSmallestElementInABST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(6);
		TreeNode node4 = new TreeNode(2);
		
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(1);
		
		
		node1.left = node2;
		node1.right = node3;
		 
		node2.left = node4;
		node2.right = node5;
		
		node4.left = node6;
		
		KthSmallestElementInABST kthSmallestElementInABST = new KthSmallestElementInABST();
		System.out.println(kthSmallestElementInABST.kthSmallest(node1, 3));

	}
	
	public int kthSmallest(TreeNode root, int k) {				
		TreeNode finalNode = traverseTillKthElement(root,new StatusPojo(k));		
		return finalNode.val;		
    }
	
	public TreeNode traverseTillKthElement(TreeNode root, StatusPojo pojo) {
		
		if(root != null) {
				
		TreeNode left =	traverseTillKthElement(root.left, pojo);
		
		if(left !=null) return left;
		
		pojo.setIdx(pojo.getIdx()-1);
		
		if(pojo.getIdx()==0) return root ;
		
		TreeNode right =	traverseTillKthElement(root.right, pojo);
		
		if(right !=null) return right;
		
		return null;
		
		}else {
			
			return null;
		}
    }
	
	private class StatusPojo {
		
		int idx;

		public StatusPojo(int idx) {
			this.idx = idx;
		}

		public int getIdx() {
			return idx;
		}

		public void setIdx(int idx) {
			this.idx = idx;
		}
			
	}

}
