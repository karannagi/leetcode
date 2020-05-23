package com.leetcode.solutions;

import java.util.HashSet;
import java.util.Set;

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
       Set<Character> charSet = new HashSet<>();
        int start=0,maxLength=0,currentLength=0;
        for(int i=0;i<s.length();i++){
            if(charSet.contains(s.charAt(i))){
 
                currentLength=0;
                i=start;
                start=i+1;
                charSet.clear();
            }else{
                charSet.add(s.charAt(i));
                currentLength++;
                if(currentLength>maxLength)
                    maxLength=currentLength;
            }
        }
        return maxLength;
    }
}
