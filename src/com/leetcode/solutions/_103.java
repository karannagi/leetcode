package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if(root==null)
                return new ArrayList<>();
	        List<List<Integer>> result= new ArrayList<>();
	        List<Integer> subList = new LinkedList<>();
            result.add(subList);
	        Queue<Node> queue = new LinkedList<Node>();
	        queue.add(new Node(root,0));
	        while(!queue.isEmpty()){
	            Node curr = queue.poll();
	            if(result.size()<curr.level+1){
	                List<Integer> levelList = new LinkedList<>();
	                levelList.add(curr.n.val);
	                result.add(levelList);
	            }
	            else{
	                if(curr.level%2==0){
	                    result.get(curr.level).add(curr.n.val);
	                }
	                else{
	                	LinkedList<Integer> levelList =(LinkedList<Integer>) result.get(curr.level);
	                	levelList.addFirst(curr.n.val);
	                }
	            }
	            if(curr.n.left!=null)
	                queue.add(new Node(curr.n.left,curr.level+1));
	            if(curr.n.right!=null)
	                queue.add(new Node(curr.n.right,curr.level+1));
	        }
	        
	        return result;
	    
    }
    static class Node{
        TreeNode n;
        int level;
        Node(TreeNode n, int level){
            this.n=n;
            this.level=level;
        }
    }
}
