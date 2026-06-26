class Solution {
    public int removeElement(int[] nums, int val) {
        int counter = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                nums[i] = 0;
            }else{
                nums[counter] = nums[i];
                counter++;
            }
        }
        return counter;
    }
}