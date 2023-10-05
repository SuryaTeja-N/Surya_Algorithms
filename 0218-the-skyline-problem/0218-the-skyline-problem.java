class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        //previously we have used naive approvah, but now lets use sweep line algorithm

        //we maight have so many buildings with same positions, so lets remove duplicates and keep it sorted (to make them point to our indexs for easiness)
        Set<Integer> set = new TreeSet<>(); //as hashset wont sort values
        //fill the Set
        for(int[] building : buildings){
            set.add(building[0]); set.add(building[1]);
        }
        //but treeset is not good for accessing or traversing elements, so lets convert to List
        List<Integer> positions = new ArrayList<>(set);

        //so its time for using the sweep line algorithm
        //basically we will take a imaginary line and traverse through left to right buildings on x-axis {and find where the height is chnaging and track the maxheight}

        //lets do that traversal
        for(int pos : positions){ //at each position we need to update the answer
            int max_height=0;
            //move through buildings
            for(int[] building : buildings){
                int left = building[0],right = building[1];

                //if the current building, intersect with the line, the update the max_height
                if(left <= pos && right > pos){
                    max_height = Math.max(max_height, building[2]);
                }
            }
            // we need to prepare the answer right
           //we will add points {like (position,height) as asked in question} to answer only when the height is changed or if its the first entry
           if (ans.isEmpty() || max_height != ans.get(ans.size()-1).get(1)){
               ans.add(Arrays.asList(pos, max_height));
           }
        }
        return ans;
    }
    // worst case is: O(n^2), becauseno.of positions may be like 2n and no. of buildings are n. so in worst case its going to be O(2*n^2)
}