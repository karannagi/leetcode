package com.leetcode.solutions;

import java.util.Arrays;

class Solution646 {
    public int findLongestChain(int[][] pairs) {	 
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
		  int curr=Integer.MIN_VALUE, longestChain=0;
		  for(int[] pair:pairs) {
			  if(curr<pair[0]) {
				  curr=pair[1];
				  longestChain++;
			  }
		  }
	    
	    return longestChain;
    }
}
