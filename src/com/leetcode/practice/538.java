/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public TreeNode convertBST(TreeNode root) {
        TreeNode head=root;
        dfs(root);
        return head;
    }
    int value=0;
    void dfs(TreeNode root){
        if(root==null)
            return;
        dfs(root.right);
        value+=root.val;
        root.val=value;
        dfs(root.left);        
    }
}
