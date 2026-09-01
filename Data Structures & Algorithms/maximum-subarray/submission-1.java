class Solution {
    // public int maxSubArray(int[] nums) {
    //     int maxSub = nums[0];
    //     int curSum = 0;

    //     for (int n : nums) {
    //         if (curSum < 0) {
    //             curSum = 0;
    //         }
    //         curSum += n;
    //         maxSub = Math.max(maxSub, curSum); 
    //     }
    //     return maxSub;
    // }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        
        int[] startHere = new int[n];
        int[] bestFromHere = new int[n];

        startHere[n-1] = nums[n-1];
        bestFromHere[n-1] = nums[n-1];

        // bottom up
        for (int i = n - 2; i >= 0; i--) {
            startHere[i] = Math.max(
                nums[i],
                nums[i] + startHere[i+1]
            );

            bestFromHere[i] = Math.max(
                startHere[i],
                bestFromHere[i + 1]
            );
        }

        return bestFromHere[0];
    }
}
