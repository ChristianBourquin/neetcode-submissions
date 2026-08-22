class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        dfs(nums, 0, 0, target, inner, outer);
        return outer;
    }

    public void dfs(int[] nums, int i, int total,int target, List<Integer> subset, List<List<Integer>> outer){
        if(target == total){
            outer.add(new ArrayList<>(subset));
            return;
        }else if(total > target || nums.length <= i){
            return;
        }

        //adding num
        subset.add(nums[i]);
        dfs(nums, i, total + nums[i], target, subset, outer);

        //skipping this one and checking the next num
        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, total, target, subset, outer);

    }
}
