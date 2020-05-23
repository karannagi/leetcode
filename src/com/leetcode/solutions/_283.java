package com.leetcode.solutions;

import java.util.HashSet;
import java.util.Set;

class Solution283 {
    public void moveZeroes(int[] nums) {
     Set<Integer> zeroPosition= new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                zeroPosition.add(i);
        }
        int i=0,lastPosition=0;
        while(lastPosition<nums.length-zeroPosition.size()){
            if(nums[i]==0){
                i++;
                continue;
            }
            else{
                nums[lastPosition++]=nums[i++];
            }
        }
        while(lastPosition<nums.length){
            nums[lastPosition++]=0;
        }
    }
}
