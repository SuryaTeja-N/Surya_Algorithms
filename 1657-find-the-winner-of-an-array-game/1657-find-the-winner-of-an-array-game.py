from collections import deque

class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:

        maxi = max(arr)
        
        if k >= len(arr) : return maxi

        curr = arr[0] ; win=0

        for val in range(1, len(arr)):

            oppo = arr[val]

            if curr > oppo:

                win += 1
            
            else:

                win =1; curr = oppo
            
            if win == k or curr == maxi: return curr

           
