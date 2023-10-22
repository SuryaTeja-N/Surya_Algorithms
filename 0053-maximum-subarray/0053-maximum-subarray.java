class Solution {
    public int maxSubArray(int[] nums) {

        //it is quite popular problem to be solved using kadane's algorithm

        // idea is the we will taverse through the array while constructing the subsequence, if previous subseq is lowering the ele, we will just ignore that previous subseq.
        int currseq = nums[0], maxseq = nums[0];
        for(int i=1; i<nums.length; ++i){
           currseq = Math.max(currseq+ nums[i], nums[i]);
           //so, if currseq is less than maxseq, dont change it
           maxseq = Math.max(maxseq, currseq);
        }
        return maxseq;
    }
}