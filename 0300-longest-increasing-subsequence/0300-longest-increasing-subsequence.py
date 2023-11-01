import bisect

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:

        # first lets try with naive recursion + memo approach

        '''
        
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
          
        '''
        # lets try with bottom up dp (it is easy to do, beacuse of recursive nature of problem) see : https://www.youtube.com/watch?v=cjWnW0hdF1Y

        '''

        #as usaual first we need to take the dp List
        dp = [1] * len(nums)  # since, every number is itself counted as 1

        for i in range(len(nums)-1, -1, -1):   # we starting from last number in given array

          for j in range(i+1, len(nums)):

            if nums[i] < nums[j]:
                
              dp[i] = max( dp[i] , 1 + dp[j])

        return max(dp)

        '''

        # lets deal with follow up question to solve this in O(n* logn) as above methods runtime is O(n^2)

        # trick is that, we just travel through the list, for example, list is [8, 1, 6, 2, 3, 10]. first we will take, after that 1 is there, so replace 8 with 1, next 6 is there which is >1, so keep it [1,6], next 2 is there which is less that 6, {which might be useful to construct bigger sequence}, so replace with 6. But we need to think about where actually we need to place this new low element in out result list. {answer is, using binary search to find perfect position n our newly forming list, as this list is alreay sorted in ascending order}

        ans = [nums[0]]
        nums1 = nums[1:]
        #lets travel through given list
        for num in nums1:
          if num > ans[len(ans)-1]:  #if num is big, lets keep at end of ans
            ans.append(num)
          else:
            pos = bisect.bisect_left(ans, num)  #if num is small, its has potential, so put in good position
            ans[pos] = num
          
        
        return len(ans)


              

        

        
