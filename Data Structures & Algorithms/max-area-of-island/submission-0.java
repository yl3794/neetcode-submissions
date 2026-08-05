class Solution {
    private static final int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int area = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    area = Math.max(area, dfs(i, j, grid));
                }
            }
        }

        return area;
    }

    private int dfs(int r, int c, int[][] grid) {
        int newRow = grid.length;
        int newCol = grid[0].length;

        if (r < 0 || c < 0 || r >= newRow || c >= newCol || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;
        int ans = 1;
        for (int[] dir : directions) {
            ans += dfs(r + dir[0], c + dir[1], grid);
        }

        return ans;

    }
}
