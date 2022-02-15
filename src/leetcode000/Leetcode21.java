package leetcode000;

import guoqing.datastruct.ListNode;

public class Leetcode21 {
	// 1 3 5
	// 2 4 6 
	// 
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    	ListNode p1 = list1;
    	ListNode p2 = list2;
    	if (p1 == null || p2 == null) {
    		if (p1 == null && p2 == null) {
    			return null;
    		} else {
    			return p1 == null ? p2 : p1;
    		}
    	}
    	ListNode pslow = new ListNode();    	
    	ListNode phead = (p1.val < p2.val) ? p1 : p2;    	
    	while (p1 != null && p2 != null) {
    		ListNode pfast = (p1.val < p2.val) ? p1 : p2;
    		if (p1.val < p2.val) {
    			p1 = p1.next;
    		} else {
    			p2 = p2.next;
    		}
    		pslow.next = pfast;
    		pslow = pfast;   		
    	}
    	pslow.next = (p1 == null) ? p2 : p1;
    	return phead;
    }
}
