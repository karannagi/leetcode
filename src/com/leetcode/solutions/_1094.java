package com.leetcode.solutions;

class Solution1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int start = 1001, end = -1;
        for (int i = 0; i < trips.length; i++) {
            if (trips[i][1] < start)
                start = trips[i][1];
            if (trips[i][2] > end)
                end = trips[i][2];
        }

        int[] tripPax = new int[end - start + 1];
        for (int i = 0; i < trips.length; i++) {
            tripPax[trips[i][1] - start] = tripPax[trips[i][1] - start] + trips[i][0];
            tripPax[trips[i][2] - start] = tripPax[trips[i][2] - start] - trips[i][0];
        }
        int paxes = 0;
        for (int i = 0; i < tripPax.length; i++) {
            paxes += tripPax[i];
            if (paxes > capacity)
                return false;
        }
        return true;
    }
}
