class Solution {
    private int low,high,zero,one;int mod = 1000000007;
    int counting(int length,int[] memo){
        int count=0;
        if(length>high) return 0;
        if(memo[length] != -1) return memo[length];
        if(length>=low) count=1;
          count += counting(length+zero,memo) + counting(length+one,memo);
        memo[length] = count%mod;
        return memo[length];
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        this.low=low;this.high=high;this.zero=zero;this.one=one;
        int[] memo = new int[high+1]; Arrays.fill(memo,-1);
        return counting(0,memo);
    }
}