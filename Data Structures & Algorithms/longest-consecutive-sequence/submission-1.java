class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i : nums) {
            hs.add(i);
        }
        int longest = 0;
        for (int num : hs) {
            if (!hs.contains(num - 1)) {
                int l = 1;
                while (hs.contains(num + l)) {
                    l++;
                }
                longest = Math.max(longest, l);
            }
        }
        return longest;
    }
}
