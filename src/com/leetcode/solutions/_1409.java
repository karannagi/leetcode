package com.leetcode.solutions;

import java.util.LinkedList;

class Solution1409 {
	public int[] processQueries(int[] queries, int m) {
        int[] result = new int[queries.length];

        LinkedList<Integer> permutations = new LinkedList<>();
        
        for(int i=1;i<=m;i++){
             permutations.add(i);
        }
        
        for(int i=0;i<queries.length;i++){
         result[i] = permutations.indexOf(queries[i]);
         permutations.remove(result[i]);
         permutations.addFirst(queries[i]);
        }
    return result;
    }
}
