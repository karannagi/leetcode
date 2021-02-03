package com.leetcode.solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution37 {
	  public boolean isValidSudoku(char[][] board) {
	       Map<Integer,Set<Integer>> numberMap= getMap();
	        Map<Integer,Set<Integer>> rows = getMap();
	        Map<Integer,Set<Integer>> cols = getMap();
	        for(int i=0;i<board.length;i++){
	            for(int j=0;j<board[0].length;j++){
	                if(board[i][j] != '.'){
	                    int index = (i / 3 ) * 3 + j / 3; 
	                    int number = Integer.parseInt(String.valueOf(board[i][j]));
	                    if(numberMap.get(index).contains(number)
	                      || rows.get(i).contains(number)
	                       || cols.get(j).contains(number)
	                      )
	                        return false;
	                    else{
	                        numberMap.get(index).add(number);
	                        rows.get(i).add(number);
	                        cols.get(j).add(number);
	                    }
	                }
	            }
	        }
	        return true;

	    }
	    
	    private Map<Integer,Set<Integer>>  getMap(){
	        Map<Integer,Set<Integer>> map = new HashMap<>();
	        for(int i=0;i<9;i++)
	            map.put(i,new HashSet<>());
	        
	        return map;
	    }
}
