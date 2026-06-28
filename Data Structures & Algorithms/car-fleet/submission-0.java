class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Stack<Double> st = new Stack<>();
        int twod[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            twod[i][0] = position[i];
            twod[i][1] = speed[i];
        }
        Arrays.sort(twod, (a, b) ->  Integer.compare(b[0], a[0]) );
        for (int i = 0; i < n; i++) {
            st.push((double)(target - twod[i][0]) / twod[i][1]);

            if (st.size() >= 2 && st.peek() <= st.get(st.size() - 2)) {
                st.pop();
            }
        }
        return st.size();
    }
}
