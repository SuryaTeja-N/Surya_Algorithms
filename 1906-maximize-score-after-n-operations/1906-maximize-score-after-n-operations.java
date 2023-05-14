class Solution {
    int gcd(int x,int y){
       if(y==0) return x;
       return gcd(y,x%y);
    }
    public int maxScore(int[] nums) {
        int maxStates = 1 << nums.length,finalMask = maxStates - 1;
        int[] dp = new int[maxStates];
        for (int state = finalMask; state >= 0; state--) {
            if (state == finalMask) {
                dp[state] = 0; continue;
            }
            int numbersTaken = Integer.bitCount(state),pairsFormed = numbersTaken / 2;
            if (numbersTaken % 2 != 0) continue;
            for (int firstIndex = 0; firstIndex < nums.length; firstIndex++) {
                for (int secondIndex = firstIndex + 1; secondIndex < nums.length; secondIndex++) {
                    if (((state >> firstIndex) & 1) == 1 || ((state >> secondIndex) & 1) == 1) continue;
                    int currentScore = (pairsFormed + 1) * gcd(nums[firstIndex], nums[secondIndex]);
                    int stateAfterPickingCurrPair = state | (1 << firstIndex) | (1 << secondIndex);
                    int remainingScore = dp[stateAfterPickingCurrPair];
                    dp[state] = Math.max(dp[state], currentScore + remainingScore);
                }
            }
        }
        return dp[0];
    }
}