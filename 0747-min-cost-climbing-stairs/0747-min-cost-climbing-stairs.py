class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        
        @functools.cache
        def recurse(step) -> int:
            if step >= len(cost) : return 0
            left =  recurse(step+1)
            right =  recurse(step+2)
            return cost[step] + min(left,right)

        return min(recurse(0), recurse(1))