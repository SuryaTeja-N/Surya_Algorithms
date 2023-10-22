class Solution {
  // this is naive recursion + caching approach, see editorail for efficient DP approach
    int length_from(int[] nums,int pos,int[] cache){
      if(pos >= nums.length) return 0;
      if(pos == nums.length-1){cache[pos]=1;return 1;}
      if(cache[pos] == -1){
        int max=0;
        for(int i=pos+1;i<=nums.length-1;i++){
          if (nums[pos]<nums[i]){
            if (max < length_from(nums,i,cache)) max= length_from(nums,i,cache);
          }
        }
        cache[pos] = 1+max; 
      }
      return cache[pos];
    }
    public int lengthOfLIS(int[] nums) {
        // if(nums.length == 1) return 1;int max = Integer.MIN_VALUE;
        // int[] cache = new int[nums.length]; Arrays.fill(cache,-1);
        // for(int i=nums.length-1;i>=0;i--){
        //   if (max < length_from(nums,i,cache)) max = length_from(nums,i,cache);
        // }
        // return max;

        // here you can see the iterative nature of the problem, it is easy to solve with bottom up dp approach
        // int dp[] = new int[nums.length];Arrays.fill(dp,1);
        // for(int i=1; i<nums.length; ++i){
        //   for(int j=0; j<i; ++j){
        //     if(nums[j] < nums[i])
        //       dp[i] = Math.max(dp[i],dp[j]+1);
        //   }
        // }
        // int ans= Integer.MIN_VALUE;
        // for(int i: dp) ans = Math.max(ans,i);
        // return ans;

         // there is another way to do this, by continusly building the sequence (time : O(n*logn))
    ArrayList<Integer> seq = new ArrayList<>();
    seq.add(nums[0]); //lets start by including first number
    for(int i=1; i<nums.length; ++i){
      int num = nums[i];
      if(num > seq.get(seq.size()-1)) { // check last number in seq, if its lower than num, include in seq
          seq.add(num);
      }else{
         //if that num is less than last num is seq, there is a chance that this can be used to build even bigger sequence, so we need to include in sequence but in correct position without disturbing order of previous seq (so we will us binary search to find suitable position)
         int pos = Collections.binarySearch(seq, num);
         if(pos < 0) pos = -(pos)-1;
         seq.set(pos, num);
      }
    }
    return seq.size();
    }
}