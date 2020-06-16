package com.leetcode.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution819 {

	 public String mostCommonWord(String paragraph, String[] banned) {
	        //sanitize
	        paragraph = paragraph.replaceAll("\\,"," ");
			paragraph = paragraph.replaceAll("[^A-Za-z ]","");
	        String[] words = paragraph.split(" ");
	        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
	        Map<String,Integer> freq = new HashMap<>();
	        String mostFrequent=null;
	        int mostFrequentCount = -1;
	        for(String word : words){
	            if(word.length()<1)
	                continue;
	            word = word.toLowerCase();
	            if(freq.containsKey(word)){
	               int count = freq.get(word);
	                count++;
	                if(count>mostFrequentCount){
	                    mostFrequentCount = count;
	                    mostFrequent = word;
	                }
	                freq.put(word,count);
	            }else if(!bannedSet.contains(word)){
	                if(mostFrequentCount<0){
	                    mostFrequentCount = 1;
	                    mostFrequent = word;
	                }
	                freq.put(word,1);
	            }
	        }
	        return mostFrequent;
	    }

}
