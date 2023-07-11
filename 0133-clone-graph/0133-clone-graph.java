/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    HashMap<Node,Node> seen = new HashMap<>();

    public Node cloneGraph(Node node) {
        
        if (node == null) return node;

        //if we have already seen that node
        if(seen.containsKey(node)){
            return seen.get(node);  //get that value.{to attcah as neighbors \U0001f605}
        }
        
        //if we have not visted that node before
        Node copied_node = new Node(node.val,new ArrayList<>()); //creat a copy
        seen.put(node,copied_node); // update seen

        for(Node neighbor : node.neighbors){ //attach neighbors to copied_node
            copied_node.neighbors.add(cloneGraph(neighbor));
        }
        
        //after all the hell of this recursion, return final root copied_root_node
        return copied_node;
    }
}