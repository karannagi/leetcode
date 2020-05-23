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
class Solution662 {
 static class Triple {
        TreeNode node;
        int index;
        int level;
        
        Triple(TreeNode node, int index, int level) {
            this.node = node;
            this.level = level;
            this.index = index;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        
        Queue<Triple> q = new LinkedList<>();
        q.offer(new Triple(root, 1, 0));
        
        int min = Integer.MAX_VALUE;
        int max = 0;
        int prev = 0;
        
        int result = 0;
        while (!q.isEmpty()) {
            Triple elem = q.poll();
            TreeNode node = elem.node;
                        
            if (elem.level == prev) {
                min = Math.min(min, elem.index);
                max = Math.max(max, elem.index);
            } else {
                result = Math.max(result, max - min + 1);
                max = elem.index;
                min = elem.index;
            }
            
            if (node.left != null) {
                q.offer(new Triple(node.left, elem.index * 2, elem.level + 1));
            }
            
            if (node.right != null) {
                q.offer(new Triple(node.right, elem.index * 2 + 1, elem.level + 1));
            }
            
            prev = elem.level;
        }
        result = Math.max(result, max - min + 1);
        return result;
    }
}