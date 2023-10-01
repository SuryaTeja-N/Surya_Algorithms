/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node first = null, last = null;
    //we need to traverse the tree, we will do in-order DFS
    private void recurse(Node curr){
        if(curr == null) return;
        //we need to go to leftmost (asusual inorder)
        recurse(curr.left);
        //2) see, here after we will get new value, so we need to do linkings with previous value
        if (last != null){ //checking if previous is there or not
           //link now
           last.right = curr;
           curr.left = last;
        }else{
            //if previous value is nothing, lets keep its as first value
            first = curr;
        }
        // apart from just looking each node, we need to do linkings, so lets keep track with last pointer
        last = curr;
        //we need to go to rightmost (asusual inorder)
        recurse(curr.right);
    }
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        recurse(root);
        //close the DLL
        last.right = first; first.left = last;
        return first;
    }
}