package com.leetcode.solutions;

import java.util.LinkedList;
import java.util.Queue;

class Solution200 {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0)
            return 0;
        Queue<int[]> queue = new LinkedList<>();
	        int islands=0;
	        int direction[][] = new int[][]{
	            {-1,0},
	            {0,1},
	            {0,-1},
	            {1,0}
	        };
	        for(int i=0;i<grid.length;i++){
	            for(int j=0;j<grid[0].length;j++){
	                if(grid[i][j] == '0')
	                    continue;
	                
	                queue.offer(new int[]{i,j});
	                grid[i][j]='0';
	                while(queue.size()!=0){
	                    int[] currentLoc = queue.poll();
	                    
	                    for(int k=0;k<direction.length;k++){
	                      int x=currentLoc[0]+direction[k][0];
	                      int y=currentLoc[1]+direction[k][1];
	                        if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]=='1'){
	                              queue.offer(new int[]{x,y});  
	                            grid[x][y]='0';
	                        }
	                    }
	                if(queue.size()==0){
	                    islands++;
	                }
	                }
	                
	                
	            }
	        }
	        return islands;
    }
}
