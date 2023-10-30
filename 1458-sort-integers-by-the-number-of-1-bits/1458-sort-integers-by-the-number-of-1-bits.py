class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:
        # for key, we habe to pass both bit_count and the number itself beacuse if bitcount is equal, we need to sort according the num value only, and if we pass tuple to key paramneter in sort function, it will first check 1st element of tuple and 2nd element if previous ones are same
        res = sorted(arr , key = lambda n : (n.bit_count(), n))
        return res