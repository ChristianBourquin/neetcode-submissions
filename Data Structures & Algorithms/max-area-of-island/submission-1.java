class Solution {
    int count;
    public int maxAreaOfIsland(int[][] grid) {
        int maxCount = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    count = 0;
                    traverse(grid, i, j);
                    if(count > maxCount){
                        maxCount = count;
                    }
                }
            }
        }
        return maxCount;
    }

    public void traverse(int[][] grid, int r, int c){
        if(r < 0|| c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == 0){
            return;
        }
        grid[r][c] = 0;
        count++;
        
        traverse(grid, r + 1, c);
        traverse(grid, r - 1, c);
        traverse(grid, r, c + 1);
        traverse(grid, r, c - 1);
    }
}
