using System.Collections;
using System.Collections.Generic;
namespace Generic_
{
    internal class Program
    {
        static void Main(string[] args)
        {
            LinkedList<int> linkedList = new LinkedList<int>();
            LinkedList<String> linkedListT = new LinkedList<String>();
            linkedList.AddFirst(1);
            linkedList.AddFirst(2);  // Danh sách bây giờ là: 2 -> 1
            linkedListT.AddFirst("dang cap");
            linkedListT.AddFirst("ga que");


            int a = linkedList.First.Value;              // a = 2
            int b = linkedList.First.Next.Value;         // b = 1
            string c = linkedListT.First.Value;          // ga que
            string d = linkedListT.First.Next.Value;     // dang cap

            Console.WriteLine($"Before swap: a = {a}, b = {b}");
            Console.WriteLine($"Before swap: c = {c}, d = {d}");

            Swap(ref a, ref b);
            Swap(ref c, ref d);

            Console.WriteLine($"After swap: a = {a}, b = {b}");
            Console.WriteLine($"After swap: c = {c}, d = {d}");
        }

        public static void Swap<T>(ref T a, ref T b)
        {
            T temp = a;
            a = b;
            b = temp;
        }
    }
}


// Generic is Common data type
// benefit
// 

/*
 vocabulary 
    Common : chung
    benefit : loi ich
 */