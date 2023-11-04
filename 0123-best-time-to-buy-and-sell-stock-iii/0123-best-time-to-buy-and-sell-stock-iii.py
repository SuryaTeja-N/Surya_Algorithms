class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        # this approach is called "finite state meachine"
        empty = 0

        onebuy = onesell = twobuy = twosell = -inf

        for price in prices:

            onebuy , onesell , twobuy , twosell = max( empty - price , onebuy) , max (onebuy + price , onesell) , max(onesell - price, twobuy) , max(twobuy + price , twosell)

        return max( empty , onebuy , onesell , twobuy, twosell)