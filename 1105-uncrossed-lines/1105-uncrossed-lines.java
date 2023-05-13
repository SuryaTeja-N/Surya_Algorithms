class Solution {
    int compare(int ar1[],int ar2[],int num1,int num2,int[][] memo){
        if(num1<=0 || num2<=0) return 0;
        if(memo[num1][num2] != -1) return memo[num1][num2];
        if(ar1[num1-1] == ar2[num2-1]) memo[num1][num2] =  1+ compare(ar1,ar2,num1-1,num2-1,memo);
         else memo[num1][num2] =  Math.max(compare(ar1,ar2,num1,num2-1,memo) , compare(ar1,ar2,num1-1,num2,memo));
        return memo[num1][num2];
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int memo[][] = new int[nums1.length+1][nums2.length+1];
        for(int[] i: memo) Arrays.fill(i,-1); 
        return compare(nums1,nums2,nums1.length,nums2.length,memo);
    }
}