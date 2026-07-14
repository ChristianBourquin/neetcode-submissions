class Node{

    Node next;
    Node prev;
    String url;
    public Node(String url){
        this.url = url;
    }
}
class BrowserHistory {

    Node head;
    Node curr;
    Node tail;
    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        curr = head;
        tail = head;
    }

    public void visit(String url) {
        Node newUrl = new Node(url);
        newUrl.next = null;
        newUrl.prev = curr;
        tail = newUrl;
        curr.next = tail;
        curr = curr.next;
    }

    public String back(int steps) {
        for(int i = 0; i < steps; i++){
            if(curr.prev == null){
                return head.url;
            }else{
                curr = curr.prev;
            }
        }
        return curr.url;
    }

    public String forward(int steps) {
        for(int i = 0; i < steps; i++){
            if(curr.next == null){
                return tail.url;
            }else{
                curr = curr.next;
            }
        }
        return curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */