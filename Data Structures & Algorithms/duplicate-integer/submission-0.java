class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> tracker = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!tracker.containsKey(nums[i])){
                tracker.put(nums[i], 1);
            }else{
                return true;
            }
        }
        return false;
    }
}