class Solution:
    # O(n) Solution

    def eliminateMaximum(self, dist: List[int], speed: List[int]) -> int:
        n=len(dist)
        monsters_t=[0]*(n+1)

        for i in range(n):
            t = math.ceil(dist[i] / speed[i])
            if t>n:   # due to this, the t value is always going to be <= n
                t=n
            monsters_t[t]+=1  # this list will helpful to tell at which time, how many monsters are coming
        
        shot=1
        monsters=0
        while shot<=n:  # beacause we have n chances (n shots) to kill all n monsters
            monsters+=monsters_t[shot-1]
            if shot<=monsters: 
                break
            shot+=1
        shot-=1
        return shot
        

# Explanation : 

'''
1) why checking t>n ?

sol : see.. for every minute, despite of distace of monster, we can kill it, so, if there are 5 monsters, if we have 5 minutes of time, we can kill all of them (each one at each minute).

so, in short if time is greater than "n" minutes, there is no need to check, all monsters are going to be dead. so t=n

'''