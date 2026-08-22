class LFUCache {
    class Node{
        int key,value, freq;
        Node prev,next;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            this.freq=1;
        }
    }
    class dll{
        Node head,tail;
        int size;
        dll(){
            head=new Node(-1,-1);
            tail=new Node(-1,-1);
            head.next=tail;
            tail.prev=head;

            size=0;
        }
        void add(Node node){
            node.next=head.next;
            node.prev=head;
            head.next.prev=node;
            head.next=node;
            size++;
        }
        void remove(Node node){
            node.prev.next=node.next;
            node.next.prev=node.prev;
            size--;
        }
        Node removeTail(){
            if(size>0){
                Node lru=tail.prev;
                remove(lru);
                return lru;
            }
            return null;
        }
    }
    private int capacity;
    HashMap<Integer,Node> keyNode;
    HashMap<Integer,dll> freqList;
    int minFreq;
    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.minFreq=0;
        this.keyNode=new HashMap<>();
        this.freqList=new HashMap<>();
    }
    private void update(Node node){
        int oldFreq=node.freq;
        dll oldList=freqList.get(oldFreq);
        oldList.remove(node);
        if(oldFreq==minFreq && oldList.size==0) minFreq++;
        node.freq++;
        dll newList=freqList.getOrDefault(node.freq,new dll());
        newList.add(node);
        freqList.put(node.freq,newList);

    }
    public int get(int key){
        Node node=keyNode.get(key);
        if(node==null)  return -1;
        update(node);
        return node.value;
    }
    public void put(int key, int value) {
        if(capacity==0) return;
        if(keyNode.containsKey(key)){
            Node node=keyNode.get(key);
            node.value=value;
            update(node);
            return;
        }
        if(keyNode.size()==capacity){
            dll minFreqList=freqList.get(minFreq);
            Node evict=minFreqList.removeTail();
            keyNode.remove(evict.key);

        }
        Node newNode=new Node(key,value);
        minFreq=1;
        dll list=freqList.getOrDefault(1,new dll());
        list.add(newNode);
        freqList.put(1,list);
        keyNode.put(key,newNode);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */