package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> valuesMap = new HashMap<>();
        for(int i=0;i<words.length;i++){
            valuesMap.put(words[i],valuesMap.getOrDefault(words[i],0)+1);
        }
        List<Map.Entry<String, Integer>> valuesList = new ArrayList<>(valuesMap.entrySet());
        Collections.sort(valuesList,new Comparator<Map.Entry<String,Integer>>(){

			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
			    int cmp1=o2.getValue()-o1.getValue();
                if(cmp1!=0){
                    return cmp1;
                }
                else{
                    return o1.getKey().compareTo(o2.getKey());
                }
            
			}
        	
        });

	
        
       return valuesList.stream().map(x->x.getKey()).limit(k).collect(Collectors.toList());
    }
}