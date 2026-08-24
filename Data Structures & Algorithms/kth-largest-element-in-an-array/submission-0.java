class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : nums) {
            queue.add(n);
        }
        int largest = 0;;
        for(int i = 0; i < k; i++){
            largest = queue.poll();
        }
        return largest;
    }
}