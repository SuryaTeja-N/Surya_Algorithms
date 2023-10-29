class Solution:
    def poorPigs(self, buckets: int, minutesToDie: int, minutesToTest: int) -> int:
        if buckets == 1:
            return 0
        base = minutesToTest // minutesToDie + 1
        attempts = 0
        while base ** attempts < buckets:
            attempts += 1
        return attempts
