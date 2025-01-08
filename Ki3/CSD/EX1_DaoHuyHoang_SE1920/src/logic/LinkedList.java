/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author User
 */
public class LinkedList<T> {
    private Node<T> head;
    
    public LinkedList(){
        head = null;
    }
    
    public LinkedList(Node<T> head){
        this.head = head;
    }
    
    // duyet tung phan tu
    public void traverse(){
        Node<T> tmp = head;
        while(tmp!= null){
            // in ra cac phan tu
            System.out.print(tmp.getData()+" ");
            tmp = tmp.getNext();
        }    
    }
    
    // chen phan tu vao dau 
    public  void addFirst(T item ){
        Node<T> newNode = new Node<>(item, this.head);
        // set head len phan tu moi chen vao
        this.head = newNode;
    }
    
    // chen phan tu vao cuoi
    public void addLast(T item){
        if(head == null){
            addFirst(item);
        }else{
           Node<T> newNode = new Node<>(item,null);
           Node<T> tmp = head;
           // tim vi tri cuoi cung
           while(tmp.getNext()!=null){
               tmp = tmp.getNext();
           }
           // chen phan tu moi vao vi tri cuoi cung
           tmp.setNext(newNode);
        }
    }
    
    public void addToAfter(T key , T toInsert){
        Node<T> tmp = head;
        // tim key
        while(tmp!= null && !tmp.getData().equals(key)){
            tmp = tmp.getNext();
        }
        
        if(tmp!=null){
            
            Node<T> newNode  = new Node<>(toInsert, tmp.getNext());
            tmp.setNext(newNode);
        }else{
            addFirst(toInsert);
        }
    }
    
    public void remove(T key){
        Node<T> prev = null;
        Node<T> cur = head;
        
        if(head == null){
            throw new RuntimeException("can not delete");
        }
        
        while(cur!=null && !cur.getData().equals(key)){
            prev = cur;
            cur = cur.getNext();
        }
        if(cur == null){
            throw new RuntimeException("can not find key");
        }else{
            prev.setNext(cur.getNext());
        }
    }
    
    public void size(){
        int count =0 ;
        Node<T> tmp = head;
        while(tmp!=null){
            count ++;
            tmp = tmp.getNext();
        }
        System.out.println(count);
    }
    
}
