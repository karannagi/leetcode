package com.leetcode.solutions;

class Solution230 {
	 private int smallest = 0;
	    private int nodesVisited = 0;
	    public int kthSmallest(TreeNode root, int k) {
	        findSmallest(root,k);
	        return smallest;
	    }
	    void findSmallest(TreeNode root, int k){
	        if(root == null)
	            return;
	        findSmallest(root.left,k);
	        nodesVisited++;

	        if(nodesVisited==k)
	            smallest = root.val;
	        findSmallest(root.right,k);
	        
	        
	    }
}
