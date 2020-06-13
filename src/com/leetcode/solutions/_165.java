package com.leetcode.solutions;

class Solution165 {

	 public int compareVersion(String version1, String version2) {
	       String[] v1 = version1.split("\\.");
	       String[] v2 = version2.split("\\.");
	        int n1 = v1.length;
	        int n2 = v2.length;
	        int n = Math.max(n1,n2);
	        
	        for(int i=0;i<n;i++){
	            int num1 = (i>n1)?0:Integer.parseInt(v1[i]);
	            int num2 = (i>n2)?0:Integer.parseInt(v2[i]);
	            if(num1!=num2){
	                return num1>num2 ? 1 : -1;
	            }
	        }
	        return 0;
	    }
}
