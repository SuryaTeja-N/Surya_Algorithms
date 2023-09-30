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
    private void recurse(List<Integer> ans, TreeNode node){
        if(node != null){
            recurse(ans,node.left);
            ans.add(node.val);
            recurse(ans,node.right);
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // //so to convert the recursive to iterative, we can use stack here
        // Stack<TreeNode> stack = new Stack<>(); //to store tree nodes
        // //lets traverse
        // TreeNode curr = root;
        // //remember, inorder traversal is bottom-up, so first we need to go down
        // while(curr != null || !stack.isEmpty()){
        //     while(curr != null){ //go down while pushing all to stack alnog the way
        //         stack.push(curr);
        //         curr = curr.left; //we want to go left side right!!!
        //     }
        //     //ok,so after reaching to left most, start the poping out
        //     curr = stack.pop();
        //     ans.add(curr.val);
        //     curr = curr.right;
        // }
        recurse(ans,root);
        return ans;
    }
}