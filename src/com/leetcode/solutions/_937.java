package com.leetcode.solutions;

import java.util.Arrays;

class Solution937 {
    public String[] reorderLogFiles(String[] logs) {
  Arrays.sort(logs, (log1, log2) -> {
            String parsedLog1 = log1.substring(log1.indexOf(" ") + 1, log1.length());
            String parsedLog2 = log2.substring(log2.indexOf(" ") + 1, log2.length());
            
            boolean isDigit1 = Character.isDigit(parsedLog1.charAt(0));
            boolean isDigit2 = Character.isDigit(parsedLog2.charAt(0));
            
            if (!isDigit1 && !isDigit2) {
                int comparisonResult = parsedLog1.compareTo(parsedLog2);
                
                if (comparisonResult == 0) {
                    String identifier1 = log1.substring(0, log1.indexOf(" "));
                    String identifier2 = log2.substring(0, log2.indexOf(" "));
                    return identifier1.compareTo(identifier2);
                } else {
                    return comparisonResult;   
                }
            }
            
            return isDigit1 ? (isDigit2 ? 0: 1) : -1;
        });
        
        return logs;
    }
}
