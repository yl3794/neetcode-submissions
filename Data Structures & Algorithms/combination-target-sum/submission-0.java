class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        dfs(res, nums, target, currentList, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int target, List<Integer> currentList, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(currentList));
            return;
        }

        if (target < 0 || i >= nums.length) {
            return;
        }

        currentList.add(nums[i]);
        dfs(res, nums, target - nums[i], currentList, i);
        currentList.remove(currentList.size() - 1);

        dfs(res, nums, target, currentList, i + 1);
    }
}
