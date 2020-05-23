package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
class Solution508 {
    Map<Integer,Integer> sumMap = new HashMap<>();
    List<Integer> rootList= new ArrayList<>();
    int maxOccurence=0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root==null)
            return new int[0];
        
        findSumOfSubtrees(root);
        int[] sumArray = new int[rootList.size()];
        for(int i=0;i<rootList.size();i++){
            sumArray[i]=rootList.get(i);
        }
        return sumArray;
    }
    
    public int findSumOfSubtrees(TreeNode root){
        if(root==null)
            return 0;
        
        int sum = root.val+findSumOfSubtrees(root.left)+findSumOfSubtrees(root.right);
         int count = 1;
        if(sumMap.containsKey(sum)){
           count = sumMap.get(sum);
            count++;
            sumMap.put(sum,count);
        }
        else{
            sumMap.put(sum,1);
        }
                if(count>maxOccurence){
                maxOccurence=count;
                rootList.clear();
                rootList.add(sum);
            }
            else if(count==maxOccurence){
                rootList.add(sum);
            }
        return sum;
    }
}
