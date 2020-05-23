package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

//Definition for a Node.
class NodeN {
 public int val;
 public List<NodeN> children;

 public NodeN() {}

 public NodeN(int _val) {
     val = _val;
 }

 public NodeN(int _val, List<NodeN> _children) {
     val = _val;
     children = _children;
 }
};


class Solution589 {
 public List<Integer> preorder(NodeN root) {
     return dfs(root,new ArrayList<Integer>());
 }
 
 List<Integer> dfs(NodeN root,List<Integer> result){
     if(root ==null)
         return result;
     
     result.add(root.val);
     for(NodeN child:root.children){
         dfs(child,result);
     }
     return result;
 }
}