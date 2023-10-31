#we can use trie data structure to furthur optimize the top-down approach

#lets build the trie data structure

class TrieNode:
    #each node will have child dictonary and variable to track whether it is end of word or not
   def __init__(self) -> None:
      self.child = {}
      self.is_word = False


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:

        # lets build the trie tree using wordDict
        root = TrieNode()

        for word in wordDict:
            pointer = root
            for char in word:
                if char not in pointer.child:
                    pointer.child[char] = TrieNode()  # push if not there in pointer child and creat a empty node for it
                pointer = pointer.child[char] # move the poiter to handle next char in word
            pointer.is_word = True

        def isword(self, word : str) -> bool :
            pointer = root
            for char in word:
                if char not in pointer.child:
                    return False  #stop, as there is not word
                pointer = pointer.child[char] # if its there, go to check the next char
            return pointer.is_word


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
                if (isword(self, s[index : index + len(word)]) and s[index : index + len(word)] == word) and recurse(index + len(word)) :
                    return True
            # if still len S is there & we have visited all noded in tree, them some chars are left in S,return False
            return False

        return recurse(0)


