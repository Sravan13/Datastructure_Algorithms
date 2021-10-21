import java.math.BigInteger;

public class AddTwoNumbersLinkedList {

	public static void main(String[] args) {

		// 1,9,9,9,9,9,9,9,9,9
		ListNode l0 = new ListNode(7);
		ListNode l1 = new ListNode(3);
		
		l0.next = l1; 
		
		/*
		 * ListNode l0 = new ListNode(1); ListNode l1 = new ListNode(9); ListNode l2 =
		 * new ListNode(9);
		 */
		/*
		 * ListNode l3 = new ListNode(9); ListNode l4 = new ListNode(9); ListNode l5 =
		 * new ListNode(9); ListNode l6 = new ListNode(9); ListNode l7 = new
		 * ListNode(9); ListNode l8 = new ListNode(9); ListNode l9 = new ListNode(9);
		 */
		  
		/*
		 * l0.next = l1; l1.next = l2;
		 */
		/*
		 * l2.next = l3; l3.next = l4; l4.next = l5; l5.next = l6; l6.next = l7; l7.next
		 * = l8; l8.next = l9;
		 */
		
		
		ListNode m4 = new ListNode(10);
		/*
		 * ListNode l5 = new ListNode(6); ListNode l6 = new ListNode(4);
		 * 
		 * l4.next = l5; l5.next = l6;
		 */
		 
		
		AddTwoNumbersLinkedList addTwoNumbers = new AddTwoNumbersLinkedList();
		addTwoNumbers.addTwoNumbers(l0,m4);
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
		ListNode head = null;
		ListNode currentPtr = null;
		int carry = 0;
		
		while(l1!=null && l2!=null) {
			
			int sum = l1.val + l2.val + carry;
			int value = sum > 9 ? sum % 10 : sum;
			carry = sum > 9 ? 1 : 0;
			ListNode newNode = new ListNode(value);
			
			//setResultList(newNode,head,currentPtr);
			if(head == null) {
				head = newNode;
				currentPtr = newNode;
			}else {
				currentPtr.next = newNode;
				currentPtr = newNode;
			}
			
			l1 = l1.next;
			l2 = l2.next;
		}
		
		if(!(l1 == null && l2 == null)) {
			ListNode newList = l1!=null ? l1 : l2;
			
			while(newList!=null) {
				
				int sum = newList.val + carry;
				int value = sum > 9 ? sum % 10 : sum;
				carry = sum > 9 ? 1 : 0;
				
				ListNode newNode = new ListNode(value);
				
				//setResultList(newNode,head,currentPtr);
				if(head == null) {
					head = newNode;
					currentPtr = newNode;
				}else {
					currentPtr.next = newNode;
					currentPtr = newNode;
				}
				
				newList = newList.next;				
			}
		}
		
		if(carry == 1) {
			ListNode newNode = new ListNode(carry);
			currentPtr.next = newNode;
		}
		return head;
		
    }
	
	
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

}


