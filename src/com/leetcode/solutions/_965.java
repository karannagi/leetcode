package com.leetcode.solutions;

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
class Solution965 {
    int val;
    public boolean isUnivalTree(TreeNode root) {
        if(root==null)
            return true;
        else{
            val=root.val;
            return isUnivalTreeUtil(root,val);
        } 
            
    }
    private boolean isUnivalTreeUtil(TreeNode root, int val){
        if(root == null)
            return true;
       return root.val==val && isUnivalTreeUtil(root.left,val) && isUnivalTreeUtil(root.right,val);
        
        
    }
}