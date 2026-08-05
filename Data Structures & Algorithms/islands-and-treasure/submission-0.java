class Solution {
    private static final int[][] directions = {{0,1}, {1, 0}, {-1, 0}, {0, -1}};
    private int INF = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == INF) {
                    int minDis = bfs(i, j, grid);
                    grid[i][j] = minDis;
                }
            }
        }
    }

    private int bfs(int row, int col, int[][] grid) {
        int NEWROWS = grid.length;
        int NEWCOLS = grid[0].length;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        boolean[][] visited = new boolean[NEWROWS][NEWCOLS];
        visited[row][col] = true;
        int steps = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.pop();
                int r = cur[0], c = cur[1];
                if (grid[r][c] == 0) return steps;

                for (int[] dir : directions) {
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];

                    if (newRow >= 0 && newRow < NEWROWS && newCol >= 0 && newCol < NEWCOLS && !visited[newRow][newCol] && grid[newRow][newCol] != -1) {
                        visited[newRow][newCol] = true;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            steps++;
        }
        return INF;

    }


}
