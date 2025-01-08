
package logic;

/**
 *
 * @author User
 */
public class LingkedList<T> {
    private Node<T> head;

    public LingkedList(){
        this.head = null;
    }
    
    public LingkedList(Node<T> head) {
        this.head = head;
    }
    // duyet tung phan tu 
    public void traverse(){
        Node<T> tmp = head;
        while(tmp!=null){
            // in phan tu 
            System.err.println(tmp.getData());
            tmp = tmp.getNext();
        }
    }
    
    //chen phan tu vao dau 
    public void addFirst(T item){
        //cach 1
        Node<T> newNode = new Node<>(item, this.head);
        // cach 2 
        //Node<T> newNode = new Node<>();
        //newNode.getData(item);
        //newNode.getNext(head);
        this.head = newNode;
    }
    
    //chen phan tu vao cuoi
    public  void addLast(T item){
        if(head == null){
            addFirst(item);
        }else{
            Node<T> newNode = new Node<>(item, null);
            Node<T> tmp = head;
            while(tmp.getNext()!=null){
                tmp = tmp.getNext();
            }
            tmp.setNext(newNode);
        }
    }
    
    // chen vao sau 1 phan tu chi dinh
    public void insertAfter(T key , T toInsert){
        // di tim vi tri 
        Node<T> tmp = head;
        // tim node chua key
        while(tmp!=null && !tmp.getData().equals(key)){
            tmp = tmp.getNext();
        }
        // 
        if(tmp!=null){
            // buoc 1 tao ra 1 node moi
            //Node<T> newNode = new Node<>();
            //newNode.setData(toInsert);
            Node<T> newNode  = new Node<>(toInsert,tmp.getNext());
            tmp.setNext(newNode);
        }else{
            addFirst(toInsert);
        }
    }
    
    // xoa 1 node
    public void remove(T key){
        if(head == null){
            throw new RuntimeException("can not delete");
        }
        // xoa neu key o vi tri dau tien 
        if(head.getData().equals(key)){
            this.head = head.getNext();
            return;
        }
        
        // xoa
        Node<T> prev = null;
        Node<T> cur = head;
        
        while(cur!=null && !cur.getData().equals(key)){
            prev = cur;
            cur = cur.getNext();
            
        }
        
        if(cur == null){
            throw new RuntimeException("Can not delete");
        }
        // xoa Node
        prev.setNext(cur.getNext());
        
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    public int size(){
        int count =0;
        
        Node<T> tmp = head;
        while(tmp!=null){
            // in phan tu 
            count++;
            tmp = tmp.getNext();
        }
        return count;
    }
}
