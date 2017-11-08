class LRUCache {
    
    private HashMap<Integer, Node> map;
    private Node head, tail;
    private int capacity, size;


    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        //设置两个虚拟的helper node
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        head.prev=null;
        tail.next=null;
        this.capacity=capacity;
        //size用于记录当前doublelinkedlist的长度
        size=0;
    }
    
    //删除任一node
    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //因为有helper node使得操作很方便
    public void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    //每次更新，都采取一下步骤
    //  1.获取Node
    //  2.删除该Node
    //  3.更新Node
    //  4.把Node插入List最前端
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (size < capacity) {
                size++;
                addToHead(node);
            } else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
        }
    }
    
    
}


//注意Node内也包含key，相当于Map中包含两次key
//一次做key，一次做Node中的一个值
class Node{
    int key;
    int value;
    Node prev;
    Node next;
    
    public Node(int key, int value){
        this.key=key;
        this.value=value;
    }
}





/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
