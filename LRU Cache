class LRUCache {
 
   HashMap<Integer,Node>map;
   Node head;
   Node tail;
    int capacity;
    int count;
    /*Inititalize an LRU cache with size N */
    public LRUCache(int N) {
       //Your code here
        map=new HashMap<Integer,Node>();
        count=0;
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        head.prev=null;
        tail.next=null;
        this.capacity=N;
        
    }
    public void addHead(Node node){
        /*node.prev=null;
        node.next=head;
        head.prev=node;
        head=node;*/
         node.next = head.next; 
        node.next.prev = node; 
        node.prev = head; 
        head.next = node; 
    }
    public void deleteNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    /*Returns the value of the key x if 
     present else returns -1 */
    public int get(int x) {
       //Your code here
      if(map.get(x)!=null){
          Node node=map.get(x);
          int val=node.value;
          deleteNode(node);
          addHead(node);
          return val;
      }
                else
                return -1;
       }
    
    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
        if(map.containsKey(x)){
           Node node=map.get(x);
           node.value=y;
           deleteNode(node);
          addHead(node);
        }else{
            Node node=new Node(x,y);
            map.put(x,node);
            if(count <capacity){
                count++;
                addHead(node);
            }else{
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addHead(node);
            }
        }
       
    }
}
class Node{
    int key;
    int value;
     Node prev;
     Node next;
    public Node(int key,int value){
        this.key=key;
        this.value=value;
    }
  
}
//Structure is Like H->T
// add Node H->N->T
//add Node H->N->N->T
//delete Node H->N->T
//delete Node H->T
