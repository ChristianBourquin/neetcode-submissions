class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        int end = rows * cols - 1;
        int middle = start + (end - start) / 2;
        int midNum;
        while(start <= end){
            midNum = matrix[middle / cols][middle % cols];
            if(midNum < target){
                start = middle + 1;
            }else if(midNum > target){
                end = middle - 1;
            }else{
                return true;
            }
            middle = start + (end - start) / 2;
        }
        return false;
    }
}
