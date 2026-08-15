class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle = low + (high - low) / 2;
        while(low <= high){
            if(nums[middle] > target){
                high = middle - 1;
            }else if(nums[middle] < target){
                low = middle + 1;
            }else{
                return middle;
            }
            middle = low + (high - low) / 2;
        }
        return -1;
    }
}
