using System;
using System.Collections;

namespace Array_List
{
    internal class Program
    {
        static void Main(string[] args)
        {
            ArrayList arrayList1 = new ArrayList(); // this will Initialize empty ArrayList

            ArrayList arrayList2 = new ArrayList(5); // this will Initialize ArrayList with an initial capacity of 5

            /*Initialize an ArrayList have Capacity equal arrayList2
              copy all element from arrayList2 into arrayList3
             */
            ArrayList arrayList3 = new ArrayList(arrayList2);
            
            // why Should't we do it like this , Because if we do it this way , arrayList4 will share the same memory reference with arrayList2 . As a result, if arrayList2 is modified , arrayList4 will also be affected
            ArrayList arrayList4 = arrayList2;

            arrayList1.Add(new Person(2, "ngu"));
            arrayList1.Add(new Person(1, "dan"));
            arrayList1.Add(new Person(4, "dot"));
            arrayList1.Add(new Person(3, "ga"));
            foreach (var item in arrayList1)
            {
                Console.WriteLine(item);
            }

            Console.WriteLine();
            arrayList1.Sort();

            foreach (var item in arrayList1)
            {
                Console.WriteLine(item);
            }
        }
    }

    internal class Person : IComparable
    {
        private int id;
        private string name;

        public Person(int id, string name)
        {
            this.id = id;
            this.name = name;
        }

        public override string ToString()
        {
            return $"ID: {id}, Name: {name}";
        }

        public int CompareTo(object? obj)
        {
            Person other = obj as Person;
            if (other == null) return 1;

            return this.id.CompareTo(other.id);
            // Trả về:
            // < 0 nếu this nhỏ hơn other
            // = 0 nếu bằng nhau
            // > 0 nếu this lớn hơn other
            // result > 0 → a đứng sau b → đổi chỗ
            // result < 0 → a đứng trước b → giữ nguyên
        }


    }

}

/*
    Initialize : khởi tạo
    Initial : ban đầu
    Capacity : dung tích
    Empty : trống
    As a : do đó 
    Memory Reference : tham chiếu bộ nhớ 
    Result : kết quả 
    modified : thay đổi
    affected : ảnh hưởng
*/