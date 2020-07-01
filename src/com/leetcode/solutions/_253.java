package com.leetcode.solutions;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution253 {

	 public int minMeetingRooms(int[][] intervals) {
	        if(intervals==null || intervals.length==0)
	            return 0;
	        Queue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
	        int count = 0;
	        for(int i=0;i<intervals.length;i++){
	            pq.offer(intervals[i]);
	        }
	        PriorityQueue<Integer> queue = new PriorityQueue<>();
	        while(!pq.isEmpty()){
	            int[] curr = pq.poll();
	            if(queue.isEmpty()){
	                count++;
	                queue.offer(curr[1]);
	                continue;
	            }
	            else if(queue.peek()<=curr[0]){
	                queue.poll();
	                queue.offer(curr[1]);
	                continue;
	            }
	            else{
	              count++;
	                queue.offer(curr[1]);
	            }
	            

	        }
	        return count;
	    }
}
