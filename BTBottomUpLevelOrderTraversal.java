import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */

public class BTBottomUpLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		
		node3.left = node4;
		node3.right = node5;
		
		BTBottomUpLevelOrderTraversal traversal = new BTBottomUpLevelOrderTraversal();
		System.out.println(traversal.levelOrderBottom(node1));

	}
	
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		
		List<List<Integer>> outputList =  new ArrayList<List<Integer>>();
        if(root == null) return outputList;
		
		Queue<TreeNode> queue =  new LinkedList<TreeNode>();
		Stack<TreeNode> stack =  new Stack<>();
				
		queue.add(root);
		queue.add(null);
		
		while (!queue.isEmpty()) {
			
			TreeNode headNode =  queue.poll();
			
			if(headNode == null && queue.isEmpty()) break;
			
			if(headNode == null) {
				queue.add(null);
				stack.push(null);
			}else {
				stack.push(headNode);
				
				if(headNode.right!=null)
					queue.add(headNode.right);
				
				if(headNode.left!=null)
					queue.add(headNode.left);
				
			}
					
		}
		
		List<Integer> list = new ArrayList<>();
		while(!stack.isEmpty()) {
			
			TreeNode node  =  stack.pop();
			if(node==null) {
				outputList.add(list);
				list = new ArrayList<>();
			}else {
				list.add(node.val);
			}
			
		}
		
		if(!list.isEmpty()) {
			outputList.add(list);
		}
     
		return outputList;
    }

}
