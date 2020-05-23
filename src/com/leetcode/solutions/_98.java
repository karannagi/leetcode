package com.leetcode.solutions;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return isBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
    boolean isBSTUtil(TreeNode node, int min, int max) 
    { 
        if (node == null) 
            return true; 
    
        if(node.val==Integer.MIN_VALUE && node.left!=null)
            return false;
        if(node.val==Integer.MAX_VALUE && node.right!=null)
            return false;
        
        if (node.val < min || node.val > max) 
            return false; 
        
        return (isBSTUtil(node.left, min, node.val-1) && 
                isBSTUtil(node.right, node.val+1, max)); 
    } 
}