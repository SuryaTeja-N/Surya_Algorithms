class Solution {
    private String s1,s2;private Integer memo[][];
    private int recurse(int p1, int p2){
       if (p1 == s1.length() || p2 == s2.length()) return 0;
       //check if we already claculated this
       if(memo[p1][p2] != null) return memo[p1][p2];

       int choice1 = recurse(p1+1,p2); //exclude this value
       //so second choice shoul be to include that  value
       //if its there we need to look for its match in 2nd String
       int firstseeins2 = s2.indexOf(s1.charAt(p1), p2); //we gave p2 parameter {so, it will start searching from p2 in second string}
       int choice2 = 0;
       if (firstseeins2 > -1){
         choice2 = 1+ recurse(p1+1,firstseeins2+1);
       }

       //now compare and take best one
       memo[p1][p2] = Math.max(choice1, choice2);

       return memo[p1][p2];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new Integer[text1.length()+1][text2.length()+1];
        //for(Integer[] i : memo) Arrays.fill(i,-1);
        s1 = text1;s2 = text2;
        return recurse(0,0);
    }
}