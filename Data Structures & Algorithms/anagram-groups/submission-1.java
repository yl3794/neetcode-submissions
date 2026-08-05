class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Sub optimal sort the words and group O(m n long n)
        // m is the length of the longest string
        // n is the number of words


        // Optimal O(m n)
        // if (strs.length == 0) return new ArrayList<>();

        // int n = strs.length;
        // int[] frequencies = new int[26];
        // Map<String, List<String>> map = new HashMap<>();

        // for (int i = 0; i < n; i++) {
        //     String word = strs[i];
        //     Arrays.fill(frequencies, 0);
        //     for (int j = 0; j < word.length(); j++) {
        //         frequencies[word.charAt(j) - 'a']++;
        //     }

        //     StringBuilder sb = new StringBuilder("");

        //     for (int k = 0; k < 26; k++) {
        //         sb.append("#");
        //         sb.append(frequencies[k]);
        //     }

        //     String key = sb.toString();

        //     if (!map.containsKey(key)) {
        //         map.put(key, new ArrayList<>());
        //     }
        //     map.get(key).add(word);
        // }

        // return new ArrayList<>(map.values());

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());

    }
}
