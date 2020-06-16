package com.leetcode.solutions;

class Solution8 {
    public int myAtoi(String str) {
        boolean numFound = false;
        boolean signFound = false;
        int sign=1;
        int number = 0;
        for(char c : str.toCharArray()){
            if(!numFound && !signFound){
                if(c == '-'){
                    sign = sign*-1;
                    signFound = true;
                }
                else if(c == '+'){
                    sign = sign * 1;
                    signFound = true;
                }
                else if(c>='0' && c<='9'){
                    numFound = true;
          
                    number = number*10 + Integer.parseInt(String.valueOf(c));
          
                    
                }
                else if(c == ' ')
                    continue;
                else {
                    return 0;
                }
            }else if(!numFound && signFound){
                 if(c>='0' && c<='9'){
                     numFound = true;
                    number = number*10 + Integer.parseInt(String.valueOf(c));
                }else {
                     return 0;
                 }
            }
            else if(numFound){
                if(c>='0' && c<='9'){
                     long interimNum = (long)number*10 + Integer.parseInt(String.valueOf(c));
                    if(interimNum>Integer.MAX_VALUE){
                        if(sign == 1) {
                       	 return Integer.MAX_VALUE;
                        }else {
                        	return Integer.MIN_VALUE;
                        }
                    }
                    else{
                    number = number*10 + Integer.parseInt(String.valueOf(c));
                    }  
                }else {
                  break;
                 }
            }
            
        }
        return number*sign;

    }
}
