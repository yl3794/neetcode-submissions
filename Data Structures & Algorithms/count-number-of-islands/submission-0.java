class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int islands = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfs(i, j, grid);

                }
            }
        }
        return islands;    
    }

    private void dfs(int row, int col, char[][] grid) {
        int newRow = grid.length;
        int newCol = grid[0].length;

        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        if (row < 0 || col < 0 || row >= newRow || col >= newCol || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        for (int[] dir : directions) {
            dfs(row + dir[0], col + dir[1], grid);
        }
    }
}