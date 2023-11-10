class Solution:
    def numDecodings(self, s: str) -> int:
        
        # you can see that, here we can split the given string s into different ways, but the catch is that it should not be prefixed with "0" {since there will be no alphabet starting with that}.

        # so, to split them and tarck we can use counting dp here,
        @functools.cache
        def recurse(curr_idx) -> int:
            #lets handle the base cases
            if curr_idx == len(s): return 1
            if s[curr_idx] == '0' : return 0
            if curr_idx == len(s)-1 : return 1

            if int(s[curr_idx : curr_idx + 2]) <= 26 : 
                return recurse(curr_idx+1) + recurse(curr_idx+2)
            return recurse(curr_idx+1)

        return recurse(0)