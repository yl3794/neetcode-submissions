class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> numSet = new HashSet<>();

        for (int n : nums) {
            numSet.add(n);
        }
        
        int longest = 1;
        for (int n : numSet) {
            if (numSet.contains(n - 1)) continue;
            else {
                int currentNum = n;
                int currentSub = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentSub++;
                }
                longest = Math.max(longest, currentSub);
            }
        }
        return longest;
    }
}

