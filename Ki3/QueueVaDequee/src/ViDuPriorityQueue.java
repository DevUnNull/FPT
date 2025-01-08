
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class ViDuPriorityQueue {
    public static void main(String[] args) {
        Queue<String> danhSachSV  = new PriorityQueue<String>();
        
        danhSachSV.offer("e UnNull");
        danhSachSV.offer("d Hai2lai");
        danhSachSV.offer("c nguyen van a");
        danhSachSV.offer("b to van b");
        danhSachSV.offer("a dung co c");
        
        while(true){
            String ten = danhSachSV.poll();// poll lấy ra và xóa luôn còn peek lấy ra nhưng không xóa 
            if(ten==null){
                break;
            }
            System.err.println(ten);
        }
    }
}
