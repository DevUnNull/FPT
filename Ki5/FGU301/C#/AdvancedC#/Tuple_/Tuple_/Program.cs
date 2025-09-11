using System;
using System.Data;

namespace Tuple_
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Cách 1: Dùng tuple mới (C# 7.0+)
            (string name, int hp, bool isAlive) myTuple1 = ("Hero", 100, true);

            // Cách 2: Dùng Tuple cổ điển
            var myTuple2 = Tuple.Create("Enemy", 200, false);
            var myTuple3 = new Tuple<int, string>(2, "Hai");
            var myTuple4 = Tuple.Create<int, string>(4, "Tuan");

            Console.WriteLine(myTuple1);
            Console.WriteLine(myTuple2);
            Console.WriteLine(myTuple3);
            Console.WriteLine(myTuple4);
            
            Console.WriteLine("ID: {0} , Name: {1}", myTuple3.Item1, myTuple3.Item2);

            Console.WriteLine("Bai tap:");
            var now = GetCurrentDayMonthYear();
            Console.WriteLine("Day: {0}, Month: {1}, Year: {2}", now.Item1, now.Item2, now.Item3);
            Console.Write("Time: "); // In sẵn 1 dòng để cập nhật sau
            var position = Console.GetCursorPosition();
            while (true)
            {
                string timeNow = DateTime.Now.ToString("HH:mm:ss");
                Console.SetCursorPosition(position.Left, position.Top);
                Console.Write(timeNow);

                Thread.Sleep(1000);
            }
        }
        

        static Tuple<int, int, int, String> GetCurrentDayMonthYear()
        {
            DateTime dateTime = DateTime.Now;
            return new Tuple<int, int, int, String>(
                dateTime.Day, 
                dateTime.Month,
                dateTime.Year,
                dateTime.ToString("HH:mm:ss")
            );
        }
    }
}


// Tuple will help we don't need create new class , but should only be used when the new Object is rarely used


/*vocabulary
 * - rarely : it, hiem khi
 * - should : nen
 * 
 */

//kiến thức tự tìm hiểu cách lấy vị trí của chữ trong c#
/*
    - var position = Console.GetCursorPosition();
        -> Trả về vị trí hiện tại của con trỏ trên màn hình console

    - Console.SetCursorPosition(10, 5);         // chuyển con trỏ tới cột 10, dòng 5
        -> Console.Write("Xin chào");           // in ra chữ tại vị trí đó

    - Console.SetCursorPosition(position.Left, position.Top);
        -> Đặt con trỏ in về vị trí tùy ý trong màn hình console, từ đó Console.Write() sẽ in ngay tại vị trí đó.
        -> vị trí left là vị trí số 0 từ trái sang phải sau chữ Time: và Top là từ trên xuống vị trí 0 tính từ Time:
        -> tại sao lại sau chữ Time: -> bởi vì mình đã đặt con trỏ ngay sau chữ Time: nên nó sẽ tính từ đó 
 */