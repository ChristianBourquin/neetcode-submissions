class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int totalFruit = 0;
        Deque<int[]> queue = new ArrayDeque<>();

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if(grid[row][col] == 2){
                    queue.offer(new int[]{row, col});
                } else if(grid[row][col] == 1){
                    totalFruit++;
                }
            }
        }

        int time = 0;
        while(!queue.isEmpty() && totalFruit > 0){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                int row = cur[0], col = cur[1];
                int[][] neighboors = {{row + 1, col}, {row - 1, col}, {row, col + 1}, {row, col - 1}};
                for(int j = 0; j < 4; j++){
                    int nRow = neighboors[j][0];
                    int nCol = neighboors[j][1];
                    if(nRow < 0 || nRow >= ROWS ||nCol < 0 || nCol >= COLS || grid[nRow][nCol] != 1){
                        continue;
                    }
                    grid[nRow][nCol] = 2;
                    totalFruit--;
                    queue.offer(new int[]{nRow, nCol});
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
