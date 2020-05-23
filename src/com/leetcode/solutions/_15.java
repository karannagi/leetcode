package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
		if(nums.length<3)
			return new ArrayList<>();

		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for(int i=0;i<nums.length-2;i++){
			if(i>0 && nums[i] == nums[i-1])
				continue;
			int low=i+1;
			int high= nums.length-1;
			int sum=0-nums[i];
			while(low<high){
				if(nums[low]+nums[high]==sum){
					result.add(Arrays.asList(nums[i],nums[low],nums[high]));
					while(low<high && nums[low]==nums[low+1]) low++;
					while(low<high && nums[high]==nums[high-1]) high--;
					low++;
					high--;

				}
				else if(nums[low]+nums[high]>sum){
					high--;
				}
				else {
					low++;
				}

			}
		}
		return result;
	
	
    }
}
