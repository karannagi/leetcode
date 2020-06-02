package com.leetcode.solutions;

import java.util.LinkedList;

class Solution207 {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] dependencyList = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            dependencyList[prerequisites[i][0]]++;
        }
        int count=0;
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(dependencyList[i]==0)
                stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int currCourse = stack.pop();
            count++;
            for(int i=0;i<prerequisites.length;i++){
                if(prerequisites[i][1] == currCourse){
                    dependencyList[prerequisites[i][0]]--;
                    if(dependencyList[prerequisites[i][0]]==0)
                        stack.push(prerequisites[i][0]);    
                }
                    
            }
        }
        return numCourses == count;
    }

}
