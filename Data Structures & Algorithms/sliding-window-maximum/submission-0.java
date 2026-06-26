class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int l = 0, r = 0, n = nums.length;
        int output[] = new int[n - k + 1];
        while (r < n) {
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[r]) {
                dq.removeLast();
            }
            dq.addLast(r);
            if (dq.getFirst() < l) {
                dq.removeFirst();
            }
            if ((r + 1) >= k) {
                output[l] = nums[dq.getFirst()];
                l++;
            }
            r++;
        }
        return output;
    }
}
