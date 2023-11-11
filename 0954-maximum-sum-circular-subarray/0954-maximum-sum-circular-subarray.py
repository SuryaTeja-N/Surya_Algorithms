class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        
        # most efficient approach is to find max of  normal maxsum and whole sum - normal minsum

        # we can apply same kadanes algorithm

        max_profit = -inf; max_curr=0 ; min_profit = inf; min_curr = 0 ; whole_sum=0

        for num in nums:
           
            whole_sum += num

            max_curr = max(max_curr + num , num)

            max_profit = max(max_profit , max_curr)

            min_curr = min(min_curr + num , num)

            min_profit = min(min_profit , min_curr)
        
        if max_profit < 0: return max_profit

        return max( max_profit , whole_sum - min_profit)
