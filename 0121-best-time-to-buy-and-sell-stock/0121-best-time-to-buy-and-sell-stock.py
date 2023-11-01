class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        '''
        # brute-force -> O(n^2)
        max_res =0
        for i in range(len(prices)-1):
            for j in range(i+1, len(prices)):
               if(prices[i] < prices[j]):
                   max_res = max(max_res, prices[j]-prices[i])
        return max_res

        '''

        # if you observe carefully, its similar to maximum subarray problem, and we can use kadane's algorithm
        
        sol = prices[0]
        mini = float('inf')
        maxi = float('-inf')
        for i in range(len(prices)):
            if (mini > prices[i]):
                mini = prices[i]
            if (maxi < prices[i]-mini):
                maxi = prices[i]-mini
        return maxi


            