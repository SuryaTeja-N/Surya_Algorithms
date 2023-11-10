class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        
        # known to be solved with kadanes algorithm

        currseq = nums[0]; maxseq = nums[0]

        for i in range(1, len(nums)):
            currseq = max(currseq + nums[i] , nums[i])
            if currseq > maxseq : maxseq = currseq
        
        return maxseq