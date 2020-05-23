package com.leetcode.solutions;

import java.util.LinkedList;
import java.util.Queue;

class Solution529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = new int[][] {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1},
            {1,1},
            {1,-1},
            {-1,1},
            {-1,-1}
        };
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board;
        }
            
        queue.offer(click);
        while(!queue.isEmpty()){
            int[] currPos=queue.poll();
            if(board[currPos[0]][currPos[1]]!='E')
                continue;
            
            char mines='0';
            
            int neighbors=0;
            int[][] nextValues = new int[8][2];
            for(int i=0;i<dir.length;i++){
                int x = currPos[0]+dir[i][0];
                int y = currPos[1]+dir[i][1];
                if(x>=0 && x<board.length && y>=0 && y<board[0].length){
                   nextValues[neighbors] = new int[]{x,y};
                    neighbors++;
                    
                  if(board[x][y]=='M') 
                      mines++;
                }
            }
           if(mines!='0'){
                board[currPos[0]][currPos[1]]=mines;
            }
            else{
                board[currPos[0]][currPos[1]]='B';
                for(int i=0;i<neighbors;i++){
                    queue.offer(nextValues[i]);
                }
            }
        }
        
        return board;
    }
}
