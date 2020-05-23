package com.leetcode.solutions;

// Definition for singly-linked list.
   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; 
      }
  }
 
class Solution23 {
	 public ListNode mergeKLists(ListNode[] lists) {
	        if(lists==null || lists.length==0)
	            return null;
	        
	        ListNode response =lists[0];
	        for(int i=1;i<lists.length;i++){
	            response=mergeTwoLists(response,lists[i]);
	        }

	        return response;
	    }
	    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if(l1==null && l2!=null)
	            return l2;
	        if(l1!=null && l2==null)
	            return l1;
	      ListNode root=null;
	      ListNode prev=null;
	    
	        while(l1!=null && l2!=null){
	            if(l1.val>=l2.val){
	                if(root==null){
	                    prev= root = new ListNode(l2.val);
	                    l2=l2.next;
	                }
	                else{
	                    prev.next = new ListNode(l2.val);
	                    prev=prev.next;
	                    l2=l2.next;
	                }
	            }
	            else{
	                if(root==null){
	                    prev= root = new ListNode(l1.val);
	                    l1=l1.next;
	                }
	                else{
	                    prev.next = new ListNode(l1.val);
	                    prev=prev.next;
	                    l1=l1.next;
	                }
	            }
	        }
	        while(l1!=null){
	            prev.next= new ListNode(l1.val);
	            prev=prev.next;
	            l1=l1.next;
	        }
	        while(l2!=null){
	            prev.next= new ListNode(l2.val);
	            prev=prev.next;
	            l2=l2.next;
	        }
	        
	        return root;
	    }
}
