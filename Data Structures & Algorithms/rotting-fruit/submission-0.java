class Solution {
    private static final int[][] directions = {{0,1}, {1,0}, {-1,0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        int fresh = 0;
        int time = 0;

        Deque<int[]> queue = new ArrayDeque<>();
        
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty() && fresh != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        fresh--;
                    }
                }
            }
            time++;
        }

        if (fresh == 0) return time;

        return -1;
    }
}
