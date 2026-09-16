class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        if(grid[0][0] == 1 || grid[ROWS - 1][COLS - 1] == 1){
            return -1;
        }
        int[][] visited = new int[ROWS][COLS];
        Deque<int[]> queue = new ArrayDeque<>();

        visited[0][0] = 1;
        queue.offer(new int[2]);

        int length = 1;
        while(!queue.isEmpty()){
            int queueLength = queue.size();

            for(int i = 0; i < queueLength; i++){
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                if(row == ROWS - 1 && col == COLS - 1){
                    return length;
                }
                int[][] neighboors = {{row + 1, col}, {row - 1, col}, {row, col + 1}, {row, col - 1},{row + 1, col + 1}, {row + 1, col - 1}, {row - 1, col + 1}, {row - 1, col - 1}};
                for(int j = 0; j < 8; j++){
                    int nRow = neighboors[j][0];
                    int nCol = neighboors[j][1];
                    if(nRow < 0 || nRow >= ROWS || nCol < 0 || nCol >= COLS || grid[nRow][nCol] == 1 || visited[nRow][nCol] == 1){
                    continue;
                    }
                    queue.offer(neighboors[j]);
                    visited[nRow][nCol] = 1;
                }
            }
            length++;
        }
        return -1;
    }
}