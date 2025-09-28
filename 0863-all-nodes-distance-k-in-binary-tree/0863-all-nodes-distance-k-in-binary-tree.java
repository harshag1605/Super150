/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> childParentMap = new HashMap<>();
    Set<TreeNode> visited = new HashSet<>();
    List<Integer> ans = new ArrayList<>(); 
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        map(root);
        dfs(target, k);
        return ans;
    }
    private void map(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left != null){
            childParentMap.put(root.left, root);
            map(root.left);
        }
        if(root.right != null){
            childParentMap.put(root.right, root);
            map(root.right);
        }
    }
    private void dfs(TreeNode target, int k){
        if(target == null || visited.contains(target)){
            return;
        }
        visited.add(target);
        if(k == 0){
            ans.add(target.val);
            return;
        }
        dfs(target.left,  k - 1);
        dfs(target.right, k - 1);
        dfs(childParentMap.get(target), k - 1);
    }
}