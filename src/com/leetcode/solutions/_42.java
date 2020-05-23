package com.leetcode.solutions;

class Solution42 {
    public int trap(int[] height) {
        if(height.length<3)
            return 0;
        
	        int[] maxHeightRight=new int[height.length];
	        int[] maxHeightLeft=new int[height.length];
	        maxHeightLeft[0]=height[0];
	        maxHeightRight[height.length-1]=height[height.length-1];
	        int water=0;
	        for(int i=1,j=height.length-2;i<height.length;i++,j--){
	            if(height[i]>maxHeightLeft[i-1])
	                maxHeightLeft[i]=height[i];
	            else
	                maxHeightLeft[i]=maxHeightLeft[i-1];
	            
	            if(height[j]>maxHeightRight[j+1])
	                maxHeightRight[j]=height[j];
	            else
	                maxHeightRight[j]=maxHeightRight[j+1];
	        }
	        
	        for(int i=0;i<height.length;i++){
	            if(height[i]<maxHeightLeft[i] && height[i]<maxHeightRight[i]){
	                water=water+Math.min(maxHeightLeft[i], maxHeightRight[i])-height[i];
	            }
	        }
	        return water;
	    
    }
}