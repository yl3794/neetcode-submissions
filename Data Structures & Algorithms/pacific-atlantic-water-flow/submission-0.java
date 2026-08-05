class Solution {
    private static final int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS]; 

        Queue<int[]> pacQueue = new ArrayDeque<>();
        Queue<int[]> atlQueue = new ArrayDeque<>();
        
        for (int j = 0; j < COLS; j++) {
            pacQueue.offer(new int[]{0,j});
            atlQueue.offer(new int[]{ROWS - 1,j});
        }
        for (int i = 0; i < ROWS; i++) {
            pacQueue.offer(new int[]{i, 0});
            atlQueue.offer(new int[]{i, COLS - 1});
        } 

        bfs(pacQueue, pac, heights);
        bfs(atlQueue, atl, heights);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void bfs(Queue<int[]> queue, boolean[][] ocean, int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        while (!queue.isEmpty()) {
            int curr[] = queue.poll();
            int row = curr[0];
            int col = curr[1];

            ocean[row][col] = true;
            
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newCol >= 0 && newRow < ROWS && newCol < COLS && !ocean[newRow][newCol] && heights[newRow][newCol] >= heights[row][col]) {
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }


}
