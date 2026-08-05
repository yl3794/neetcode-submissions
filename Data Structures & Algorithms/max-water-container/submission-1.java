class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        // Brute force: O(n^2)
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            int width = right - left;
            int area = Math.min(heights[left], heights[right]) * width;

            max = Math.max(area, max);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
