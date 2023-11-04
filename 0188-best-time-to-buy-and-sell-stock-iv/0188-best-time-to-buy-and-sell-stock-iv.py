class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        
        if k == 0 : return 0

        profit =  [0] * (k + 1)
        buy = [float('inf')] * (k + 1)

        profit[0] = 0

        for price in prices:

            for i in range(k):

                 buy[i+1] = min (buy[i+1] , price - profit[i])

                 profit[i+1] = max (profit[i+1] , price - buy[i+1])
        
        return profit[k]