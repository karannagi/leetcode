package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
    
        Map<String,List<String>> resultMap = new HashMap<>();
        
        for(String str: strs){
            char[] charArray=str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr= new String(charArray);
            if(resultMap.containsKey(sortedStr)){
                resultMap.get(sortedStr).add(str);
            }else{
                List<String> indResult = new ArrayList<>();
                indResult.add(str);
                resultMap.put(sortedStr,indResult);
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for(Map.Entry<String,List<String>> e : resultMap.entrySet()){
            result.add(e.getValue());
        }
        
        return result;
    
    }
    
   
}