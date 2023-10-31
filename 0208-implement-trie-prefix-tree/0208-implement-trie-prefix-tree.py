class TrieNode:
    def __init__(self):
      self.child = {}
      self.is_word = False

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        pointer = self.root

        for i in word:
            if i not in pointer.child: #if that char is not in here, we will keep it here
               pointer.child[i] = TrieNode()
            pointer = pointer.child[i]

        pointer.is_word = True


    def search(self, word: str) -> bool:
        pointer = self.root

        for i in word:
            if i not in pointer.child:
                return False
            pointer = pointer.child[i]
        return pointer.is_word

    def startsWith(self, prefix: str) -> bool:
        pointer = self.root

        for i in prefix:
            if i not in pointer.child:
                return False
            pointer = pointer.child[i]
        
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)