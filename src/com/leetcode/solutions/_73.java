package com.leetcode.solutions;

class Solution73 {
    public void setZeroes(int[][] matrix) {
          boolean firstRowZero=false;
        
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==0)
                firstRowZero=true;
        }
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0)
                    matrix[0][j]=0;
            }
        }
        
        for(int i=1;i<matrix.length;i++){
            boolean containsZero=false;
            for(int j=0;j<matrix[0].length;j++){
             if(matrix[i][j]==0)
                 containsZero=true;
            }
            for(int j=0;j<matrix[0].length;j++){
             if(containsZero || matrix[0][j]==0)
                 matrix[i][j]=0;
            }
        }
        
        if(firstRowZero){
                for(int i=0;i<matrix[0].length;i++)
                    matrix[0][i]=0;
        }
        }
    }
