class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int t = 0;
        int b = r - 1;
        while (t <= b) {
            int m = (t + b) / 2;
            if (target > matrix[m][c - 1]) {
                t = m + 1;
            } else if (target < matrix[m][0]) {
                b = m - 1;
            } else {
                break;
            }
        }
        int row = (t + b) / 2;
        int left = 0;
        int right = c - 1;
        while (left <= right) {
            int m = (left + right) / 2;
            if (target == matrix[row][m]) {
                return true;
            } else if (target > matrix[row][m]) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        return false;
    }
}
