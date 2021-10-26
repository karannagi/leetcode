package com.leetcode.solutions;

class Solution1010 {
	public int numPairsDivisibleBy60(int[] time) {
		int[] arr = new int[time.length];
		for(int i =0; i< time.length ;i++)
			arr[i] = time[i]%60;
		int count =0;
		int[] map = new int[61];

		for(int i=0 ;i<time.length ;i++) {
			if(arr[i]>0)
				count += map[60 - arr[i]];
			else
				count += map[-arr[i]];
			map[arr[i]]++;
		}

		return count;

	}
}
