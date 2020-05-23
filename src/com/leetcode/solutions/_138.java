package com.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

//Definition for a Node.
class Node {
 int val;
 Node next;
 Node random;

 public Node(int val) {
     this.val = val;
     this.next = null;
     this.random = null;
 }
}


class Solution138 {
 public Node copyRandomList(Node head) {
    Map<Node,Node> copiedValuesMap = new HashMap<>();
     Node temp = head;
     Node newNode=null;
     while(temp!=null){
         newNode = new Node(temp.val);
         copiedValuesMap.put(temp,newNode);
         temp=temp.next;
     }
     
     temp=head;
     while(temp!=null){
         newNode = copiedValuesMap.get(temp);
         newNode.next= copiedValuesMap.get(temp.next);
         newNode.random=copiedValuesMap.get(temp.random);
         temp=temp.next;
     }
     return copiedValuesMap.get(head);
 }
}
