class Solution:
    def maximumScore(self, nums: List[int], multipliers: List[int]) -> int:
        
        # lets solve this with top-down dp

        # to perform any operation on nums, we need to consider both cases, whether if we consider left side number in nums or right side num in nums, we will pick optimal choice
        @functools.cache
        def recurse(left_side , nof_operation) -> int:
            
            #base case: (if we reach maximum number of operations)
            if (nof_operation == len(multipliers)) :
                return 0

            left_side_pick = nums[left_side] * multipliers[nof_operation] + recurse(left_side+1, nof_operation+1)

            # see here, we dont have any pointer to track on right side count, but we can find that by seeing that number of operations and number of left side operations. (if we subtract no. of operations performed so far - no. of operations performed on left side, we will get operations performed on right side), so if we subtract with last index with that, we will get the right index to work now.

            right_side_pick = nums[(len(nums)-1 - (nof_operation - left_side))] * multipliers[nof_operation] + recurse(left_side, nof_operation+1)

            return max(left_side_pick , right_side_pick)

        return recurse(0,0)
         


