class Solution:

    def maxProfit(self, prices: List[int]) -> int:

        # here " held " state represent both holding and buying states

        sold, buy_held, reset = -inf, -inf, 0

        for price in prices:

            buy_held = max(buy_held, reset - price)

            reset = max(reset, sold)
            
            sold = max(sold, buy_held + price)

        return sold
