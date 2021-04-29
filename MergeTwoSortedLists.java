
public class MergeTwoSortedLists {

	public static void main(String[] args) {
		
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(1);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		
		ListNode node5 = new ListNode(2);
		ListNode node6 = new ListNode(2);
		ListNode node7 = new ListNode(2);
		ListNode node8 = new ListNode(2);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		
		ListNode startNode = mergeTwoLists(node1,node5);
		
		System.out.println(startNode);

	}
	
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	
    	if(l1 ==  null) return l2;
    	if(l2 == null)  return l1;
    	
    	ListNode startNode = null,head = null;
    	
    	while(l1!=null && l2!=null) {
    		
    		ListNode temp = null;
    		
    		if(l1.val <= l2.val) {
    			temp = l1;
    			l1 = l1.next;
    		}else {
    			temp = l2;
    			l2 = l2.next;
    		}
    		
    		if(startNode == null) {
    			startNode =  temp;
    		} else {
    			head.next = temp;
    		}
    		temp.next = null;
    		head = temp;
    		
    	}
    	
    	if(l1!=null) {
    		head.next = l1;
    	}else if(l2!=null){
    		head.next = l2;
    	}
    	
    	
    	return startNode;
        
    }

}


/*
 * class ListNode { int val; ListNode next; ListNode() {} ListNode(int val) {
 * this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */