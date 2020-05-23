package com.leetcode.solutions;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        if(root==null)
            return new ListNode[k];
        
	        int size = getListSize(root,0);
	        int parts=0,extras=0;
	        if(((int) size/k)==0){
	            parts=1;
	            extras=0;
	        }else{
	            parts=size/k;
	            extras=size%k;
	        }
	        
	        ListNode[] result = new ListNode[k];
	        int j=0;
	        ListNode prev=null;
	        for(int i=0; i<k ;i++){
	           result[i]= root;
	            while(j!=parts){
	            if(root!=null) {
	            	prev=root;
	                root=root.next;
	            }
	            j++;
	            }
	            if(extras>0){
	            prev=root;
	            root=root.next;
	            extras--;
	            }
	            prev.next=null;
	            j=0;
	        }
	        
	        return result;
	    
    }
    
    private int getListSize(ListNode root, int size){
        if(root==null)
            return size;
        
        return getListSize(root.next,size+1);
    }
}