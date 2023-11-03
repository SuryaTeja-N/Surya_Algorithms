# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        
        # in previous submission, we have already tried in naive dfs, but now we will use moris inorder traversal to make constant space complexity

        #moris traversal
        max_freq = 0; node_freq = 0; node_val = 0; ans = []
        curr = root
        while curr:

            if curr.left : #so left subtree is there, we can findout its rightmost node(friend) to connect to current node
               friend = curr.left
               while friend.right:
                   friend = friend.right
               
               #connect
               friend.right = curr

               #now, we made the imaginary link for curr, now we need to move to next curr 
               left = curr.left
               curr.left = None # so that we dont visit in this way
               curr = left

            else:
                num = curr.val 
                if num == node_val: # we are doing inorder moris traversal, so its sorted numbers, same node value things comes one by one, we are taking advantage of it
                    node_freq += 1
                else:
                    node_freq = 1  #its new node value
                    node_val = num #for comparing next node value frequency

                if node_freq > max_freq:
                    ans = []
                    max_freq = node_freq

                if node_freq == max_freq:
                    ans.append(num)

                curr = curr.right
        
        return ans
