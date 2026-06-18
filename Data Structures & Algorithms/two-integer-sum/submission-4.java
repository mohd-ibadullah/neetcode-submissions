class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int d = target - n;
            if (hm.containsKey(d)) {
                return new int[] {hm.get(d), i};
            }
            hm.put(n, i);
        }
        return new int[] {};
    }
}
