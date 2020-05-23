package com.leetcode.solutions;

import java.util.LinkedList;
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
class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        if(root.left==null && root.right==null)
            return true;
        if((root.left!=null && root.right==null)|| (root.left==null && root.right!=null))
            return false;
        
        Queue<TreeNode> leftTree = new LinkedList<>();
        Queue<TreeNode> rightTree = new LinkedList<>();
        leftTree.offer(root.left);
        rightTree.offer(root.right);
        while(!leftTree.isEmpty() && !rightTree.isEmpty()){
            TreeNode left=leftTree.poll();
            TreeNode right=rightTree.poll();
            if((left==null && right!=null )|| (right==null && left!=null))
                return false;
            if(left==null && right==null )
                continue;
            
            if(left.val!=right.val)
                return false;

           leftTree.offer(left.right);
           leftTree.offer(left.left);
           rightTree.offer(right.left);
           rightTree.offer(right.right);
        }
        
        if(!leftTree.isEmpty() || !rightTree.isEmpty())
            return false;
        else
            return true;
    }
}
