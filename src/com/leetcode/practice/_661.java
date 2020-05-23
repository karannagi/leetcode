class Solution {
   private int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    private int rowLen;
    private int colLen;
    public int[][] imageSmoother(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) return M;
        rowLen = M.length;
        colLen = M[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                int count = 0, sum = 0;
                for (int k = 0; k < dir.length; k++) {
                    int x = i + dir[k][0], y = j + dir[k][1];
                    if (check(x, y)) {
                        count++;
                        sum += (M[x][y] & 255);
                    }
                }
                M[i][j] += ((sum / count) << 8);
            }
        }
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                M[i][j] >>= 8;
            }
        }
        return M;
    }
    
    private boolean check(int x, int y) {
        if (x < 0 || x >= rowLen || y < 0 || y >= colLen) {
            return false;
        }
        return true;
    }
}
