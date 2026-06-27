class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") && !st.isEmpty()) {
                int first = st.pop();
                int second = st.pop();
                if (s.equals("+")) {
                    st.push(first + second);
                } else if (s.equals("-")) {
                    st.push(second - first);
                } else if (s.equals("*")) {
                    st.push(first * second);
                } else if (s.equals("/")) {
                    st.push(second / first);
                }
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}
