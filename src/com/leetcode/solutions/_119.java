package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> levelList= new ArrayList<>();
        levelList.add(1);
        List<Integer> tmpList= new ArrayList<>();
        for(int i=0;i<levelList.size()+1;i++){
            if(levelList.size()-1==rowIndex)
                return levelList;
            
            if(i==0)
                tmpList.add(1);
            else if(i==levelList.size()){
                tmpList.add(1);
                i=-1;
                levelList=tmpList;
                tmpList=new ArrayList<>();
            }
            else{
                tmpList.add(levelList.get(i-1)+levelList.get(i));
            }
                
                
        }
        return levelList;
    }
}
