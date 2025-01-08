public class Main {
    public static int[] arr;  // Mảng để lưu dãy Fibonacci

    // Phương thức đệ quy để tìm số Fibonacci
    public static int findFibonacci(int fib) {
        //(base case)
        if (fib <= 1) {
            return fib;  // Trả về 0 hoặc 1 cho các số Fibonacci đầu tiên
        }//(recursive call)
        return findFibonacci(fib - 1) + findFibonacci(fib - 2);  // Tính Fibonacci bằng đệ quy
    }

    // Phương thức để thêm các số Fibonacci vào mảng arr
    public static void addFibonacciToArr(int fib) {
        arr = new int[fib];  // Khởi tạo mảng arr với kích thước là fib
        //arr[0] = 0;  // Số Fibonacci đầu tiên
        //if (fib > 1) {
        //    arr[1] = 1;  // Số Fibonacci thứ hai
        //}
        for (int i = 0; i < fib; i++) {
            arr[i] = findFibonacci(i);  // Tính các số Fibonacci tiếp theo và thêm vào mảng
        }
    }

    // Phương thức hiển thị dãy Fibonacci từ mảng arr
    public static void displayFibonacci(int fib) {
        for (int i = 0; i < fib; i++) {
            if(i<fib-1){
                System.out.print(arr[i] + ", ");  // In từng số Fibonacci ra màn hình
            }else{
                System.out.print(arr[i]);
            }
            
        }
        System.out.println();  // Xuống dòng sau khi in xong
    }

    public static void main(String[] args) {
        int fib = 5;  // Số lượng số Fibonacci cần tính

        // Bước 1: Thêm 45 số Fibonacci vào mảng
        addFibonacciToArr(fib);

        // Bước 2: Hiển thị 45 số Fibonacci ra màn hình
        displayFibonacci(fib);
    }
}
