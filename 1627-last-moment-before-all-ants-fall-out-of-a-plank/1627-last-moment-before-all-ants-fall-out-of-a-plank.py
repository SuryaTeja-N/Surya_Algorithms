class Solution:
    def getLastMoment(self, n: int, left: List[int], right: List[int]) -> int:
        
        # you can clearly see that collisions wont effect the time taking for ants to fall out, {only changing directions, thats it!!!}
        time = 0
        
        for i in left:

            time = max(time, i)

        for i in right:

            time = max(time, n-i)

        return time


