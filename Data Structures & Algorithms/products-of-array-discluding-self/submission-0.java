class Solution {
    public int[] productExceptSelf(int[] nums) {

        // Brute force O(n^2)
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    product = product * nums[j];
                }
            }
            output[i] = product;
        }
        return output;
    }
}  
