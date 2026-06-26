class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_consec = 0;
        int counter = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                counter += 1;
            }
            else{
                
                counter = 0;
            }
            if(counter > max_consec){
                    max_consec = counter;
            }
        }
        return max_consec;
    }
}