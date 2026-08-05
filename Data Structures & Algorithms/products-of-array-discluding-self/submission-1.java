class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        // Brute force O(n^2)
        // for (int i = 0; i < nums.length; i++){
        //     int product = 1;
        //     for (int j = 0; j < nums.length; j++) {
        //         if (i != j) {
        //             product = product * nums[j];
        //         }
        //     }
        //     output[i] = product;
        // }
        // return output;

        // Optimal: O(n) without division operation
        int prefix = 1;
        int postfix = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                prefix = prefix * nums[i - 1];
            }
            output[i] = prefix;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i != nums.length - 1) {
                postfix = postfix * nums[i + 1];
            }
            output[i] = output[i] * postfix;
        }

        return output;
    }
}  
