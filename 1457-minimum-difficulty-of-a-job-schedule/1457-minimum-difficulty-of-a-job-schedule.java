class Solution {
    private int[] jobDifficulty;
    private int min_diff(int working_index, int remaining_days, int[][] memo){

        if(memo[working_index][remaining_days] != -1) return memo[working_index][remaining_days];

       //lets deal with base case (when it was only last day, we have push all the tasks)
       if(remaining_days == 1){
           int res_of_day =0;
           for(int i=working_index; i<jobDifficulty.length; ++i){
              res_of_day = Math.max(res_of_day, jobDifficulty[i]); 
           }
           return res_of_day;
       }
    
       int final_res = Integer.MAX_VALUE; int daily_res=0;
       for(int i = working_index; i<= jobDifficulty.length - remaining_days; ++i){
           daily_res = Math.max(daily_res, jobDifficulty[i]);
           final_res = Math.min(final_res, daily_res + min_diff(i+1, remaining_days-1, memo));
       }
       
       memo[working_index][remaining_days] = final_res;
       return memo[working_index][remaining_days];
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        //here it is evident that we have to use dp, as we are finding min value and also each day max val is dependent on other days and also impacting the final min value.
        //lets do with top-down
        this.jobDifficulty = jobDifficulty;
        //base case (for every day we need to do the task)
        if(jobDifficulty.length < d) return -1;
        int[][] memo = new int[jobDifficulty.length+1][d+1]; for(int[] i: memo) Arrays.fill(i,-1);
        return min_diff(0, d, memo);
    }
}