class Solution {
    long include(int[][] questions,int question,long[] memo){
        if(question < 0 || question > questions.length-1) return 0;
        if(memo[question] != -1) return memo[question];
        memo[question] = Math.max( questions[question][0] + 
                                   include(questions,question+1+questions[question][1],memo),
                                   include(questions,question+1,memo));
        return memo[question];
    }
    public long mostPoints(int[][] questions) {
        long[] memo = new long[questions.length+1];
        Arrays.fill(memo,-1);
        return include(questions,0,memo);
    }
}