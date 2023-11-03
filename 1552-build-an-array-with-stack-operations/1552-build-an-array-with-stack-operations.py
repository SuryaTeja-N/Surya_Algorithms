from collections import deque
class Solution:
    def buildArray(self, target: List[int], n: int) -> List[str]:
        
        
        
        # here we need to use stack, in python, we can use List or deque to implement stack.
        # deque provides an O(1) time complexity for append and pop operations as compared to list which provides O(n) time complexity. as we have so many push and pops, its better to deque.

        stack = deque(maxlen=101)
        up=0; ans = []
        for i in range(1,n+1):
            stack.append(i); ans.append("Push")
            if len(stack) == len(target) and stack[-1] == target[-1]: break
            elif stack[-1] == target[up]:
                up+=1
            elif stack[-1] != target[up]:
                stack.pop(); ans.append("Pop")
        return ans



