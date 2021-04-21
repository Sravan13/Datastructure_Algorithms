
/*Reverse Linked List*/

public class ReverseLinkedList {

	public static void main(String[] args) {
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		
		ListNode ListNode = reverseList(node1);

		System.out.println(ListNode);
	}
	
	public static ListNode reverseList(ListNode head ) {
		
		if(head == null) return null;
		
		ListNode target = null;
		target = traverse(head,target);
	        
		return target;
	}

	private static ListNode traverse(ListNode node,ListNode target) {
		
		if(node.next!=null) {
			target = traverse(node.next,target);
			ListNode temp = node.next;
			node.next = null;
			temp.next = node;
		}else {
			target = node;
		}
		
		return target;
	}

}

class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}