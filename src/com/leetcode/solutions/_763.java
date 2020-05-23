package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution763 {
    public List<Integer> partitionLabels(String S) {
        if(S==null || S.length()==0)
            return new ArrayList<>();
		Map<Character,Integer> startIndex= new HashMap<>();
		Map<Character,Integer> endIndex= new HashMap<>();
		List<Integer> partitions = new ArrayList<>();
        
 		for(int i=0;i<S.length();i++) {
			if(!startIndex.containsKey(S.charAt(i))) {
				startIndex.put(S.charAt(i), i);
			}
		}
		for(int i=S.length()-1;i>=0;i--) {
			if(!endIndex.containsKey(S.charAt(i))) {
				endIndex.put(S.charAt(i), i);
			}
		}
        
        int start=startIndex.get(S.charAt(0));
        int end=endIndex.get(S.charAt(0));
        for(int i=1;i<S.length();i++){
            Character c = S.charAt(i);
            if(startIndex.get(c)<end && endIndex.get(c)>end)
                end=endIndex.get(c);
            else if(startIndex.get(c)>end){
                partitions.add(end-start+1);
                start=startIndex.get(c);
                end=endIndex.get(c);
            }
        }
        
        partitions.add(end-start+1);
        
        return partitions;
    }
}
