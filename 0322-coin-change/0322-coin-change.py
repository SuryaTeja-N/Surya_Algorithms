class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        @functools.cache
        def recurse(amount : int):
            # lets handle base case when amount becomes zero
            if(amount == 0): return 0
            if (amount<0): return -1
            res = float('inf')
            for i in coins:
                #what if i include the coin
                include = recurse(amount-i)
                if include == -1 : continue
                res = min(res, include+1)
            if res == float('inf') : return -1
            return res

        return recurse(amount)