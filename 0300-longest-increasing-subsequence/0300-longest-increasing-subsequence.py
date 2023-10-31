class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # first lest try with naive recursion + memo approach
        
        @functools.cache
        def recurse(index : int) -> int : 

          # base case is 
          if (index < 0):
            return 0

          count = 1
        
          for i in range(index):
            if nums[index] > nums[i] :
              count = max(count, recurse(i)+1)

          return count

        
        ans =0
        
        for i in range(len(nums)):
          ans = max(ans, recurse(i))

        return ans
          
        

        
