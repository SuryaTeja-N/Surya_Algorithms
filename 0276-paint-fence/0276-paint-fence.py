class Solution:
    def numWays(self, n: int, k: int) -> int:
        @functools.cache
        def recurse(n) -> int :
            #base cases
            if n==1 : return k
            if n==2 : return k * k
    
            return (k - 1) * recurse(n - 1) + (k - 1) * recurse(n - 2)

        return recurse(n)
