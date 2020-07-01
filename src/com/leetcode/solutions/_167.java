package com.leetcode.solutions;

class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0)
            return new int[]{};
        int start=0,end=numbers.length-1;
        boolean found = false;
        while(start<end){
            int currSum = numbers[start]+numbers[end];
            if(target == currSum){
                found = true;
                break;
            }
            else if(target > currSum)
                start++;
            else if(target < currSum)
                end--;
        }
        if(found){
            return new int[]{++start,++end};
        }
        else{
            return new int[]{};
        }
            
    }
}
