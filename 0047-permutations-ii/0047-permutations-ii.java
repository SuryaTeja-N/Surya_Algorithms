class Solution {
    boolean visited[];
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); visited = new boolean[nums.length];
        //it is eveident that we can use backtracking (constarints are less numbered)
        Arrays.sort(nums);
        backtracking(ans, nums, new ArrayList<>());
        return ans;
    }
    private void backtracking(List<List<Integer>> ans, int[] nums, List<Integer> curr){
        //base case
        if(curr.size() == nums.length){
           // ans.add(curr);// no... its shallow copy
           ans.add(new ArrayList<>(curr)); //its fine, its deep copy
           return;
        }

        //lets start the loop
        for(int i=0; i<nums.length; ++i){ //see we need index for visited array
            if(!visited[i] && (i==0 || (nums[i-1] != nums[i]) || visited[i-1])){ //if we still not visited the number
               curr.add(nums[i]); //push
               //now we are using number, so update visited array
               visited[i] = true;
               backtracking(ans, nums, curr); //recurse and use
               curr.remove(curr.size()-1); //now remove
               //as we removed the number, we need to update the visited array
               visited[i] = false;
            }
        }
    }
}