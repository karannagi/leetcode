package com.leetcode.solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {


		Set<String> dict = new HashSet<>(wordDict);
		boolean[] visited = new boolean[s.length()];

		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);

		while(!queue.isEmpty()){
			int start = queue.poll();

			if(visited[start]) continue;

			for(int end = start + 1; end <= s.length(); end++){
				String word = s.substring(start,end);
				if(dict.contains(word)){
					if(end == s.length()) return true;
					queue.add(end);

				}
			}
			visited[start] = true;
		}

		return false;

	 }
}
