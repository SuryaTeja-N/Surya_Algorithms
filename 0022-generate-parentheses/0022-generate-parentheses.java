class Solution {
    private boolean is_valid(String st){
        int left_count=0;
        for(char i : st.toCharArray()){
            if(i == '(') left_count++;
             else left_count--;
            if(left_count <0) return false; //careful... its important
        }
        return (left_count == 0);
    }
    public List<String> generateParenthesis(int n) {
       //this is brute force, kind of similar to BFS
        List<String> ans = new ArrayList<>();

        //we have use the queue to make the different strings
        Queue<String> que = new LinkedList<>(Arrays.asList("")); //with this, we will initialized all string in the queue with empty strings

        while(!que.isEmpty()){

            String curr = que.poll();

            //base case
            //if length of string beacame 2*n, we have got one answer
            if(curr.length() == 2*n){
                if(is_valid(curr)){ //we need to check if that ans is valid or not
                    ans.add(curr);
                }
                continue;
            }
            que.add(curr + "(") ;  que.add(curr + ")") ;
        }
        return ans;
    }
}