package com.leetcode.solutions;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans=null;
        ListNode root=null;
        int carry = 0;
        while(l1!=null || l2!=null){
            int first = l1==null?0:l1.val;
            int second = l2==null?0:l2.val;
            int total = first+second+carry;
            ListNode n = new ListNode(total%10);
            if(root==null)
                root=ans=n;
            else{
                ans.next=n;
                ans=n;
            }
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
            
            carry=total/10;
        }
        if(carry!=0)
            ans.next=new ListNode(carry);
        
        return root;
    }
}