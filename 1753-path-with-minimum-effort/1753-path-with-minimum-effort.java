class Solution {
    //as we need to find distance between single source to destination in weighted graph {here edges weight is difference in heights}, we can use dijikstra here

    //as usual, we need to look for negihbour cells, lets take directions
    int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public int minimumEffortPath(int[][] heights) {
        //now start dijikstra
        //first we need make edges weights as infinity,{edges means weight diff btw cells from source}
        int[][] height_differences = new int[heights.length][heights[0].length];//to use as weighted edges
        for(int[] row : height_differences){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        height_differences[0][0]= 0; //as difference for source itself is zero
        //as usaual, we need to use pq for dijikstra as minheap
        //remember, when a node has so many attributes, take it as seaperate 
        PriorityQueue<cell> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        pq.add(new cell(0,0,height_differences[0][0])); //add source
        //start the loop
        while(!pq.isEmpty()){
            //remove the first
            cell curr = pq.poll();
            //mark as visited
            visited[curr.row][curr.col] = true;
            //next we need to send current cell negihbour to pq but before that we need to check some edge cases to handle
            if(curr.row == heights.length-1 && curr.col == heights[0].length-1){
                return curr.dist;//when we reach destination,return ans
            }
            //now lets go through current cell negihbours
            for(int[] direction : directions){
               int negihbour_row = curr.row + direction[0];
               int negihbour_col = curr.col + direction[1];
               //now we need to find wheter negihbour cell is valid or not
               if(is_valid(negihbour_row,negihbour_col,heights) && !visited[negihbour_row][negihbour_col]){
                  //now remember, as we are using PriorityQueue, we first need to send the high distanced adjecent cell first into the queue, so that minimum distanced cell will be there at top of the pq.
                  int curr_difference = Math.abs(heights[negihbour_row][negihbour_col] - heights[curr.row][curr.col]);
                  int maxdifference = Math.max(curr_difference,height_differences[curr.row][curr.col]); //checking wheter dist. to other cell is high or curr cell distance itself is high
                 //perform the relaxation
                  if(height_differences[negihbour_row][negihbour_col] > maxdifference){
                      height_differences[negihbour_row][negihbour_col] = maxdifference;
                      //add this high distant negihbour to queue first so that we can deal with this so late
                      pq.add(new cell(negihbour_row,negihbour_col,maxdifference));
                  }

               }
            }
        }
        return height_differences[heights.length-1][heights[0].length-1];
    }
    boolean is_valid(int row,int col,int[][] heights){
       return row>=0 && col>=0 && row<heights.length && col<heights[0].length;
    }
}

// lets take cell class,as we have 3 attributes (row,col and dist from source)
class cell{
    int row,col,dist;
    cell(int row,int col,int dist){
        this.row=row;this.col=col;this.dist=dist;
    }
}