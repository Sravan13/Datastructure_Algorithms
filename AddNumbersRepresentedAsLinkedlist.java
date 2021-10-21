
public class AddNumbersRepresentedAsLinkedlist {

	public static void main(String[] args) {
		
		// 1->2->3, 9->1->2. Output: 1->0->3->5
		
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		
		ListNode listNode4 = new ListNode(9);
		ListNode listNode5 = new ListNode(1);
		ListNode listNode6 = new ListNode(2);
		
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		
		listNode4.next= listNode5;
		listNode5.next= listNode6;
		
		
		AddLinkedList(listNode1,listNode4);
		
	}
	

	
	private static ListNode reverse(ListNode node){

		if(node.next!=null) {
		ListNode x = reverse(node.next);
			
			ListNode temp = node.next;
			temp.next = node;
			node.next= null;
			
			return x;
		}else {
			return node;
		}

	}

	private static ListNode AddLinkedList(ListNode listNode1, ListNode listNode2){

		ListNode node1 = reverse(listNode1);
		ListNode node2 = reverse(listNode2);
		

		int carry = 0;
		ListNode head = null;
		ListNode prevNode = null;
		
		while (node1!=null || node2!=null){

			int sum = carry + (node1!=null ? node1.val : 0) + (node2!=null ? node2.val : 0);
			
			int val = sum % 10;
			carry = sum > 9 ? 1 : 0;

			ListNode node = new ListNode(val);
			if(head == null){
				head = node;

			}else{
				prevNode.next = node;
			}

			prevNode = node;
			
			if(node1 != null) node1 = node1.next;
			if(node2 != null) node2 = node2.next;
			
		}
		
		if(carry > 0) {
			prevNode.next = new ListNode(carry);;
		}
	
		return reverse(head);
	}

}
