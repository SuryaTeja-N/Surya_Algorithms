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

        # # if you observe carefully, its similar to maximum subarray problem, and we can use kadane's algorithm
        
        mini = float('inf')
        max_profit = 0
        for price in prices:
            if (mini > price):
                mini = price
            elif (max_profit < price - mini): # if current price is reducing the profit, neglect it, if it is increasing, then update the profit.
                max_profit = price-mini
        return max_profit

      # as similar to other " best time to buy and sell stock problems", we can use finite state meachine approach

        # empty = 0 #curr_profit
        # onebuy = onesell = -inf

        # for price in prices:

        #     onebuy = max(empty - price, onebuy)
        #     onesell = max(onebuy + price, onesell)

        # return onesell
            