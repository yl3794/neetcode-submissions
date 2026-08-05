class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        // HashMap
        // char[] sChars = s.toCharArray();
        // char[] tChars = t.toCharArray();

        // HashMap<Character, Integer> sMap = new HashMap<>();
        // for (char c : sChars) {
        //     sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        // }

        // HashMap<Character, Integer> tMap = new HashMap<>();
        // for (char c : tChars) {
        //     tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        // }

        // for (char c : tChars) {
        //     if (!java.util.Objects.equals(sMap.get(c), tMap.get(c))) {
        //         return false;
        //     }
        // }
        // return true;

        // Array O(n)
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        } 

        for (int i : arr) {
            if (i != 0) return false;
        }
        return true;


    }
}
