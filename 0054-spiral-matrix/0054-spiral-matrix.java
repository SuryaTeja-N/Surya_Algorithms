class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left =0,right=columns-1,up=0,down=rows-1;

        while(res.size() < rows*columns){
           
           for(int col=left;col<=right;col++){
               res.add(matrix[up][col]);
           }

           for(int row=up+1;row<=down;row++){
               res.add(matrix[row][right]);
           }
           if(up!=down){
            for(int col=right-1;col>=left;col--){
                res.add(matrix[down][col]);
            }
           }
 
           if(left!=right){
              for(int row=down-1;row>up;row--){
                res.add(matrix[row][left]);
            }
           }

           left++;right--;up++;down--;
        }
        
        return res;
    }
}