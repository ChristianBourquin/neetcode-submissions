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
        if(node == null){
            return null;
        }

        if(node.neighbors.size() == 0){
            return new Node(node.val);
        }

        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node());
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            int length = queue.size();

            for(int i = 0; i < length; i++){
                Node currNode = queue.poll();
                
                if(map.containsKey(currNode) && map.get(currNode).val != 0){
                    continue;
                }
                ArrayList<Node> list = new ArrayList<>();

                for(int j = 0; j < currNode.neighbors.size(); j++){
                    Node currNeighbor = currNode.neighbors.get(j);
                    if(map.containsKey(currNeighbor)){
                        list.add(map.get(currNeighbor));
                    }else{
                        map.put(currNeighbor,new Node());
                        list.add(map.get(currNeighbor));
                        queue.offer(currNeighbor);

                    }
                }
                if(map.containsKey(currNode)){
                    map.get(currNode).val = currNode.val;
                    map.get(currNode).neighbors = list;
                }else{
                    map.put(currNode, new Node(currNode.val, list));
                }                
            }
        }
        return map.get(node);
    }
}