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
    // private void recurse(int level, TreeNode curr){
    //    //so, at current level, we need to make a list (its base case)
    //    if(ans.size() == level){
    //        ans.add(new ArrayList<Integer>());
    //    }
    //    // we need to fill that
    //    ans.get(level).add(curr.val);

    //    //as per tradition, we need to use while loop (as it is BST) but no need of it.. we will just push other child nodes (remember, BFS is left to right and top-down)
    //    if(curr.left != null) recurse(level+1, curr.left);
    //    if(curr.right != null) recurse(level+1, curr.right);
    // }
    public List<List<Integer>> levelOrder(TreeNode root) {
        ans = new ArrayList<>(); 
        if(root == null) return ans;
        // it is evident that we need to use BFS here
        //but as per BFS tradition lets try with queue only..(iterative approach)
        Queue<TreeNode> que = new LinkedList<>();
        int level=0; //we also need to track the level rigth!!!
        //fill the queue before starting the loop
        que.add(root);
        //now start the loop
        while(!que.isEmpty()){
           //start the level
           ans.add(new ArrayList<>());
           //we need to add elements of that level to new list in ans
           int level_len = que.size();
           for(int i=0; i<level_len; ++i){
              TreeNode curr = que.remove(); //pop
              //add that
              ans.get(level).add(curr.val);
              //push its child to queue
              if(curr.left != null) que.add(curr.left);
              if(curr.right != null) que.add(curr.right);
           }
           level++; //next level
        }
        //recurse(level,root);
        return ans;
    }
}