class Solution {
    private int[] nums,multipliers;
    int find_max(int left,int mul,Integer[][] cache){
       if(mul==multipliers.length) return 0;
       if(cache[left][mul] != null) return cache[left][mul];
       int l = nums[left]*multipliers[mul]+find_max(left+1,mul+1,cache);
       int r = nums[(nums.length-1) - (mul-left)]*multipliers[mul]+find_max(left,mul+1,cache);
       cache[left][mul] = Math.max(l,r);
       return cache[left][mul];
    }
    public int maximumScore(int[] nums, int[] multipliers) {
       this.nums = nums;this.multipliers=multipliers;
       Integer[][] cache = new Integer[nums.length+1][multipliers.length+1];
       return  find_max(0,0,cache);
    }
}