
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Main {
    public static void kiemTraSapXepXongChua(int[] array,int left, int right){
        // tao 1 bien = gia tri hien tai lay lam moc
        int i = phanVung(array,left,right);
        if(left<i-1){
            kiemTraSapXepXongChua(array, left, i-1);
        }
        if(right>i){
            kiemTraSapXepXongChua(array, i, right);
        }
    }
    public static int phanVung(int[] array,int left, int right){
        int moc = array[(left+right)/2];
        while (left <= right) {
            while (array[left] < moc) {
                left++;
            }
            while (array[right] > moc) {
                right--;
            }
            if (left <= right) {
                // Swap elements
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
    
    
    public static void main(String[] args) {
        int[] a = {4,3,7,-1,-5,10,5};
        kiemTraSapXepXongChua(a, 0, a.length-1);
        //in ra array sau khi xếp
        for(int i=0;i<a.length;i++){
            System.err.print(a[i]+" ");
        }
    }
}
