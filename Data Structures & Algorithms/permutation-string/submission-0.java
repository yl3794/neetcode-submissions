class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < n1; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        if (matches(freq1, freq2)) return true;

        for (int i = n1; i < n2; i++) {
            // incoming char
            freq2[s2.charAt(i) - 'a']++;
            // outgoing char
            freq2[s2.charAt(i - n1) - 'a']--;

            if (matches(freq1, freq2)) return true;
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
