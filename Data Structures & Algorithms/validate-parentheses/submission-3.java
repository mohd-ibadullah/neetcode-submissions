class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (!st.isEmpty()) {
                    char t = st.peek();
                    if ((ch == ')' && t == '(') || (ch == ']' && t == '[')
                        || (ch == '}' && t == '{')) {
                            st.pop();
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
