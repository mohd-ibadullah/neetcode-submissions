class Solution {
    public int[] productExceptSelf(int[] nums) {
        int res[] = new int[nums.length];
        int prefix = 1;
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = prefix = (prefix * nums[i - 1]);
        }
        int postfix = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] = (postfix * res[i]);
            postfix *= nums[i];
        }
        return res;
    }
}
