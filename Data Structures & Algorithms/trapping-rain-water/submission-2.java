class Solution {
    public int trap(int[] height) {
        // int n = height.length;
        // int l[] = new int[n];
        // int r[] = new int[n];
        // l[0] = height[0];
        // for (int i = 1; i < n; i++) {
        //     l[i] = Math.max(l[i - 1], height[i]);
        // }
        // r[n - 1] = height[n - 1];
        // for (int i = n - 2; i >= 0; i--) {
        //     r[i] = Math.max(r[i + 1], height[i]);
        // }
        // int result = 0;
        // for (int i = 0; i < n; i++) {
        //     result += Math.min(l[i], r[i]) - height[i];
        // }
        // return result;
        int l = 0;
        int r = height.length - 1;
        int lm = height[l];
        int rm = height[r];
        int result = 0;
        while (l < r) {
            if (lm < rm) {
                l++;
                lm = Math.max(lm, height[l]);
                result += (lm - height[l]);
            } else {
                r--;
                rm = Math.max(rm, height[r]);
                result += (rm - height[r]);
            }
        }
        return result;
    }
}
