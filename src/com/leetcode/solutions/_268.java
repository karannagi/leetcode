package com.leetcode.solutions;

class Solution268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalCount = n*(n+1)/2;
        int currCount=0;
        for(int i=0;i<nums.length;i++){
            currCount+=nums[i];
        }
        return totalCount-currCount;
    }
}
