
import java.util.LinkedList;
import java.util.Queue;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class ViDuQueue {
    public static void main(String[] args) {
        Queue<String> danhSachSV  = new LinkedList<String>();
        
        danhSachSV.offer("UnNull");
        danhSachSV.offer("Hai2lai");
        danhSachSV.offer("nguyen van a");
        danhSachSV.offer("to van b");
        danhSachSV.offer("dung co c");
        
        while(true){
            String ten = danhSachSV.poll();// poll lấy ra và xóa luôn còn peek lấy ra nhưng không xóa 
            if(ten==null){
                break;
            }
            System.err.println(ten);
        }
    }
}
