class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int s1f[] = new int[26];
        int s2f[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1f[s1.charAt(i) - 'a']++;
            s2f[s2.charAt(i) - 'a']++;
        }
        int m = 0;
        for (int i = 0; i < 26; i++) {
            if (s1f[i] == s2f[i]) {
                m++;
            }
        }
        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (m == 26)
                return true;
            int idx = s2.charAt(r) - 'a';
            s2f[idx]++;
            if (s1f[idx] == s2f[idx]) {
                m++;
            } else if (s1f[idx] + 1 == s2f[idx]) {
                m--;
            }

            idx = s2.charAt(l) - 'a';
            s2f[idx]--;
            if (s1f[idx] == s2f[idx]) {
                m++;
            } else if (s1f[idx] - 1 == s2f[idx]) {
                m--;
            }
            l++;
        }
        return m == 26;
    }
}
