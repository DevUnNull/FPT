
package main;

import logic.Node;
import logic.LingkedList;

/**
 *
 * @author User
 */
public class Main {
    public static void main(String[] args) {
        LingkedList<String> ll = new LingkedList<>();
        ll.addFirst("le nhat tung");
        ll.addFirst("CTDL va Giai thuat Java");
        
        ll.traverse();
        
        ll.addLast("ga qua");
        
        ll.traverse();
        ll.insertAfter("le nhat tung", "cuc ngyu");
        
        ll.traverse();
        
        ll.remove("le nhat tung");
        ll.traverse();
        
        System.out.println("co: "+ll.size());
    }
}
