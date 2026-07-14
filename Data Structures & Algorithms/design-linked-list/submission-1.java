class Node{
    int val;
    Node next;
    Node prev;
    public Node(int val){
        this.val = val;
    }

    public Node(){

    }
}
class MyLinkedList {
    Node head;
    Node tail;
    Node curr;
    int size;
    public MyLinkedList() {
        size = 0;
    }

    public int findIndex(int index){
        if (index < 0 || index >= size) return -1;
        curr = head;
        for(int i = 0; i < index; i++){
            curr = curr.next;
        }
        return 1;
    }

    public int get(int index) {
        int check = findIndex(index);
        if(check == -1) return -1;
        return curr.val;
    }

    public void addAtHead(int val) {
        Node add = new Node(val);
        if(head == null){
            head = add;
            tail = add;
        } else {
            add.next = head;
            head.prev = add;
            head = add;
        }
        size++;
    }

    public void addAtTail(int val) {
        Node add = new Node(val);
        if(tail == null){
            head = add;
            tail = add;
        } else {
            add.prev = tail;
            tail.next = add;
            tail = add;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        findIndex(index);
        Node add = new Node(val);
        Node before = curr.prev;
        add.prev = before;
        add.next = curr;
        before.next = add;
        curr.prev = add;
        size++;
    }

    public void deleteAtIndex(int index) {
        int check = findIndex(index);
        if(check == -1) return;
        if (head == tail) {
            head = null;
            tail = null;
        } else if (curr == head) {
            head = head.next;
            head.prev = null;
        } else if (curr == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }
        size--;
    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

