// mảng trong java (array)
class bai1{
    public static void main(String[] args) {
        // khai bao so nguyen
        int[] number;
        // khoi tao mang voi kich thuoc la 3
        number = new int[3];

        // khai bao ky tu va khoi tao kich thuoc
        char[] kyTu = new char[4];

        // khai bao chuoi va khoi tao kich thuoc
        String[] chuoi = new String[5];

        // khai bao mang voi gia tri co san 
        int[] numbers = {1,2,3,4};
        String[] chuois = {"nguquaday","ga qua"};
        char[] kyTus = {'c','t'};

        // cope mang co san
        char[] copyKytu = kyTus.clone();
        int[] copyNumber = number.clone();

        // mang 2 chieu
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(matrix[0][1]); // no se in ra 2
    }
}