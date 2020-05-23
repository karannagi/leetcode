package com.leetcode.solutions;

import java.util.LinkedList;
import java.util.Queue;

class Solution994 {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0)
            return -1;
        int maxMinute=0;
        int freshOranges=0;
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    freshOranges++;
                else if(grid[i][j]==2){
                    queue.offer(new int[]{i,j,0});
                }
            }
        }
        if(freshOranges==0)
            return 0;
        
        int[][] direction = new int[][]{
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };
        while(!queue.isEmpty()){
            int[] vertex=queue.poll();
            for(int i=0;i<direction.length;i++){
            int xMove= vertex[0]+direction[i][0];
            int yMove= vertex[1]+direction[i][1];
            if(xMove>=0 && xMove<grid.length && yMove>=0 && yMove<grid[0].length){
                if(grid[xMove][yMove]==1){
                    grid[xMove][yMove]=2;
                    freshOranges--;
                    queue.offer(new int[]{xMove,yMove,vertex[2]+1});
                    if(vertex[2]+1>maxMinute)
                        maxMinute=vertex[2]+1;
                }
                }
            }
            
        }
        
        if(freshOranges==0)
            return maxMinute;
        else
            return -1;
        
    }
}