class Solution:
    def findArray(self, pref: List[int]) -> List[int]:
        arr = [pref[0]]
        prev = pref[0]
        pref = pref[1:]
        for i in pref:
            arr.append(i ^ prev)
            prev = i
        return arr