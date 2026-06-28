class Node{
    int val;
    Node next;

    public Node(int val){
        this.val = val;
    }

    public Node(int val, Node next){
        this.val = val;
        this.next = next;
    }
}
class LinkedList {

    Node head; 
    Node tail;

    public LinkedList() {
        this.head = new Node(-1);
        this.tail = this.head;
    }

    public int get(int index) {
        int counter = 0;
        Node curr = head.next;
        while (curr != null) {
            if (index == counter){
                return curr.val;        
            }
            counter++;
            curr = curr.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head.next;
        head.next = newNode;
        if(newNode.next == null){
            tail = newNode;
        }
    }

    public void insertTail(int val) {
        tail.next = new Node(val);
        tail = tail.next;    
    }

    public boolean remove(int index) {
        Node prev = head;
        Node curr = head.next;
        int counter = 0;

        while (curr != null){
            if (index == counter){
                prev.next = curr.next;   
                if (curr == tail){
                    tail = prev;
                }
                return true;
            }
            prev = curr;
            curr = curr.next;
            counter++;
        }
        return false;       
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        Node curr = head.next;
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }
        return values;
    }
}
