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

        /*The code uses a deque (double-ended queue) data structure to store the indices of the bars that are in ascending order of height. The deque is implemented using a linked list, which allows adding and removing elements from both ends in constant time.

The code starts by pushing -1 onto the deque, which serves as a sentinel value to mark the end of the deque. Then, it iterates over the heights array from left to right, and performs the following steps for each bar:

While the top element of the deque is not -1 and the height of the bar at that index is greater than or equal to the height of the current bar, pop the top element from the deque. This means that the bar at that index has a right boundary at the current index and a left boundary at the next element on the deque. The area of the rectangle formed by this bar is then calculated by multiplying its height with its width, which is given by (i - stack.peek() + 1) - 2. The +1 is to include both boundaries, and the -2 is to exclude them. The area is then compared with the maximum area found so far and updated if necessary.
Push the current index onto the deque, since it is smaller than or equal to the previous bar on the deque.

After iterating over all the bars, there may be some remaining indices on the deque that have not been popped yet. These are the bars that have no smaller bar on their right. To find their areas, we pop them one by one from the deque and calculate their areas using a similar formula as before, but with a different right boundary. The right boundary is now given by len, which is the length of the heights array. The area is then given by (len - stack.peek() + 1) - 2. The area is then compared with the maximum area found so far and updated if necessary.

The code returns the maximum area at the end.*/
    }
}