public class LinkedListCycle {

	public static void main(String[] args) {

	}
	
    public boolean hasCycle(ListNode head) {
    	
    	if(head == null) return false;
			 
			 
			 ListNode slowPtr = head,fastPtr = head;
			 
			 while(fastPtr!=null) {
				 
				 if(fastPtr.next!=null) {
					 
					 fastPtr = fastPtr.next;
					 if(fastPtr.next!=null) {
						 fastPtr = fastPtr.next;
					 } else {
						 return false;
					 }
					 
				 }else {
					 return false;
				 }
				 
				 slowPtr = slowPtr.next;
				 
				 if(slowPtr.val == fastPtr.val) return true;
				 
			 }
    	
    	return false;
        
    }

}
