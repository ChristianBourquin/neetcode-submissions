class Solution {
    public void sortColors(int[] nums) {
        int[] count = {0, 0, 0};

        for(int i = 0; i < nums.length; i++){
            count[nums[i]]++;
        }

        int n = 0;
        for(int i = 0; i < count.length; i++){
            for(int j = 0; j < count[i]; j++){
                nums[n] = i;
                n++;
            }
        }
    }
}