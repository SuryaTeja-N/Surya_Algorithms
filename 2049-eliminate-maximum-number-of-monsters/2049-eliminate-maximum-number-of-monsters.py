class Solution:
    def eliminateMaximum(self, dist: List[int], speed: List[int]) -> int:
        leni = len(dist); monster = []

        for i in range(leni):
            monster.append(dist[i] / speed[i])

        monster.sort()
        
        kill=0

        for i in range(len(monster)):
            if monster[i] <= i:
                break
            kill +=1
        
        return kill

