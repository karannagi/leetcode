package com.leetcode.solutions;

class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;

        int count = 0;
        ListNode lastOdd = null;
        ListNode lastEven = null;
        ListNode firstEven = null;
        ListNode firstOdd = null;
        while (head != null) {
            if (count % 2 == 0) {
                if (lastEven == null) {
                    lastEven = head;
                    firstEven = head;
                } else {
                    lastEven.next = head;
                    lastEven = head;
                }
            } else {
                if (lastOdd == null) {
                    lastOdd = head;
                    firstOdd = head;
                } else {
                    lastOdd.next = head;
                    lastOdd = head;
                }
            }
            head = head.next;
            count++;
        }
        if (lastOdd != null)
            lastOdd.next = null;

        lastEven.next = firstOdd;
        return firstEven;

    }
}
