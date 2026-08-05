class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null) return 0;
        if (s.length() == 1) return 1;

        Set<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while(set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            max = Math.max(max, right - left + 1);
        }

        return max;

    }
}
