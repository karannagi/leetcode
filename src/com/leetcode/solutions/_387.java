package com.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

class Solution387 {

    public int firstUniqChar(String s) {
    Map<Character,Integer> charCount = new HashMap<>();
        for(char a : s.toCharArray()){
            charCount.put(a, charCount.getOrDefault(a,0)+1);
        }
        for(int i=0; i<s.length();i++){
            if(charCount.get(s.charAt(i))==1)
                return i;
        }
         return -1;
}
}
