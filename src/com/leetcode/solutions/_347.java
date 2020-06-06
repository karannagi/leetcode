package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution347 {

	public int[] topKFrequent(int[] nums, int k) {

		Map<Integer,Integer> numMap = new HashMap<>();

		for(int i=0;i<nums.length;i++)
			numMap.put(nums[i],numMap.getOrDefault(nums[i],0)+1);

		List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(numMap.entrySet());
		Collections.sort(entryList, (o2,o1)->{
			return Integer.compare(o1.getValue(),o2.getValue());
		});

		return entryList.stream().map(x->x.getKey()).limit(k).mapToInt(Integer::intValue).toArray();
	}

}
