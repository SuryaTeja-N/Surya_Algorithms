class Solution:
    def eliminateMaximum(self, dist: List[int], speed: List[int]) -> int:
        leni = len(dist); monster_heap = []

        for i in range(leni):
            monster_heap.append(dist[i] / speed[i])

        heapq.heapify(monster_heap)
        
        kill=0

        while monster_heap:
            if heapq.heappop(monster_heap) <= kill: break
            kill += 1
        
        return kill

