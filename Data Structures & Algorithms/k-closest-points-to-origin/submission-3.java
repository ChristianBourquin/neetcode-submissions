class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> 
        (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));

        int[][] closest = new int[k][2];

        for(int i = 0; i < points.length; i++){
            queue.offer(points[i]);
        }

        for(int j = 0; j < k; j++){
            closest[j] = queue.poll();
        }
        
        return closest;
    }
}
