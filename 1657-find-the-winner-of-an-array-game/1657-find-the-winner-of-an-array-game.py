from collections import deque

class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:
        
        if k >= len(arr) : return max(arr)

        que = deque(arr[1 : ]) ; curr = arr[0] ; win=0
        
        while que:

           oppo = que.popleft()
           
           if curr > oppo:

               que.append(oppo) ; win += 1
            
           else:

               que.append(curr)

               curr = oppo

               win =1
            
           if win == k: return curr

           
