package com.leetcode.solutions;

import java.util.LinkedList;
import java.util.Queue;

class Solution116 {
    public Solution116.Node connect(Solution116.Node root) {
        if (root == null)
            return null;

        Queue<Solution116.Node> queue = new LinkedList<>();
        Solution116.Node head = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                Solution116.Node current = queue.poll();
                size--;
                if (size == 0)
                    current.next = null;
                else
                    current.next = queue.peek();
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
        }
        return head;
    }
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
