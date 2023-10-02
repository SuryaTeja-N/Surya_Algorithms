class Solution {
    public int largestRectangleArea(int[] heights) {
        int area = 0, len = heights.length;
        // for(int i=0; i<len; ++i){
        //     for(int j=i; j<len; ++j){
        //         //we need to track mininum height (to break the comsideration)
        //         int minheight = Integer.MAX_VALUE;
        //         for(int k=i; k<=j; ++k){
        //             minheight = Math.min(minheight, heights[k]);
        //         }
        //         area = Math.max(area, minheight * (j-i+1));
        //     }
        // }

        //above method will take O(n^3), for each pair, we are looking for minheight.but we can use previous value (beacuse for each ith iteration, minheight is going to be same)

        // for(int i=0; i<len; ++i){
        //     int minheight = Integer.MAX_VALUE;
        //     for(int j=i; j<len; ++j){
        //         minheight = Math.min(minheight, heights[j]);
        //         area = Math.max(area, minheight * (j-i+1));
        //     }
        // }

        //but above is also O(n^2), which is also too time consuming


        //lets use stack method
        //remember stack class in java extends vector (which is outdated), lets use Deque
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1); //we put this as the end of queue
        for(int i=0; i<len; ++i){ //push values but only when its in increasing order
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                int currheight = heights[stack.pop()];
                int currwidth = (i - stack.peek() +1)-2; //we are looking for width
                area = Math.max(area, currheight*currwidth);
            }
            stack.push(i);
        }
        while(stack.peek() != -1){
            int currheight = heights[stack.pop()];
            int currwidth = (len - stack.peek() +1)-2;
            area = Math.max(area, currheight*currwidth);
        }
        return area;
    }
}