
public class MiddleOfTheLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ListNode middleNode(ListNode head) {
		
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		
		while(fastPtr!=null) {
			
			
			if(fastPtr.next !=null) {
				fastPtr =  fastPtr.next.next;
			}else {
				break;
			}
			fastPtr = fastPtr.next !=null ? fastPtr.next.next : fastPtr.next;
			slowPtr = slowPtr.next;	
			
		}
        
		return slowPtr;
		
    }

}



  //Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
