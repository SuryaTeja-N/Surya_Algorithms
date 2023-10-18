class Solution {
    char[][] matrix; int memo[][];

    public int maximalSquare(char[][] matrix) {

        //in naive approach, we need to consider each element in matrix (row * colms) and for each element we need to check all other elements if they are 0s or 1s {for making sqaure} {so all these elements also rows*colms} -> so overall, its going to be O((rows*colums) * (rows*colums))
        //so naive is worst, lets check if we can divide this as sub-problems. {so we can apply dp}

        int rows= matrix.length;
        int cols = matrix[0].length;
        int maxres=0;
        this.memo = new int[rows+1][cols+1];
        this.matrix = matrix;

        for(int[] i : memo) Arrays.fill(i,-1);

        for(int i=0; i<rows; ++i){
            for(int j=0; j<cols; ++j){
               maxres = Math.max(maxres, recurse(i,j));
            }
        }
        return maxres*maxres; //as we are finding area.
    }

    private int recurse(int row, int col){
        //base case
        if(row<0 || col<0 || matrix[row][col] == '0') return 0;
        if(memo[row][col] != -1) return memo[row][col];
        memo[row][col] = 1 + Math.min( recurse(row-1,col-1), Math.min( recurse(row-1,col), recurse(row,col-1)));
        return memo[row][col];
    }
}