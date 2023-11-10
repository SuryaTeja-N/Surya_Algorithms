class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        @functools.cache
        def recurse(amount, curr_index):
            #base cases
            # remember in counting dps, we wont return 0
            if amount == 0 : return 1
            
            #if we reached end of coins, we have to stop
            if curr_index == len(coins): return 0

            if amount >= coins[curr_index] :
              return recurse(amount - coins[curr_index] , curr_index) + recurse(amount, curr_index + 1)
            else :
               return recurse(amount, curr_index + 1)

        return recurse(amount , 0)



