class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int i_number = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int smaller = nums[left];
                int bigger = nums[right];
                if (i_number + smaller + bigger < 0) {
                    left++;
                } else if (i_number + smaller + bigger > 0) {
                    right--;
                } else {
                    res.add(Arrays.asList(i_number, smaller, bigger));
                    // skip duplicates for left
                    while (left < right && nums[left] == nums[left + 1]) left++;

                    // skip duplicates for right
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
