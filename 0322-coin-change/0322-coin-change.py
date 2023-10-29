class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        @functools.cache
        def recurse(self, amount : int):
            # lets handle base case when amount becomes zero
            if(amount == 0): return 0
            if (amount<0): return -1
            res = sys.maxsize
            for i in coins:
                #what if i include the coin
                include = recurse(self, amount-i)
                if include == -1 : continue
                res = min(res, include+1)
            if res == sys.maxsize : return -1
            return res

        if amount ==0 : return 0
        return recurse(self, amount)