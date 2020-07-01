package com.leetcode.solutions;

import java.util.LinkedList;
import java.util.Queue;

class Solution733 {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[image.length][image[0].length];
        queue.offer(new int[]{sr,sc});
        int color = image[sr][sc];
        image[sr][sc] = newColor;
        int[][] direction = new int[][]{
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
        };
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int k=0;k<n;k++){
                int[] currPixel = queue.poll();
                visited[currPixel[0]][currPixel[1]] = true;
                for(int i=0;i<direction.length;i++){
                    int x = currPixel[0]+direction[i][0];
                    int y = currPixel[1]+direction[i][1];
                    if(x>=0 && x<image.length && y>=0 && y<image[0].length && !visited[x][y] && image[x][y]==color){
                        image[x][y]= newColor;
                        queue.offer(new int[]{x,y});
                    }
                }
                
            }
        }
        return image;
    }
}
