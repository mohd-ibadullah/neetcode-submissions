class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String s : strs) {
            int arr[] = new int[26];
            char a[] = s.toCharArray();
            for (char ch : a) {
                arr[ch - 'a']++;
            }
            String key = Arrays.toString(arr);
            hm.putIfAbsent(key, new ArrayList<>());
            hm.get(key).add(s);
        }
        return new ArrayList<>(hm.values());
    }
}
