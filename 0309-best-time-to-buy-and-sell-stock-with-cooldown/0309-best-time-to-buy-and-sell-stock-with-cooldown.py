class Solution:

    def maxProfit(self, prices: List[int]) -> int:

        # here " held " state represent both holding and buying states

        sold, buy, reset = -inf, -inf, 0

        for price in prices:

            # buy = max(buy, reset - price) # what will be there before buy? , its reset -> so buy from it

            # reset = max(reset, sold)  # what will be there before reset, its sold -> so compare with it
            
            # sold = max(sold, buy + price) # what will be there before sold? , its buy , so add price to it

            #buy,sold,reset = max(buy, reset - price) , max(reset, sold) , max(sold, buy + price)

            reset , buy , sold = max(reset, sold) , max(buy, reset - price) , max(sold, buy + price)

        return max(sold , reset, buy)
