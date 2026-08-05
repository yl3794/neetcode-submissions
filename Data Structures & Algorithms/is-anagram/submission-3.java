class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
      
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        HashMap<Character, Integer> sMap = new HashMap<>();
        for (char c : sChars) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char c : tChars) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        for (char c : tChars) {
            if (!java.util.Objects.equals(sMap.get(c), tMap.get(c))) {
                return false;
            }
        }
        return true;

    }
}
