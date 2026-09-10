class Solution {
    public int shortestPath(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        // if the start itself is a rock, there's no valid path at all
        if (grid[0][0] == 1) {
            return -1;
        }

        int[][] visit = new int[ROWS][COLS];
        Deque<int[]> queue = new ArrayDeque<>();
        //add top left
        queue.add(new int[2]); // Add {0, 0}
        visit[0][0] = 1;

        int length = 0;
        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                //this pair is the one we are visiting
                int pair[] = queue.poll();
                int r = pair[0], c = pair[1];
                //the ending node is (ROWS-1, COLS-1) -- once polled, this is guaranteed
                //to be the shortest path, so we can return immediately
                if (r == ROWS - 1 && c == COLS - 1) {
                    return length;
                }    
                // We can directly build the four neighbors(down, up, right, left)
                int[][] neighbors = {{r, c + 1}, {r, c - 1}, {r + 1, c}, {r - 1, c}};
                for (int j = 0; j < 4; j++) {

                    //initializing the coords of a candidate neighbor we might add to the queue
                    int newR = neighbors[j][0];
                    int newC = neighbors[j][1];
                    
                    //checking if the coords are out of bounds, already visited, or a wall/obstacle - if so, skip
                    if (Math.min(newR, newC) < 0 || newR == ROWS || newC == COLS
                    || visit[newR][newC] == 1 || grid[newR][newC] == 1) {
                        continue;
                    }

                    //actually adding that neighbor to the queue to be visited
                    queue.add(neighbors[j]);
                    //marking that neighbor as visited (not the current cell - that was already marked earlier)
                    visit[newR][newC] = 1;
                }
                //now moving to the next in line to be visited
            }
            //we have made it through this layer so we can add one to length
            length++;
        }
        //queue emptied out without ever reaching the destination - no path exists
        return -1;
    }
}