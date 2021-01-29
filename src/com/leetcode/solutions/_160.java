package com.leetcode.solutions;

class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;

        ListNode tempA = headA;
        ListNode tempB = headB;

        int iteration = 0;

        while(iteration < 3){
            if(headA == headB)
                return headA;

            headA = headA.next;
            headB = headB.next;
            if(headA == null){
                headA = tempB;
                iteration++;
            }
            if(headB == null){
                headB = tempA;
                iteration++;
            }

        }

        return null;
    }
}
