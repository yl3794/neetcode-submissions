class Solution {
    public int characterReplacement(String s, int k) {
        int[] occurance = new int[26];
        int max = 0;
        int ans = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            max = Math.max(max, ++occurance[s.charAt(right) - 'A']);
            if (right - left + 1 - max > k) {
                occurance[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
