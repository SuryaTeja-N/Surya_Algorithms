from sortedcontainers import SortedSet

class SeatManager:

    def __init__(self, n: int):
        self.seats = SortedSet(range(1,n+1))


    def reserve(self) -> int:
        #seat_number = heapq.heappop(self.seats) # takeout that unreserved seat
        #return seat_number
        seat_number = self.seats.pop(0)
        return seat_number

    def unreserve(self, seatNumber: int) -> None:
        #heapq.heappush(self.seats, seatNumber)
        self.seats.add(seatNumber)


# Your SeatManager object will be instantiated and called as such:
# obj = SeatManager(n)
# param_1 = obj.reserve()
# obj.unreserve(seatNumber)