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
    private List<List<Integer>> ans;
    private void recurse(int level, TreeNode curr){
       //so, at current level, we need to make a list (its base case)
       if(ans.size() == level){
           ans.add(new ArrayList<Integer>());
       }
       // we need to fill that
       ans.get(level).add(curr.val);

       //as per tradition, we need to use while loop (as it is BST) but no need of it.. we will just push other child nodes (remember, BFS is left to right and top-down)
       if(curr.left != null) recurse(level+1, curr.left);
       if(curr.right != null) recurse(level+1, curr.right);
    }
    public List<List<Integer>> levelOrder(TreeNode root) { 
        ans = new ArrayList<>(); int level=0;
        if(root == null) return ans;
        recurse(level,root);
        return ans;
    }
}