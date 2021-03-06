package com.leetcode.solutions;

class Solution48 {
    public void rotate(int[][] matrix) {
	        int n= matrix.length;
	       for(int i=0;i<matrix.length/2;i++){
	           for(int j=i;j<matrix.length-i-1;j++){
	               int tmp=matrix[i][j];
	               matrix[i][j] = matrix[matrix.length-1-j][i];
	               matrix[matrix.length-1-j][i] = matrix[matrix.length-1-i][matrix.length-1-j];
	               matrix[matrix.length-1-i][matrix.length-1-j] = matrix[j][matrix.length-1-i];
	               matrix[j][n-1-i] = tmp;
	           }
	       }	    
    }
}