package com.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer,Integer> numberSet = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            numberSet.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            if(numberSet.containsKey(target-nums[i]) && i!=numberSet.get(target-nums[i]))              
                return new int[]{i,numberSet.get(target-nums[i])};
                                }
    return null;        
    }
        }
