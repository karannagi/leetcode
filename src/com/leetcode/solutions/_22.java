package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

class Solution22 {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        int right=n;
        int left=n;
        generateParenthesisUtil("(",n-1,right);
        return result;
    }
    
    void generateParenthesisUtil(String comb,int left,int right){
        if(left==0 && right ==0){
            result.add(comb);
            return;
        }
        
        if(left<right)
            generateParenthesisUtil(comb+")",left,right-1);
        if(left>0)
            generateParenthesisUtil(comb+"(",left-1,right);
    }
}
