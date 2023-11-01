# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        
        #lets make dfs traversal function to visit every node
        def dfs(node : TreeNode, track : defaultdict): #in in-order

            #base case:
            if not node:
                return #stop
            
            #as this is in-order,
            #insert left child 
            dfs(node.left, track)
            # get and increment the node counter value
            track[node.val] += 1
            #insert right child
            dfs(node.right, track)

        # we need a hashmap (dictonary in python) to track freq of nodes
        track = defaultdict(int)
        #do the dfs now
        dfs( root, track)
        #as we got the freqs, we need to find mode (max freq)
        maxi = max(track.values())

        #as per asked, we need to return list of node values with this max freq
        ans = []

        for i in track.keys():
            if track[i] == maxi:
                ans.append(i)
        
        return ans