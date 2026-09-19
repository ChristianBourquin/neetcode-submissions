/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            Node curr = queue.poll();
            Node currClone = map.get(curr);

            for (Node neighbor : curr.neighbors){
                if (!map.containsKey(neighbor)){
                    map.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                currClone.neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}