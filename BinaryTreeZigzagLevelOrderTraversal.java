import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
Binary Tree Zigzag Level Order Traversal

Solution
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100

*/

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal traversal = new BinaryTreeZigzagLevelOrderTraversal();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);

		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);

		t1.left = t2;
		t1.right = t3;

		
		  t2.left = t4; t2.right = t5;
		  
		  t3.left = t6; t3.right = t7;
		 

		System.out.println(traversal.zigzagLevelOrder(t1));
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		if (root == null)
			return Collections.EMPTY_LIST;

		List<List<Integer>> result = new LinkedList<List<Integer>>();
		List<Integer> internalList = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);

		boolean reverse = false;
		while (!queue.isEmpty()) {

			TreeNode tempNode = queue.poll();

			if (tempNode == null) {

				if (reverse) {
					while (!stack.isEmpty()) {
						internalList.add(stack.pop());
					}

					stack.clear();
				}

				result.add(new LinkedList<>(internalList));
				internalList.clear();
				reverse = !reverse;

				if (!queue.isEmpty())
					queue.add(null);

			} else {

				if (tempNode.left != null)
					queue.add(tempNode.left);

				if (tempNode.right != null)
					queue.add(tempNode.right);

				if (!reverse) {
					internalList.add(tempNode.val);
				} else {
					stack.add(tempNode.val);
				}
			}

		}

		return result;
	}

}
