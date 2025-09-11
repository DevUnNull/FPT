using System.Collections.Generic;
namespace List_
{
    internal class Program
    {
        static void Main(string[] args)
        {
            List<int> MyList = new List<int>();
            MyList.Add(1);
            MyList.Add(2);


            // this here will copy all element of MyList 
            List<int> MyList2 = new List<int>(MyList);

            // example for InsertRange-------------------------
            List<int> originalList = new List<int> { 1, 2, 3, 6 };
            List<int> originalListClone = new List<int>(originalList);
            List<int> newItems = new List<int> { 4, 5 };
            List<int> newItems2 = new List<int> { 5,4 };

            originalListClone.AddRange(newItems2);
            Printf(originalListClone);
            Console.WriteLine();
            originalList.InsertRange(3, newItems);
            Printf(originalList);

            
            //out put : { 1, 2, 3, 4, 5, 6 }
            //--------------------------------------------------
        }

        static void Printf<T>(IEnumerable<T> t)
        {
            foreach (T item in t)
            {
                Console.Write(item);
            }
        }

    }
}
