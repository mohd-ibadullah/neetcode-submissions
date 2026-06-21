class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows[] = new int[9];
        int cols[] = new int[9];
        int boxes[] = new int[9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if(board[r][c] == '.') continue;
                int mask = 1 << (board[r][c] - 1);
                if ((rows[r] & mask) > 0 || (cols[c] & mask) > 0
                    || (boxes[r / 3 * 3 + c / 3] & mask) > 0) {
                    return false;
                }
                rows[r] |= mask;
                cols[c] |= mask;
                boxes[r / 3 * 3 + c / 3] |= mask;
            }
        }
        return true;
    }
}
