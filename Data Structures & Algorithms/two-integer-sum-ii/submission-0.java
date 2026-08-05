class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Brute force: O(n^2)
        // Optimal: HashMap time O(n), space O(1)

        int[] indices = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (map.containsKey(target - number)) {
                indices[0] = map.get(target - number);
                indices[1] = i + 1;
                break;
            }
            map.put(number, i + 1);
        }
        return indices;
    }
}
