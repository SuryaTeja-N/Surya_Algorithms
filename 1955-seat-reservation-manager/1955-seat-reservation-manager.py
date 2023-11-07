from sortedcontainers import SortedSet

class SeatManager:

    def __init__(self, n: int):
        self.starter = 1
        #self.seats = SortedSet()
        self.seats = []


    def reserve(self) -> int:
        if self.seats:  # if unreserved seats are there left to the starter
           #return self.seats.pop(0)
           return heapq.heappop(self.seats)

        res = self.starter
        self.starter += 1
        return res

    def unreserve(self, seatNumber: int) -> None:
        #self.seats.add(seatNumber)
        heapq.heappush(self.seats, seatNumber)
       


# Your SeatManager object will be instantiated and called as such:
# obj = SeatManager(n)
# param_1 = obj.reserve()
# obj.unreserve(seatNumber)