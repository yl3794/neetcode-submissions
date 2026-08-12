class Solution {
    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int skip = dfs(nums, i + 1);
        int rob = nums[i] + dfs(nums, i + 2);
        memo[i] = Math.max(skip, rob);

        return memo[i];
    }
}
