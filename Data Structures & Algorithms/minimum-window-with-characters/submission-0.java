class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            hm.put(t.charAt(i), hm.getOrDefault(t.charAt(i), 0) + 1);
        }
        int have = 0;
        int need = hm.size();
        int l = 0;
        int result[] = {0, 0};
        int rl = Integer.MAX_VALUE;
        HashMap<Character, Integer> w = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            w.put(c, w.getOrDefault(c, 0) + 1);
            if (hm.containsKey(c) && w.get(c).equals(hm.get(c))) {
                have++;
            }
            while (have == need) {
                if (r - l + 1 < rl) {
                    rl = r - l + 1;
                    result[0] = l;
                    result[1] = r;
                }
                char lc = s.charAt(l);
                w.put(lc, w.get(lc) - 1);
                if (hm.containsKey(lc) && w.get(lc) < hm.get(lc)) {
                    have--;
                }
                l++;
            }
        }
        return rl == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
    }
}
