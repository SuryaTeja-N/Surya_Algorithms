class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        # this approach is called "finite state meachine" (applicable for all best time to buy and sell stock problems)

        curr_profit = 0  #empty state

        onebuy = onesell = twobuy = twosell = -inf

        for price in prices:

            onebuy = max (onebuy,  curr_profit - price)

            onesell = max (onesell, onebuy + price)

            twobuy = max (twobuy, onesell - price)

            twosell = max (twosell, twobuy + price)

        return twosell