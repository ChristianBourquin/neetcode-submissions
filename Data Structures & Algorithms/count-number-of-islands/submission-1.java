class Solution {
    int count = 0;
    public int numIslands(char[][] grid) {
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count += 1;
                    traverse(grid, i, j);
                }
            }
        }
        return count;
    }

    public void traverse(char[][] grid, int r, int c){
        if(r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        
        traverse(grid, r + 1, c);
        traverse(grid, r - 1, c);
        traverse(grid, r, c + 1);
        traverse(grid, r, c - 1);
    }
}
