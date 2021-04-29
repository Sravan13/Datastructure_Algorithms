import java.util.Stack;

public class PalindromeLinkedList {

	public static void main(String[] args) {

		ListNode node1 = new ListNode(1);
		/*
		 * ListNode node2 = new ListNode(3); ListNode node3 = new ListNode(3); ListNode
		 * node4 = new ListNode(1);
		 */
		/*
		 * node1.next = node2; node2.next = node3; node3.next = node4;
		 */
		
		System.out.println(isPalindrome(node1));
		
	}
	
	 public static boolean isPalindrome(ListNode head) {
		 
		 if(head == null) return true;
		 
		 int listLength = 0;
		 
		 Stack<Integer> stack = new Stack<>();
		 ListNode slowPtr = head,fastPtr = head;
		 
		 while(fastPtr!=null) {
			 
			 stack.push(slowPtr.val);
			 listLength++;
			 if(fastPtr.next!=null) {
				 
				 fastPtr = fastPtr.next;
				 listLength++;
				 if(fastPtr.next!=null) {
					 fastPtr = fastPtr.next;
					
					 slowPtr = slowPtr.next;
				 } else {
					 break;
				 }
				 
			 }else {
				 break;
			 }
			 
		 }
		 
		 if(listLength%2!=0) {
			 stack.pop(); 
		 }
		 
		 for(ListNode node=slowPtr.next;node!=null;node=node.next) {
			 
			 if(stack.peek() == node.val) {
				 stack.pop();
			 } else {
				 return false;
			 }
			 
		 }
		 
		 
		 if(stack.isEmpty()) return true;
		 
		 
	 
		 return true;
	 }

}
