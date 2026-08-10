class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<> ((a, b) -> b - a);

        for (int i : nums) {
            queue.offer(i);
        }

        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }

        return queue.poll();

    }
}
