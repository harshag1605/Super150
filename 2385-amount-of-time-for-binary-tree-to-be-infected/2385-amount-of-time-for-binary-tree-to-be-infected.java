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
    class Pair{
        int ht;
        boolean found;
        public Pair(int ht, boolean found){
            this.ht = ht;
            this.found = found;
        }
    }
    int depth = 0;
    int subDepth = 0;
    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return Math.max(depth, subDepth);
    }
    private Pair dfs(TreeNode root, int start){
        if(root == null){
            return new Pair(0, false);
        }
        Pair right = dfs(root.left, start);
        Pair left = dfs(root.right, start);
        if(root.val == start){
            subDepth = Math.max(right.ht ,left.ht);
            return new Pair(1, true);
        }
        if(left.found){
            depth = Math.max(depth, left.ht + right.ht);
            left.ht++;
            return left;
        }
        if(right.found){
            depth = Math.max(depth, left.ht + right.ht);
            right.ht++;
            return right;
        }
        return new Pair(Math.max(right.ht, left.ht) + 1, false);
    }
}