package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0;i<(1<<nums.length);i++){
            List<Integer> semiResult= new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if((i & (1<<j))>0){
                    semiResult.add(nums[j]);
                }
            }
            result.add(semiResult);
            
        }
        
        return result;
    }
}
