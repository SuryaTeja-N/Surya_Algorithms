class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();

        //first we need to get the points on x-axis without duplicates
        Set<Integer> points = new TreeSet<>(); //we need to use TreeSet instead of hashset, beacuse we need to get in sorted order.
        for (int[] point : buildings){
            points.add(point[0]); points.add(point[1]);
        }

        //so, by now we have a fixed indexes in x plain in points set, now we need to find maximum heights of occupied building at that specific index

        List<Integer> edges = new ArrayList<>(points); //this will convert that treeset to list (beacuse treeset do sorting but wont preserve the order)
        
        //so here edges values are real locations of buildings, so there there will so much difference in btw them, we need to map to indexs
        Map<Integer,Integer> indexmap = new HashMap<>();
        for(int i=0; i<edges.size(); ++i){
            indexmap.put(edges.get(i), i);
        }

        //ok, lets think about heights too at each index now
        int[] heights = new int[edges.size()];
        //to find maximum height at each index, lets iterate over all buildings
        for(int[] building : buildings){
            //for each building lets find the right and left index
            int leftidx = indexmap.get(building[0]);
            int rightidx = indexmap.get(building[1]);

            //we will update the maximum height within range of [left, right)  {here we will exclude rightidx beacuse two buildings, will not share same point right!!!}
            for(int i=leftidx; i<rightidx; ++i){
               heights[i] = Math.max(heights[i], building[2]);
            }
        }

        //as now we have got the max heights
        //lets try to form the answer
        for(int i=0; i<heights.length; ++i){
            int currheight = heights[i];
            int currpos = edges.get(i);

            //Add all the positions where the height changes to 'answer'.
            if(ans.isEmpty() || ans.get(ans.size()-1).get(1) != currheight){
                ans.add(Arrays.asList(currpos,currheight));
            }
        }
        return ans;
    }
}