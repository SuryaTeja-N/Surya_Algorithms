class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:

        # here, we can see that, each selection of chars from string will impact the search of next things, so we can solve it using dynamic programming.

        # lets deal this with top-down

        # each time i need to check dp[i], i.e, the substring upto i th index is there in wordDict or not. if there, we will increment till we find the exact word in wordDict
       
        @functools.cache
        def recurse(index : int) -> bool:
            # base case
            if index >= len(s):
                return True
            
            # making decision tree as mentioned in (https://youtu.be/Sx9NNgInc3A?si=y2GvHPFfFXCWWZkl)
            for word in wordDict:
                if (s[index : index + len(word)] == word) and recurse(index + len(word)) :
                    return True
            # if still s is there & we have visited all noded in tree, them some chars are left in S,return False
            return False

        return recurse(0)


