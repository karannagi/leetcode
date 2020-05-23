package com.leetcode.solutions;

import java.util.LinkedList;
import java.util.Queue;

class Solution640 {
    public String solveEquation(String equation) {
		if(equation==null || equation.length()==0)
			return "No solution";

		String[] equations =  equation.split("=");
		int[] lhs = getEquationValues(equations[0]);
		int[] rhs = getEquationValues(equations[1]);

		int xCoeff = lhs[0]-rhs[0];
		int numbers= rhs[1]-lhs[1];
		if(xCoeff==0 && numbers==0)
			return "Infinite solutions";


		if(xCoeff==0)
			return "No solution";

		int xVal = numbers/xCoeff;
		return "x="+xVal;

	}

	private int[] getEquationValues(String equation){
		int xCoeff=0,n=0;
		equation = equation+" ";
		int mag=1;
		Queue<Integer> stack = new LinkedList<>();
		boolean xFlag=false;
		for(int i=0;i<equation.length();i++){
			char curr = equation.charAt(i);
			if(curr=='x'){
				if(stack.isEmpty()){
					xCoeff+=(mag*1);
				}else{
					int num=stack.poll();
					while(!stack.isEmpty()){
						num=num*10+stack.poll();
					}
					xCoeff+=(mag*num);
				}                
				xFlag=true;
			}
			else if(curr=='+' || curr=='-' || curr==' '){
				if(xFlag){
					xFlag=false;
				}else if(i>0){
					if(stack.isEmpty()){
						n+=(mag*1);
					}else{
						int num=stack.poll();
						while(!stack.isEmpty()){
							num=num*10+stack.poll();
						}
						n+=(mag*num);
					}

				}

				if(curr=='-') {
					mag=-1;
				}
				else if(curr=='+') {
					mag=1;
				}
			}
			else if(curr>='0' || curr<='9'){
				int currN= curr-48;
				stack.offer(currN);
			}

		}

		return new int[]{xCoeff,n};
	}
}
