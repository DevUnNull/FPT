using System.Collections;

namespace Sorted_List
{
    internal class Program
    {
        static void Main(string[] args)
        {
            SortedList<int, string> students = new SortedList<int, string>();

            // add element
            students.Add(2, "Alice");
            students.Add(1, "Bob");
            students.Add(3, "Charlie");

            // traverse in key order (order : trật tự , thứ tự sắp xếp)
            foreach (var pair in students)
            {
                Console.WriteLine($"Key: {pair.Key}, Value: {pair.Value}");
            }

            // access by key
            Console.WriteLine(students[1]); // Bob

            // access by value
            Console.WriteLine(students.Values[0]); // Bob

            // delete element
            students.Remove(2);

            // check if a key exists (exists : tồn tại)
            if (students.ContainsKey(3))
            {
                Console.WriteLine("Found key 3");
            }


        }
    }

    internal class Sort_SortedList
    {

    }
}


// what SortedList different compared to HashTable 
/*
| Feature                  | `Hashtable`                             | `SortedList`                                         
| ------------------------ | --------------------------------------- | ---------------------------------------------------- 
| **Namespace**            | `System.Collections`                    | `System.Collections.Generic` or `System.Collections` 
| **Key-Value Storage**    | ✅ Yes                                  | ✅ Yes                                              
| **Ordering**             | ❌ **No order** – entries are unordered | ✅ **Sorted** by key (ascending)                   
| **Key Type**             | Keys must be hashable                   | Keys must be comparable (IComparable)                
| **Access by Index**      | ❌ Not supported                        | ✅ Can access by **index** (position in sort order)
| **Generic Support**      | ❌ Non-generic (uses `object`)          | ✅ Generic (`SortedList<TKey, TValue>`)            
| **Performance (Lookup)** | Fast – O(1) average time                | Slower – O(log n) because of sorting                 
| **Null Keys**            | ✅ Allowed                              | ❌ Not allowed (throws exception)                    
| **Use Case**             | When you need fast lookup without order | When you need sorted keys and index access           

 */