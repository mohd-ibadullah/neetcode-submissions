class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> st = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!st.isEmpty() && st.peek()[1] > heights[i]) {
                int popped[] = st.pop();
                int index = popped[0];
                int height = popped[1];
                maxArea = Math.max(maxArea, (i - index) * height);
                start = index;
            }
            st.push(new int[] {start, heights[i]});
        }
        for (int s[] : st) {
            int index = s[0];
            int height = s[1];
            maxArea = Math.max(maxArea, (heights.length - index) * height);
        }
        return maxArea;
    }
}
