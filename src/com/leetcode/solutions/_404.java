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
class Solution404 {
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        
        return getSum(root,false);
    }
    
    private int getSum(TreeNode root, boolean isLeft){
        //to check if root is null
        if(root==null)
            return 0;
        
        //if both child are null that means we have reached leaf node and we check if it
        //is left node, if true then we add to sum
        if(root.left==null && root.right==null && isLeft){
            sum+=root.val;
            return sum;
        }
        //traverse left with flag as true
        getSum(root.left,true);
        //traverse right with flag as false
        getSum(root.right,false);
        
        //return sum
        return sum;
    }
}
