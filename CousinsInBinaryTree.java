import java.util.LinkedList;
import java.util.Queue;

/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:

Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
*/

public class CousinsInBinaryTree {

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
		t3.right = t5;
		//t2.right = t4;
		
		/*
		 * [1,2,3,null,4] 2 3
		 */
		
		CousinsInBinaryTree binaryTree  = new CousinsInBinaryTree();
		System.out.println(binaryTree.isCousins(t1, 4, 5));

	}
	
	public boolean isCousins(TreeNode root, int x, int y) {
		
		if(root == null) return false;
		
		Queue<ParentChild> queue = new LinkedList<ParentChild>();
		
		queue.add(new ParentChild(root, null));
		queue.add(null);
		
		ParentChild result = null;
		boolean status1 = false;
		
		
		while (!queue.isEmpty()) {
			ParentChild tempNode = queue.poll();
			
			if(tempNode == null) {
				result = null;
				status1 = false;
				//status2 = false;
				if(queue.isEmpty()) {
					break;
				}else {
					queue.add(null);
				}
			}else {
				if((tempNode.child.val == x || tempNode.child.val == y) && !status1 ) {
					result = tempNode;
					status1 = true;
				}else if((result != null) && (tempNode.child.val == x || tempNode.child.val == y) && status1 && tempNode.child.val != result.child.val && tempNode.parent.val != result.parent.val) {
					queue.clear();
					return true;
				}
				
				if(tempNode.child.left!=null) {
					queue.add(new ParentChild(tempNode.child.left,tempNode.child));
				}
				
				if(tempNode.child.right!=null) {
					queue.add(new ParentChild(tempNode.child.right,tempNode.child));
				}
			}
			
		}
		
        
		return false;
    }
	
	class ParentChild {
		
		TreeNode child;
		TreeNode parent;
		
		public ParentChild(TreeNode child,TreeNode parent) {
			this.child = child;
			this.parent = parent;
		}

		public TreeNode getChild() {
			return child;
		}

		public void setChild(TreeNode child) {
			this.child = child;
		}

		public TreeNode getParent() {
			return parent;
		}

		public void setParent(TreeNode parent) {
			this.parent = parent;
		}
		
	}

}
