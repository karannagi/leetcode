package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        List<List<Integer>> result = new ArrayList<>();
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int numberOfNodes = queue.size();
            List<Integer> nodesOnLevel = new ArrayList<>();
            for (int i = 0; i < numberOfNodes; i++) {
                TreeNode curr = queue.remove();
                nodesOnLevel.add(curr.val);
                
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            
            result.add(nodesOnLevel);
        }
        
        return result;
}
}