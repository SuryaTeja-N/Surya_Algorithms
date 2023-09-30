class Solution {
    //constraints are less in number, so we can use backtracking
    private void backtrack(List<String> ans, StringBuilder curr, int left, int right,int n){
        //base case
        if(curr.length() == 2*n){
            ans.add(curr.toString()); return;
        }

        if(left < n ){
            curr.append("("); //test
            backtrack(ans,curr,left+1,right,n); //recurse
            curr.deleteCharAt(curr.length()-1); //back
        }

        if(left > right){
            curr.append(")");
            backtrack(ans,curr,left,right+1,n);
            curr.deleteCharAt(curr.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
       List<String> ans = new ArrayList<>();
       backtrack(ans, new StringBuilder(), 0, 0, n);
       return ans;
    }
}