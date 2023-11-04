class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        # we can solve with finite state meachine approach

        profit = 0 # here we dont have any empty state similar to best time to buy and sell stock 3 (As we are always having unlimited transactions, there will be no instance for completed transactions, contiuesly we will taking transactions) 

        # and also you can see here we are not considering the sell point, because from buy point (very less price) to we contiuesly checking the high sell point to get great profit, so final sell point itself has the big profit

        buyone = -inf

        for price in prices:
            
            buyone = max (buyone , profit-price)

            profit = max(profit , buyone+price)

        return profit
