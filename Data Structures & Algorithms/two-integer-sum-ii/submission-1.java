class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Brute force: O(n^2)
        // Better: HashMap time O(n), space O(n)
        // int[] indices = new int[2];
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < numbers.length; i++) {
        //     int number = numbers[i];
        //     if (map.containsKey(target - number)) {
        //         indices[0] = map.get(target - number);
        //         indices[1] = i + 1;
        //         break;
        //     }
        //     map.put(number, i + 1);
        // }
        // return indices;

        // Optimal: two pointer, time O(n), additional space O(1)
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int smaller = numbers[left];
            int larger = numbers[right];
            if (smaller + larger < target) {
                left++;
            } else if (smaller + larger > target) {
                right--;
            } else {
                break;
            }
        }
        return new int[]{left + 1, right + 1};
    }
}
