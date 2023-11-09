class Solution:
    def countHomogenous(self, s: str) -> int:
        same = 0; ans=0
        for ind in range(len(s)):
            if ind == 0 or s[ind] == s[ind-1]:
                same+=1
            else:
                same=1
            ans += same 
        return ans % (10**9 + 7)
