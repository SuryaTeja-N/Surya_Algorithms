class Solution:

    def maxProfit(self, prices: List[int]) -> int:

        # here " held " state represent both holding and buying states

        sold, buy_held, reset = -inf, -inf, 0

        for price in prices:
            buy_held = max(buy_held, reset - price)
            pre_sold = sold
            sold = buy_held + price
            
            reset = max(reset, pre_sold)

        return max(sold, reset)
