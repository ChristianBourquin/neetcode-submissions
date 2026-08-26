class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(){

    }

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;

        //dummy nodes
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;

        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }

        //remove node from current location and add it to the tail
        Node node = map.get(key);
        remove(node);
        add(node);

        return node.val;
    }
    public void put(int key, int value){

            //if the map currently has key then change the value and add to tail
            if (map.containsKey(key)){
                Node node = map.get(key);

                node.val = value;

                remove(node);
                add(node);

                return;
            }

            //if the size of the map is at capacity then remove the least recently used
            if (map.size() == capacity){
                Node lru = head.next;

                remove(lru);
                map.remove(lru.key);
            }

            //add new node to tail and add node to map
            Node node = new Node(key, value);

            add(node);
            map.put(key, node);
        }

        private void add(Node node){
        //adding recently used node to tail of list
        Node previousLast = tail.prev;

        previousLast.next = node;
        node.prev = previousLast;

        //updating dummy nodes
        node.next = tail;
        tail.prev = node;
        }

    private void remove(Node node){
        //remove node from list and stitch together
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
