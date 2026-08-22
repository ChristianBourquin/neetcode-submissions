class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        dfs(nums, 0, inner, outer);
        return outer;
    
    }

    public void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res){
        if(nums.length <= i){
            res.add(new ArrayList<>(subset));
            return;
        }
        
        //creating a child including nums[i]
        subset.add(nums[i]);
        dfs(nums, i + 1, subset, res);

        subset.remove(subset.size() - 1);

        //removing nums[i] to have child not include it
        dfs(nums, i + 1, subset, res);
        return;
    }
}
