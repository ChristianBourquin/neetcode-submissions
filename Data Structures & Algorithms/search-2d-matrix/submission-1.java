class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        int middle = start + (end - start)/2;
        while(start <= end){
            if(matrix[middle][0] == target){
                return true;
            }else if(matrix[middle][0] <= target && matrix[middle][matrix[middle].length - 1] >= target){
                start = 0;
                end = matrix[middle].length - 1;
                break;
            }else if(matrix[middle][0] > target){
                end = middle - 1;
            }else{
                start = middle + 1;
            }
            middle = start + (end - start)/2;
        }
        int index = middle;
        while(start <= end){
            middle = start + (end - start)/2;
            if(matrix[index][middle] == target){
                return true;
            }else if(matrix[index][middle] > target){
                end = middle - 1;
            }else{
                start = middle + 1;    
            }
        }
        return false;
    }
}
