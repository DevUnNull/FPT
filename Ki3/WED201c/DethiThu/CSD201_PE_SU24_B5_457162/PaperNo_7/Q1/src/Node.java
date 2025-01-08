// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
// == You can insert setters and/or getters only if you need them ==== 
class Node {
  Boat info;
  Node next;
  Node() {
   }
  Node(Boat x, Node p) {
    info=x;next=p;
   }
  Node(Boat x) {
    this(x,null);
   }
 }

