class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(stones.length, Collections.reverseOrder());
        for (int stone : stones) {
            maxPQ.add(stone);
        }
        while(maxPQ.size() > 1){
            int first = maxPQ.poll();
            int second = maxPQ.poll();

            if(first > second){
                first -= second;
                maxPQ.offer(first);
            }
        }
        if(maxPQ.size() == 0){
            return 0;
        }
        return maxPQ.poll();
    }
}
