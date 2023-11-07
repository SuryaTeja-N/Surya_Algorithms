# O(n) time & space
class Solution:
    def eliminateMaximum(self, dist: List[int], speed: List[int]) -> int:
        # get time to deadlines dict
        n = len(dist)
        deadlines = [min(ceil(d / s), n) for d, s in zip(dist, speed)]
        time_to_deadlines = Counter(deadlines)

        # at each timestep, monsters > t means you lose
        cnt = 0
        for t in range(1, n + 1):
            monsters = time_to_deadlines.get(t, 0)
            if cnt + monsters <= t: cnt += monsters
            else: return t
        return cnt