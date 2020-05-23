package com.leetcode.solutions;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 class Solution141 {
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(slow!=null && fast!=null){
            if(slow==fast)
                return true;
            slow=slow.next;
            if(fast.next==null)
                break;
            fast=fast.next.next;
      }
        
        return false;
    
    }
}
