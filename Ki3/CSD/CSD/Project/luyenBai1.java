import java.util.Random;
import java.util.Scanner;

public class luyenBai1 {
    public static void main(String[] args) {
        /*
         * cau1
         * System.out.println("nhap n");
         * Scanner scan = new Scanner(System.in);
         * int n = scan.nextInt();
         * int[] arr = new int[n];
         * System.out.println("do dai cua arr : "+arr.length);
         * 
         * cau2
         * //cho 1 mang arr
         * int[] arr = {1,2,3,4};
         * //display mess
         * System.out.println("ban muon so cuoi co gia tri la: ");
         * //input
         * Scanner scan = new Scanner(System.in);
         * arr[3] = scan.nextInt();
         * System.out.print("chuoi: ");
         * for(int i=0;i<=3;i++){
         * System.out.print(arr[i]+",");
         * 
         * cau3
         * int[] arr = {1,2,3,4,5};
         * System.out.print("tong 2 so dau cau arr la:");
         * int tong = arr[0] +arr[1];
         * System.out.println(tong);
         * 
         * cau4
         * int[] arr = {12,4,5,6,2,4};
         * System.out.print("tong cac gia tri trong mang la : ");
         * int tong = 0;
         * for(int i=0;i<arr.length;i++){
         * tong+= arr[i];
         * }
         * System.out.println(tong);
         * 
         * cau5
         * int[] arr = {32,54,1,43,-5,3};
         * int min = Integer.MAX_VALUE;
         * for(int i=0;i<arr.length;i++){
         * if(min > arr[i]){
         * min = arr[i];
         * }
         * }
         * System.out.println("gia tri nho nhat cua arr la : "+min);
         * 
         * cau6
         * int[] arr = {32,54,1,43,-5,3};
         * Random rand = new Random();
         * int index = rand.nextInt(arr.length);
         * System.out.println("gia tri tai vi tri index la :"+arr[index]);
         * 
         * 
         * cong 2 ma tran
         */


        int[][] matrixA = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrixB = {{9,8,7},{6,5,4},{3,2,1}};
        
        int[][] tongMatrix = new int[matrixA.length][matrixB.length];
        for(int i=0;i<matrixA.length;i++){
            for(int j=0;j<matrixA.length;j++){
                tongMatrix[i][j] = matrixA[i][j] +matrixB[i][j];
            }
        }
        int count = 3;
        for(int i=0;i<matrixA.length;i++){
            for(int j=0;j<matrixA.length;j++){
                
                if(count < 2){
                    System.out.print(tongMatrix[i][j]);
                    count = tongMatrix.length;
                }else{
                    System.out.print(tongMatrix[i][j]+",");
                    count--;
                }
            }
            System.out.println();
        }


    }
}
