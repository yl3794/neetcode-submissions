class Solution {
    public boolean hasDuplicate(int[] nums) {
        // brute force O(n^2)
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[j] == nums[i]) return true;
        //     }
        // }

        // return false;

        // optimized O(n)
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.contains(n)) {
                set.add(n);
            } else {
                return true;
            }
        }
        return false;
        
    }
}