class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int time = 0;
        int totalFruit = 0;
        int[][] visited = new int[ROWS][COLS];
        Deque<int[]> queue = new ArrayDeque<>();
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if(grid[row][col] == 2){
                    queue.offer(new int[]{row, col});
                    visited[row][col] = 1;
                }
                if(grid[row][col] == 1){
                    totalFruit++;
                }
            }
        }

        while(!queue.isEmpty() && totalFruit > 0){
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++){
                int[] cur = queue.poll();
                int row = cur[0], col = cur[1];
                int[][] neighboors = {{row + 1, col}, {row - 1, col}, {row, col + 1}, {row, col - 1}};
                for(int j = 0; j < 4; j++){
                    int nRow = neighboors[j][0];
                    int nCol = neighboors[j][1];
                    if(nRow < 0 || nRow >= ROWS ||nCol < 0 || nCol >= COLS || grid[nRow][nCol] == 0 || visited[nRow][nCol] == 1){
                        continue;
                    }
                    queue.offer(new int[]{nRow, nCol});
                    totalFruit--;
                    visited[nRow][nCol] = 1;
                }
            }
            time++;
        }
        if(totalFruit == 0){
            return time;
        }else{
            return -1;
        }
    }
}
