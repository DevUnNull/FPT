// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
// == You can insert setters and/or getters only if you need them ==== 
class Bike {
  String owner;
  int price,color;
  Bike() {
   }
  Bike(String xOwner, int xPrice, int xColor){
    owner=xOwner;price=xPrice; color=xColor;
   }
  public String toString(){
    return("(" +owner+","+price + "," + color + ")");
   }
 }
