// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Bottle {
  String maker;
  int volume,color;
  Bottle() {
   }
  Bottle(String xMaker, int xVolume, int xColor){
    maker=xMaker;volume=xVolume; color=xColor;
   }
  public String toString(){
    return("(" +maker+","+volume + "," + color + ")");
   }
 }
