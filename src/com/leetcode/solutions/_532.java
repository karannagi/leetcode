package com.leetcode.solutions;

import java.util.HashMap;

class Solution532 {
    public int findPairs(int[] nums, int k) {   if(k < 0) {
            return 0;
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            Integer currentCount = countMap.get(nums[i]);
            if(currentCount == null) {
                currentCount = 0;
            }
            currentCount++;
            countMap.put(nums[i], currentCount);
        }
        int count = 0;
        for(int key : countMap.keySet()) {
            if(k == 0) {
                int occuranceCount = countMap.get(key);
                if(occuranceCount > 1) {
                    count++;
                }
            } else {
                int target2 = key + k;
                int targetCount2 = countMap.get(target2) != null ?  countMap.get(target2) : 0;
                if(targetCount2 > 0) {
                    count++;
                }
            }
        }
        return count;
    
        
    }
}
