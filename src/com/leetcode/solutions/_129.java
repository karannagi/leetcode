package com.leetcode.solutions;

class Solution129 {
	    int sum =0;
	    public int sumNumbers(TreeNode root) {
	        if(root == null)
	            return 0;
	        calc(root,0);
	        return sum;
	    }
	    
	    void calc(TreeNode root,int val){
	        if(root.left == null && root.right == null){
	            sum = root.val+val*10;
	        }
	        if(root.left != null){
	            calc(root.left,val*10+root.val);
	        }
	        if(root.right != null){
	            calc(root.right,val*10+root.val);
	        }
	    }
	

}
